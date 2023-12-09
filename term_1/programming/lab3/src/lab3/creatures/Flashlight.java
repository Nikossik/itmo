package lab3.creatures;

import lab3.exceptions.CustomCheckedException;
import lab3.exceptions.CustomUncheckedException;

import lab3.locations.LightSource;
import lab3.locations.LightState;

import java.util.Objects;

public class Flashlight implements LightSource {
    private LightState state;

    @Override
    public void turnOn() throws CustomCheckedException {
        if (state == LightState.ON) {
            throw new CustomCheckedException("Фонарик уже включен");
        }
        this.state = LightState.ON;
    }

    @Override
    public void turnOff() {
        if (state == LightState.OFF) {
            throw new CustomUncheckedException("Фонарик уже выключен");
        }
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
