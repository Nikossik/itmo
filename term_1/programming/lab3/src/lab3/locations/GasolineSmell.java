package lab3.locations;

import java.util.Objects;

public class GasolineSmell {
    private String description;

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Чувствуется " + description + " запах бензина.");
    }

    @Override
    public String toString() {
        return "Запах_бензина{" +
                "характеристика=" + this.description +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasolineSmell gasolineSmell = (GasolineSmell) o;
        return Objects.equals(this.description, gasolineSmell.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description);
    }
}

