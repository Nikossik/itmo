package lab3;

import java.util.Objects;

public class GasolineSmell {
    private String description;

    public GasolineSmell() {
    }

    public void describe(String description) {
        this.description = description;
        System.out.println("Чувствуется " + description + " запах бензина.");
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
        GasolineSmell gasolineSmell = (GasolineSmell) obj;
        return Objects.equals(description, gasolineSmell.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Запах_бензина{" +
                "характеристика=" + description +
                '}';
    }
}

