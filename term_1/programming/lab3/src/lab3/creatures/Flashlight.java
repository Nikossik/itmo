package lab3.creatures;

import lab3.locations.LightSource;
import lab3.locations.LightState;

import java.util.Objects;

public class Flashlight implements LightSource {
    private LightState state;

    @Override
    public void turnOn() {
        this.state = LightState.ON;
    }

    @Override
    public void turnOff() {
        this.state = LightState.OFF;
    }

    @Override
    public String toString() {
        return "Фонарик {" + "включен=" +  this.state + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashlight flashlight = (Flashlight) o;
        return this.state == flashlight.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.state);
    }
}
