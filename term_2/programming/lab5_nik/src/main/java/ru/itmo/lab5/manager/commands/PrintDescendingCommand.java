package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.data.models.Ticket;

import java.util.Comparator;
/**
 * Команда для вывода элементов коллекции в порядке убывания цены.
 */
public class PrintDescendingCommand extends Command {
    /**
     * Конструктор команды print_descending.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public PrintDescendingCommand(TicketCollection ticketCollection) {
        super("print_descending", "Выводит элементы коллекции в порядке убывания", ticketCollection);
    }
    /**
     * Выполняет команду вывода элементов коллекции в порядке убывания цены.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        if (ticketCollection.getTickets().isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else {
            ticketCollection.getTickets().stream()
                    .sorted(Comparator.comparing(Ticket::getPrice).reversed())
                    .forEach(ticket -> System.out.println(ticket));
            System.out.println("Элементы коллекции выведены в порядке убывания.");
        }
    }
}
