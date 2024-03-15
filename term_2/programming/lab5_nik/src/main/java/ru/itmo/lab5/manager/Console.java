package ru.itmo.lab5.manager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {

    /**
     * Инвокер команд для выполнения операций над коллекцией билетов.
     */
    private final CommandInvoker commandInvoker;

    /**
     * Сканер для чтения команд из стандартного ввода.
     */
    private final Scanner scanner;

    /**
     * Конструктор, инициализирующий Console с заданным инвокером команд.
     *
     * @param commandInvoker Инвокер команд, который будет использоваться для обработки вводимых команд.
     */
    public Console(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Запускает интерактивную сессию командной строки для управления коллекцией билетов.
     * Пользователь вводит команды до тех пор, пока не решит выйти из программы командой 'exit'.
     */
    public void start() {
        try {
            System.out.println("Добро пожаловать в консоль управления билетами. Введите 'help' для получения списка команд.");
            String[] userCommand;
            while (true) {
                System.out.print("> ");
                if (!scanner.hasNextLine()) {
                    handleExit();
                    break;
                }
                String input = scanner.nextLine().trim();
                userCommand = (input + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                if ("exit".equalsIgnoreCase(userCommand[0])) {
                    handleExit();
                }
                try {
                    commandInvoker.executeCommand(userCommand);
                } catch (NoSuchElementException e) {
                    System.out.println("Команда '" + input + "' не найдена. Введите 'help' для помощи");
                }
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("Ошибка ввода. Экстренное завершение программы.");
            safelyExit();
        }
    }

    /**
     * Обрабатывает выход из программы с выполнением команды 'exit'.
     */
    private void handleExit() {
        commandInvoker.executeCommand(new String[]{"exit"});
    }

    /**
     * Выполняет безопасный выход из программы, предварительно сохраняя данные с помощью команды 'save'.
     */
    private void safelyExit() {
        commandInvoker.executeCommand(new String[]{"save"});
        commandInvoker.executeCommand(new String[]{"exit"});
    }
}
