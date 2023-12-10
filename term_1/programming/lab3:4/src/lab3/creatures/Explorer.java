package lab3.creatures;

import lab3.exceptions.CustomCheckedException;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Explorer extends Creature implements CreatureMovement {
    private final Flashlight flashlight;
    private final List<String> journalEntries;

    public Explorer(String name, State state, Flashlight flashlight) {
        super(name, state);
        this.flashlight = flashlight;
        this.journalEntries = new ArrayList<>();
    }

    //Не статичный вложенный класс
    public class ExplorationJournal {
        private final List<String> journalEntries;

        public ExplorationJournal() {
            this.journalEntries = new ArrayList<>();
        }

        public void addEntry(String message) {
            String entry = "Имя: " + Explorer.this.name + ", Состояние: " + Explorer.this.state +
                    ", Заметка: " + message;
            journalEntries.add(entry);
            System.out.println("Запись добавлена в журнал: " + entry);
        }

        public void printJournal() {
            System.out.println("Журнал исследователя " + Explorer.this.name + ":");
            for (String entry : journalEntries) {
                System.out.println(entry);
            }
        }
    }


    // Анонимный класс
    public void exploreArea() {
        final String explorerName = this.name;

        Runnable areaAnalysisTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(explorerName + " начинает анализ местности.");
                identifyTerrain();
                searchForTraces();
                analyzeEnvironmentalConditions();
            }

            private void identifyTerrain() {
                System.out.println("Определяем тип местности...");
                System.out.println("Тип местности: горная местность.");
            }

            private void searchForTraces() {
                System.out.println("Ищем следы на местности...");
                System.out.println("Обнаружены следы неизвестного происхождения.");
            }

            private void analyzeEnvironmentalConditions() {
                System.out.println("Анализируем условия окружающей среды...");
                System.out.println("Условия среды: повышенная влажность, температура около 10 градусов Цельсия.");
            }
        };

        areaAnalysisTask.run();
    }



    // Статический вложенный класс
    public static class ExplorationToolkit {
        private static final List<String> tools = new ArrayList<>();
        private static final int MAX_TOOLS = 5;

        static {
            tools.add("Карта");
            tools.add("Компас");
            tools.add("Инструменты для сбора образцов");
        }

        public static void prepareKit() {
            System.out.println("Подготовка комплекта исследователя.");
            for (String tool : tools) {
                System.out.println("Добавлен инструмент: " + tool);
            }
        }

        public static void addTool(String tool) throws CustomCheckedException {
            if (tools.size() >= MAX_TOOLS) {
                throw new CustomCheckedException("Невозможно добавить больше инструментов. Максимальное количество: " + MAX_TOOLS);
            }
            tools.add(tool);
            System.out.println("Добавлен дополнительный инструмент: " + tool);
        }
    }


    // Локальный класс
    public void markCheckpoint(String description) {
        class Checkpoint {
            private final Date timestamp;
            private final String description;

            public Checkpoint(String description) {
                this.timestamp = new Date(); // Получаем текущее время и дату
                this.description = description;
            }

            public void displayDetails() {
                System.out.println("Контрольная точка: " + timestamp + ", Описание: " + description);
            }
        }

        Checkpoint checkpoint = new Checkpoint(description);
        checkpoint.displayDetails();
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

    public void turnOn() throws CustomCheckedException {
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
                ", журнал=" + this.journalEntries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Explorer explorer = (Explorer) o;
        return Objects.equals(this.name, explorer.name) &&
                this.state == explorer.state &&
                this.flashlight.equals(explorer.flashlight) &&
                this.journalEntries.equals(explorer.journalEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.state, this.flashlight, this.journalEntries);
    }
}

