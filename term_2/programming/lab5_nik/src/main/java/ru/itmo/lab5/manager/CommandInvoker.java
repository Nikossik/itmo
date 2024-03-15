package ru.itmo.lab5.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.manager.commands.*;

public class CommandInvoker {
    private final Map<String, Command> commandMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final TicketCollection ticketCollection;
    private final DumpManager dumpManager;

    /**
     * Конструктор класса CommandInvoker.
     * Инициализирует новый экземпляр класса с заданной коллекцией билетов и менеджером дампа.
     *
     * @param ticketCollection Коллекция билетов для управления.
     * @param dumpManager Менеджер для работы с файлами сохранения/загрузки коллекции.
     */
    public CommandInvoker(TicketCollection ticketCollection, DumpManager dumpManager) {
        this.ticketCollection = ticketCollection;
        this.dumpManager = dumpManager;

        register("help", new HelpCommand(ticketCollection, this));
        register("info", new InfoCommand(ticketCollection));
        register("show", new ShowCommand(ticketCollection));
        register("add", new AddCommand(ticketCollection));
        register("update_id", new UpdateIDCommand(ticketCollection, scanner));
        register("remove_by_id", new RemoveByIDCommand(ticketCollection));
        register("clear", new ClearCommand(ticketCollection));
        register("save", new SaveCommand(ticketCollection, dumpManager));
        register("execute_script", new ExecuteScriptCommand(ticketCollection, this));
        register("exit", new ExitCommand(ticketCollection));
        register("remove_at", new RemoveAtCommand(ticketCollection));
        register("remove_first", new RemoveFirstCommand(ticketCollection));
        register("add_if_min", new AddIfMinCommand(ticketCollection));
        register("filter_less_than_venue", new FilterLessThanVenueCommand(ticketCollection));
        register("print_descending", new PrintDescendingCommand(ticketCollection));
        register("print_field_descending_venue", new PrintFieldDescendingVenueCommand(ticketCollection));
    }

    /**
     * Регистрирует новую команду в инвокере.
     *
     * @param commandName Имя команды.
     * @param command Объект команды.
     */
    private void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    /**
     * Выполняет команду, указанную пользователем.
     * Ищет команду по её имени и запускает её выполнение.
     *
     * @param args Массив строк, содержащий имя команды и её аргументы.
     */
    public void executeCommand(String[] args) {
        if (args.length == 0) {
            System.out.println("Не указана команда. Введите 'help' для получения списка команд.");
            return;
        }

        Command command = commandMap.get(args[0].toLowerCase());
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Неизвестная команда '" + args[0] + "'. Введите 'help' для получения списка команд.");
        }
    }

    /**
     * Возвращает зарегистрированные команды.
     *
     * @return все команды.
     */
    public Map<String, Command> getCommands() {
        return commandMap;
    }
}
