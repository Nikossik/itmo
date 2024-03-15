package ru.itmo.lab5.manager.commands;

import ru.itmo.lab5.data.TicketCollection;

public abstract class Command {
    protected String name;
    protected String description;
    protected TicketCollection ticketCollection;

    public Command(String name, String description, TicketCollection ticketCollection) {
        this.name = name;
        this.description = description;
        this.ticketCollection = ticketCollection;
    }

    public abstract void execute(String[] args);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
