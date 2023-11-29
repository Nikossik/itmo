package lab3.creatures;

import java.util.Objects;

public class Monster extends Creature {

    public Monster(String name, State state) {
        super(name, state);
    }

    @Override
    public void move() {
        System.out.println(this.name + " медленно перемещается в тени...");
    }

    @Override
    public void react(String msg) {
        System.out.println(this.name + " реагирует на " + msg + ", прислушиваясь к звукам и наблюдая за движением.");
    }

    public void sneak() {
        System.out.println(this.name + " крадется, почти не издавая звуков.");
    }

    @Override
    public String toString() {
        return "Monster{name='" + this.name + "'}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return Objects.equals(this.name, monster.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.state);
    }
}

