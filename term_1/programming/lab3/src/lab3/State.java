package lab3;

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
        return description;
    }
}

