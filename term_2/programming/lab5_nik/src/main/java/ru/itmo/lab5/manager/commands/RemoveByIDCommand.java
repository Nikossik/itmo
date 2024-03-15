package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;

/**
 * Команда для удаления элемента из коллекции по его ID.
 */
public class RemoveByIDCommand extends Command {
    /**
     * Конструктор команды remove_by_id.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public RemoveByIDCommand(TicketCollection ticketCollection) {
        super("remove_by_id <id>", "Удаляет первый элемент из коллекции", ticketCollection);
    }
    /**
     * Выполняет команду удаления элемента по указанному ID.
     *
     * @param args Аргументы команды, содержащие ID элемента для удаления.
     */
    @Override
    public void execute(String[] args) {
        if (args[1].isEmpty()) {
            System.out.println("Использование: '" + getName() + "'");
            return;
        }
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("ID должен быть числом. Передано неверное значение: " + args[1]);
            return;
        }

        boolean removed = ticketCollection.remove(id);

        if (removed) {
            System.out.println("Элемент с ID " + id + " был успешно удален из коллекции.");
        } else {
            System.out.println("Элемент с таким ID не найден.");
        }
    }
}

