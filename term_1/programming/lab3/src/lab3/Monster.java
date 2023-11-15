package lab3;

import java.util.Objects;

public class Monster extends Creature {
    private String name;


    public Monster(String name, State state) {
        super(name, state);
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " медленно перемещается в тени...");
    }

    @Override
    public void react(String msg) {
        System.out.println(name + " реагирует на " + msg + ", прислушиваясь к звукам и наблюдая за движением.");
    }

    public void sneak() {
        System.out.println(name + " крадется, почти не издавая звуков.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Monster monster = (Monster) obj;
        return Objects.equals(name, monster.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    @Override
    public String toString() {
        return "Monster{name='" + name + "'}";
    }
}

