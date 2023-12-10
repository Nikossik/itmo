package lab3.creatures;

public enum State {
    CALM("Спокойный"),
    EXPLORING("Исследующий"),
    IN_DANGER("В опасности"),
    UNCOMFORTABLE("Некомфортно"),
    SCARED("Испуганный");


    private final String description;

    State(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

