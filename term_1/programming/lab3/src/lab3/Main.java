package lab3;

import lab3.creatures.Explorer;
import lab3.creatures.Flashlight;
import lab3.creatures.Monster;
import lab3.creatures.State;
import lab3.locations.*;

public class Main {
    public static void main(String[] args) {
        //фонарь
        Flashlight flashlight1 = new Flashlight();
        Flashlight flashlight2 = new Flashlight();

        // Создание персонажей
        Explorer explorer1 = new Explorer("Денфорт", State.EXPLORING , flashlight1);
        Explorer explorer2 = new Explorer("Исследователь", State.EXPLORING, flashlight2);
        Monster monster = new Monster("Неизвестное создание", State.CALM);

        // Создание объектов окружения
        PipeSound pipeSound = new PipeSound();
        Rift rift = new Rift();
        Footprints footprints = new Footprints();
        GasolineSmell gasolineSmell = new GasolineSmell();

        // Создание локации
        Location location = new Location(footprints, rift, pipeSound, gasolineSmell, true, true);

        //действия

        monster.sneak();

        explorer1.feel(State.IN_DANGER);
        explorer2.feel(State.IN_DANGER);

        explorer1.turnOn();
        explorer2.turnOn();

        explorer1.move();
        explorer2.move();

        explorer1.feel(State.EXPLORING);
        explorer2.feel(State.EXPLORING);


        explorer1.remind("о следах");
        location.checkForFootprints("подозрительные");
        explorer1.remind("о звуках");
        location.listenForPipeSound("слабые");

        explorer1.react("звуки");
        explorer2.react("лагерь");

        explorer1.turnOff();
        explorer2.turnOff();

        location.hasLight();
        explorer1.discover("свет сверху");

        explorer1.move();
        explorer2.move();

        location.smellForGasoline("сильный");
        explorer1.feel(State.UNCOMFORTABLE);
        explorer2.feel(State.UNCOMFORTABLE);

        location.checkForObstacle();
        explorer2.discover("тупик впереди");
        location.checkForRift("глубокая");

        explorer1.feel(State.SCARED);
        explorer2.feel(State.SCARED);



    }
}

