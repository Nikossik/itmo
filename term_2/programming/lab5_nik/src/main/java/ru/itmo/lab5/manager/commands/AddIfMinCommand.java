package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
import ru.itmo.lab5.data.models.Ticket;
import ru.itmo.lab5.util.TicketBuilder;

import java.util.Comparator;
/**
 * Команда для добавления нового билета в коллекцию, если его цена меньше минимальной в коллекции.
 * Запрашивает у пользователя данные для создания билета и добавляет его в коллекцию при условии.
 */
public class AddIfMinCommand extends Command {
    /**
     * Конструктор для команды добавления билета, если его цена меньше минимальной.
     *
     * @param ticketCollection Коллекция, с которой производится сравнение.
     */
    public AddIfMinCommand(TicketCollection ticketCollection) {
        super("add_if_min", "Добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", ticketCollection);
    }
    /**
     * Выполняет команду добавления билета при выполнении условия минимальности цены.
     *
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String[] args) {
        Ticket newTicket = TicketBuilder.buildTicket();
        if (newTicket == null) {
            System.out.println("Не удалось создать билет. Отмена операции.");
            return;
        }

        Ticket minTicket = ticketCollection.getTickets().stream()
                .min(Comparator.comparing(Ticket::getPrice))
                .orElse(null);

        if (minTicket == null || newTicket.getPrice() < minTicket.getPrice()) {
            ticketCollection.getTickets().add(newTicket);
            System.out.println("Новый билет успешно добавлен в коллекцию.");
        } else {
            System.out.println("Новый билет не является минимальным. Операция добавления не выполнена.");
        }
    }
}
