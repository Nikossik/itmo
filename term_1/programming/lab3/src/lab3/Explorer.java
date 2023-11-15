package lab3;

import java.util.Objects;

public class Explorer extends Creature {
    private Flashlight flashlight;
    private String name;

    public Explorer(String name, State state, Flashlight flashlight) {
        super(name, state);
        this.name = name;
        this.flashlight = flashlight;
    }

    @Override
    public void move() {
        System.out.println(name + " осторожно двигается вперёд.");
    }

    @Override
    public void react(String situation) {
        switch (situation.toLowerCase()) {
            case "звуки":
                System.out.println(name + " догадывается, что странные звуки могут быть признаком опасности.");
                break;
            case "лагерь":
                System.out.println(name + " предполагает, что покинутый лагерь может быть с этим связан.");
                break;
            case "следы":
                System.out.println(name + " предполагает, что следы могут принадлежать нечему или кому-то неизвестному.");
                break;
            case "запах бензина":
                System.out.println(name + " замечает запах бензина и думает, что это может быть следствием утечки топлива.");
                break;
            default:
                System.out.println(name + " не уверен, как реагировать на ситуацию: " + situation);
                break;
        }
    }

    public void remind(String msg) {
        System.out.println(name + " напоминает " + msg);
    }

    public void turnOn() {
        flashlight.turnOn();
        System.out.println(name + " включил фонарик.");
    }

    public void turnOff() {
        flashlight.turnOff();
        System.out.println(name + " выключил фонарик.");
    }

    public void discover(String discovery) {
        System.out.println(name + " обнаружил " + discovery);
    }

    public void feel(State state) {
        this.state = state;
        switch (state) {
            case SCARED:
                System.out.println(name + " испуган.");
                break;
            case IN_DANGER:
                System.out.println(name + " ощущает себя в опасности.");
                break;
            case EXPLORING:
                System.out.println(name + " чувствует любопытство.");
                break;
            case UNCOMFORTABLE:
                System.out.println(name + " неприятно себя чувствует.");
                break;
            case CALM:
            default:
                System.out.println(name + " в нормальном состоянии.");
                break;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Explorer explorer = (Explorer) obj;
        return Objects.equals(flashlight, explorer.flashlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flashlight);
    }

    @Override
    public String toString() {
        return "Исследователь {" +
                "имя='" + name + '\'' +
                ", состояние=" + state +
                ", фонарик=" + flashlight +
                '}';
    }
}

