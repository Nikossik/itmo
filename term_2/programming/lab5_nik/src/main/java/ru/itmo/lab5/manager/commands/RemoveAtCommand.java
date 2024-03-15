package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;

/**
 * Команда для удаления элемента коллекции по указанному индексу.
 */
public class RemoveAtCommand extends Command {
    /**
     * Конструктор команды remove_at.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public RemoveAtCommand(TicketCollection ticketCollection) {
        super("remove_at <index>", "Удаляет элемент из коллекции по его индексу", ticketCollection);
    }
    /**
     * Выполняет команду удаления элемента по указанному индексу.
     *
     * @param args Аргументы команды, содержащие индекс элемента для удаления.
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isEmpty()) {
            System.out.println("Необходимо указать индекс элемента для удаления. Использование: remove_at <index>");
            return;
        }

        int index;
        try {
            index = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Индекс должен быть целым числом. Передано неверное значение: " + args[1]);
            return;
        }

        try {
            if (ticketCollection.removeAt(index)) {
                System.out.println("Элемент с индексом " + index + " был успешно удален из коллекции.");
            } else {
                System.out.println("Элемент с таким индексом не найден.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс выходит за пределы коллекции. Передано неверное значение: " + index);
        }
    }
}
