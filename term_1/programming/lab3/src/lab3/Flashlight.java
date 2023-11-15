package lab3;

import java.util.Objects;

public class Flashlight implements LightSource {
    private LightState state;

    @Override
    public void turnOn() {
        state = LightState.ON;
    }

    @Override
    public void turnOff() {
        state = LightState.OFF;
    }

    @Override
    public LightState checkState() {
        return state;
    }

    @Override
    public String toString() {
        return "Фонарик {" + "включен=" +  state + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Flashlight flashlight = (Flashlight) obj;
        return Objects.equals(state, flashlight.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
