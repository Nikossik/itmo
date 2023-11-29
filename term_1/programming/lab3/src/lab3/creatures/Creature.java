package lab3.creatures;

public abstract class Creature {
    protected String name;
    protected State state;

    public Creature(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public abstract void react(String situation);
    public abstract void move();
}

