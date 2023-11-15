package lab3;

import java.util.Objects;

public class PipeSound {
    private String description;

    public PipeSound() {
    }

    public void describe(String description) {
        this.description = description;
        System.out.println("Слышен " + description + " звук трубы.");
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PipeSound pipeSound = (PipeSound) obj;
        return description == pipeSound.description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Звук_трубы{" +
                "характеристика=" + description +
                '}';
    }
}
