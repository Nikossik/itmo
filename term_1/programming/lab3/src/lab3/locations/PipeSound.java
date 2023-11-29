package lab3.locations;

import java.util.Objects;

public class PipeSound {
    private String description;

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Слышен " + description + " звук трубы.");
    }

    @Override
    public String toString() {
        return "Звук_трубы{" +
                "характеристика=" + this.description +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PipeSound pipeSound = (PipeSound) o;
        return Objects.equals(this.description, pipeSound.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description);
    }

}
