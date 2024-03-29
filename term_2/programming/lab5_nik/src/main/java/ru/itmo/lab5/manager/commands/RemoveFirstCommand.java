package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
/**
 * Команда для удаления первого элемента из коллекции.
 */
public class RemoveFirstCommand extends Command {
    /**
     * Конструктор команды remove_first.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public RemoveFirstCommand(TicketCollection ticketCollection) {
        super("remove_first", "Удаляет первый элемент из коллекции", ticketCollection);
    }
    /**
     * Выполняет команду удаления первого элемента из коллекции.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        if (ticketCollection.getTickets().isEmpty()) {
            System.out.println("Коллекция уже пуста.");
        } else {
            ticketCollection.getTickets().remove(0);
            System.out.println("Первый элемент коллекции успешно удален.");
        }
    }
}
