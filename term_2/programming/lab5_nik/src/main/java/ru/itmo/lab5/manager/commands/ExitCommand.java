package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
/**
 * Команда для завершения работы программы.
 */
public class ExitCommand extends Command {

    /**
     * Конструктор команды exit.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public ExitCommand(TicketCollection ticketCollection) {
        super("exit", "Завершает программу", ticketCollection);
    }
    /**
     * Выполняет команду выхода из программы.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Завершение работы программы...");
        System.exit(0);
    }
}
