package lab3.creatures;

import java.util.Objects;

public class Explorer extends Creature implements CreatureMovement {
    private final Flashlight flashlight;

    public Explorer(String name, State state, Flashlight flashlight) {
        super(name, state);
        this.flashlight = flashlight;
    }

    @Override
    public void move() {
        System.out.println(this.name + " осторожно двигается вперёд.");
    }

    @Override
    public void react(String situation) {
        switch (situation.toLowerCase()) {
            case "звуки":
                System.out.println(this.name + " догадывается, что странные звуки могут быть признаком опасности.");
                break;
            case "лагерь":
                System.out.println(this.name + " предполагает, что покинутый лагерь может быть с этим связан.");
                break;
            case "следы":
                System.out.println(this.name + " предполагает, что следы могут принадлежать нечему или кому-то неизвестному.");
                break;
            case "запах бензина":
                System.out.println(this.name + " замечает запах бензина и думает, что это может быть следствием утечки топлива.");
                break;
            default:
                System.out.println(this.name + " не уверен, как реагировать на ситуацию: " + situation);
                break;
        }
    }

    @Override
    public void remind(String msg) {
        System.out.println(this.name + " напоминает " + msg);
    }

    public void turnOn() {
        flashlight.turnOn();
        System.out.println(this.name + " включил фонарик.");
    }

    public void turnOff() {
        flashlight.turnOff();
        System.out.println(this.name + " выключил фонарик.");
    }

    @Override
    public void discover(String discovery) {
        System.out.println(this.name + " обнаружил " + discovery);
    }

    @Override
    public void feel(State state) {
        this.state = state;
        switch (state) {
            case SCARED:
                System.out.println(this.name + " испуган.");
                break;
            case IN_DANGER:
                System.out.println(this.name + " ощущает себя в опасности.");
                break;
            case EXPLORING:
                System.out.println(this.name + " чувствует любопытство.");
                break;
            case UNCOMFORTABLE:
                System.out.println(this.name + " неприятно себя чувствует.");
                break;
            default:
                System.out.println(this.name + " в нормальном состоянии.");
                break;
        }
    }

    @Override
    public String toString() {
        return "Исследователь {" +
                "имя='" + this.name + '\'' +
                ", состояние=" + this.state +
                ", фонарик=" + this.flashlight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Explorer explorer = (Explorer) o;
        return Objects.equals(this.name, explorer.name) &&
                this.state == explorer.state &&
                this.flashlight.equals(explorer.flashlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.state, this.flashlight);
    }
}

