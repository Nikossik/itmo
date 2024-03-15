package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
/**
 * Команда для очистки коллекции билетов.
 * Удаляет все элементы из коллекции.
 */
public class ClearCommand extends Command {
    /**
     * Конструктор для команды очистки коллекции.
     *
     * @param ticketCollection Коллекция, которая будет очищена.
     */
    public ClearCommand(TicketCollection ticketCollection) {
        super("clear", "Очищает коллекцию", ticketCollection);
    }
    /**
     * Выполняет команду очистки коллекции.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        if (ticketCollection != null && !ticketCollection.getTickets().isEmpty()) {
            ticketCollection.getTickets().clear();
            System.out.println("Коллекция успешно очищена.");
        } else {
            System.out.println("Коллекция уже пуста или не инициализирована.");
        }
    }
}
