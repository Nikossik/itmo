package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.manager.CommandInvoker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * Команда для выполнения скрипта из указанного файла.
 * Скрипт должен содержать команды в формате, приемлемом для данного интерфейса командной строки.
 */
public class ExecuteScriptCommand extends Command {
    private final CommandInvoker commandInvoker;
    private static final Set<String> scriptHistory = new HashSet<>();
    /**
     * Конструктор для команды выполнения скрипта.
     *
     * @param ticketCollection Коллекция билетов, над которой могут выполняться операции в скрипте.
     * @param commandInvoker Инвокер команд, используемый для выполнения команд из скрипта.
     */
    public ExecuteScriptCommand(TicketCollection ticketCollection, CommandInvoker commandInvoker) {
        super("execute_script", "Выполняет скрипт из указанного файла", ticketCollection);
        this.commandInvoker = commandInvoker;
    }
    /**
     * Выполняет команды из указанного файла скрипта.
     * Предотвращает рекурсивное выполнение скриптов.
     *
     * @param args Аргументы команды, включая путь к файлу скрипта.
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isEmpty()) {
            System.out.println("Необходимо указать путь к файлу скрипта. Использование: execute_script <file_path>");
            return;
        }
        String filePath = args[1];
        if (scriptHistory.contains(filePath)) {
            System.out.println("Обнаружена рекурсия. Выполнение скрипта " + filePath + " прервано.");
            return;
        }

        scriptHistory.add(filePath);
        File scriptFile = new File(filePath);
        try (Scanner scanner = new Scanner(scriptFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] commandArgs = line.split(" ");
                Command command = commandInvoker.getCommands().get(commandArgs[0]);
                if (command != null) {
                    System.out.println("Выполнение команды: " + line);
                    command.execute(commandArgs);
                } else {
                    System.out.println("Неизвестная команда в скрипте: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл скрипта не найден: " + filePath);
        } finally {
            scriptHistory.remove(filePath); // Удаление из истории после выполнения скрипта для возможности повторного запуска
        }
    }
}
