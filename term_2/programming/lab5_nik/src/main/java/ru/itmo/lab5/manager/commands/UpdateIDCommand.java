package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.data.models.Ticket;
import ru.itmo.lab5.util.TicketBuilder;

import java.util.Optional;
import java.util.Scanner;
/**
 * Команда для обновления элемента коллекции с указанным ID.
 */
public class UpdateIDCommand extends Command {
    /**
     * Конструктор команды update_id.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     * @param scanner          Сканер для ввода данных пользователем.
     */
    public UpdateIDCommand(TicketCollection ticketCollection, Scanner scanner) {
        super("update_id <id>", "Обновляет значение элемента коллекции, ID которого равен заданному", ticketCollection);
    }
    /**
     * Выполняет команду обновления элемента с указанным ID.
     *
     * @param args Аргументы команды, содержащие ID элемента для обновления.
     */
    @Override
    public void execute(String[] args) {
        if (args[1].isEmpty()) {
            System.out.println("Использование: '" + getName() + "'");
            return;
        }
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("ID должен быть числом. Передано неверное значение: " + args[1]);
            return;
        }

        Optional<Ticket> ticketToUpdate = ticketCollection.getTickets().stream()
                .filter(ticket -> ticket.getId() == id)
                .findFirst();

        if (ticketToUpdate.isPresent()) {
            Ticket updatedTicket = TicketBuilder.buildTicket();
            if (updatedTicket != null) {
                ticketCollection.update(updatedTicket);
                System.out.println("Билет с ID " + id + " был успешно обновлен.");
            } else {
                System.out.println("Ошибка при создании билета. Обновление отменено.");
            }
        } else {
            System.out.println("Билет с таким ID не найден.");
        }
    }
}
