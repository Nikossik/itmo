package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.manager.CommandInvoker;
/**
 * Команда для вывода справки по доступным командам.
 */

public class HelpCommand extends Command {
    private final CommandInvoker commandInvoker;
    /**
     * Конструктор команды help.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     * @param commandInvoker Инвокер команд для доступа к списку команд.
     */
    public HelpCommand(TicketCollection ticketCollection, CommandInvoker commandInvoker) {
        super("help", "Выводит справку по доступным командам", ticketCollection);
        this.commandInvoker = commandInvoker;
    }
    /**
     * Выводит список доступных команд и их описания.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Доступные команды:");
        commandInvoker.getCommands().forEach((name, command) -> {
            System.out.println(name + " - " + command.getDescription());
        });
    }
}
