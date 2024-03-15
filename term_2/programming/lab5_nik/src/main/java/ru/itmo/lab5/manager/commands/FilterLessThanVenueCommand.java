package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;
/**
 * Команда для вывода элементов коллекции, чьи места проведения имеют вместимость меньше заданной.
 */
public class FilterLessThanVenueCommand extends Command {
    /**
     * Конструктор команды filter_less_than_venue.
     *
     * @param ticketCollection Коллекция билетов, с которой работает команда.
     */
    public FilterLessThanVenueCommand(TicketCollection ticketCollection) {
        super("filter_less_than_venue <venue_capacity>", "Выводит элементы, значение поля venue которых меньше заданного", ticketCollection);
    }
    /**
     * Выполняет фильтрацию и выводит элементы коллекции, удовлетворяющие условию.
     *
     * @param args Аргументы команды, содержащие значение вместимости для сравнения.
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2 || args[1].isEmpty()) {
            System.out.println("Необходимо указать значение для сравнения. Использование: '" + getName() + "'");
            return;
        }

        int venueCapacity;
        try {
            venueCapacity = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть целым числом. Передано неверное значение: " + args[1]);
            return;
        }

        ticketCollection.getTickets().stream()
                .filter(ticket -> ticket.getVenue() != null && ticket.getVenue().getCapacity() < venueCapacity)
                .forEach(ticket -> System.out.println(ticket));
    }
}
