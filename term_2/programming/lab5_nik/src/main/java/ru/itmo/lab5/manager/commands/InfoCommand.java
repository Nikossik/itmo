package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;

import java.time.format.DateTimeFormatter;
/**
 * Команда для вывода информации о коллекции билетов.
 */
public class InfoCommand extends Command {
    /**
     * Конструктор команды info.
     *
     * @param ticketCollection Коллекция билетов, о которой выводится информация.
     */
    public InfoCommand(TicketCollection ticketCollection) {
        super("info", "Выводит информацию о коллекции", ticketCollection);
    }
    /**
     * Выводит детальную информацию о коллекции, включая ее тип, количество элементов, дату инициализации и последнего сохранения.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("Информация о коллекции:");
        System.out.println("Тип коллекции: " + ticketCollection.getTickets().getClass().getName());
        System.out.println("Количество элементов: " + ticketCollection.getTickets().size());
        if (ticketCollection.getInitializationDate() != null) {
            System.out.println("Дата инициализации коллекции: " + ticketCollection.getInitializationDate().format(formatter));
        } else {
            System.out.println("Дата инициализации неизвестна.");
        }
        if (ticketCollection.getLastSaveTime() != null) {
            System.out.println("Дата последнего сохранения: " + ticketCollection.getLastSaveTime().format(formatter));
        } else {
            System.out.println("Коллекция ещё не сохранялась.");
        }
    }
}
