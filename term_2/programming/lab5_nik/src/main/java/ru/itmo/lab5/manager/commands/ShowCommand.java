package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.data.models.Ticket;
/**
 * Команда для вывода всех элементов коллекции.
 */
public class ShowCommand extends Command {
    /**
     * Конструктор команды show.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public ShowCommand(TicketCollection ticketCollection) {
        super("show", "Выводит все элементы коллекции", ticketCollection);
    }
    /**
     * Выполняет команду вывода всех элементов коллекции.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        if (ticketCollection.getTickets().isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else {
            System.out.println("Элементы коллекции:");
            for (Ticket ticket : ticketCollection.getTickets()) {
                System.out.println(ticket);
            }
        }
    }
}
