package ru.itmo.lab5.system;
import sun.misc.Signal;
import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.manager.CommandInvoker;
import ru.itmo.lab5.manager.Console;
import ru.itmo.lab5.manager.DumpManager;

public class Main {
    private static void setSignalProcessing(String... signalNames) {
        for (String signalName : signalNames) {
            try {
                Signal.handle(new Signal(signalName), signal -> System.out.print("\nДля получения справки введите 'help', для завершения программы введите 'exit'\n"));
            } catch (IllegalArgumentException ignored) {
                // Игнорируем исключение, если сигнал с таким названием уже существует или такого сигнала не существует
            }
        }
    }

    public static void main(String[] args) {
        String filePath = System.getenv("TICKETS_FILE_PATH");
        if (filePath == null || filePath.isEmpty()) {
            System.err.println("Переменная среды 'TICKETS_FILE_PATH' не задана или пуста.");
            return; // Завершаем работу приложения, если путь не задан
        }

        DumpManager dumpManager = new DumpManager(filePath);

        TicketCollection ticketCollection = new TicketCollection(dumpManager);

        CommandInvoker commandInvoker = new CommandInvoker(ticketCollection, dumpManager);

        Console console = new Console(commandInvoker);

        console.start();
        setSignalProcessing(
                "INT", "TERM", "TSTP", "BREAK", "EOF");
    }
}
