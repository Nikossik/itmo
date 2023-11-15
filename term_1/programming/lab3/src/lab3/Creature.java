package lab3;

import java.util.Objects;

public abstract class Creature {
    protected String name;
    protected State state;

    public Creature(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public abstract void react(String situation);
    public abstract void move();



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Creature creature = (Creature) obj;
        return Objects.equals(name, creature.name) && state == creature.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    @Override
    public String toString() {
        return "Существо {" +
                "имя='" + name + '\'' +
                ", состояние=" + state +
                '}';
    }
}

