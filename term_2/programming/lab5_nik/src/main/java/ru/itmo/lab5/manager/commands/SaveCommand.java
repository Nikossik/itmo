package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.manager.DumpManager;
/**
 * Команда для сохранения текущего состояния коллекции в файл.
 */
public class SaveCommand extends Command {
    private final DumpManager dumpManager;
    /**
     * Конструктор команды save.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     * @param dumpManager      Менеджер для работы с файлами, используемый для сохранения коллекции.
     */
    public SaveCommand(TicketCollection ticketCollection, DumpManager dumpManager) {
        super("save", "Сохраняет коллекцию в файл", ticketCollection);
        this.dumpManager = dumpManager;
    }
    /**
     * Выполняет команду сохранения коллекции в файл.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        dumpManager.writeCollection(ticketCollection);
    }
}
