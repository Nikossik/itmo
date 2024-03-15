package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.models.Ticket;
import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.util.TicketBuilder;

/**
 * Команда для добавления нового билета в коллекцию.
 * Запрашивает у пользователя данные для создания билета и добавляет его в коллекцию.
 */
public class AddCommand extends Command {
    /**
     * Конструктор для команды добавления билета.
     *
     * @param ticketCollection Коллекция, в которую будет добавлен билет.
     */
    public AddCommand(TicketCollection ticketCollection) {
        super("add", "Добавляет новый билет в коллекцию", ticketCollection);
    }
    /**
     * Выполняет команду добавления нового билета в коллекцию.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        try {
            Ticket ticket = TicketBuilder.buildTicket();
            if (ticket.validate()) {
                ticketCollection.add(ticket);
                System.out.println("Билет успешно добавлен.");
            } else {
                System.out.println("Невозможно добавить билет: некорректные данные.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении билета: " + e.getMessage());
        }
    }
}
