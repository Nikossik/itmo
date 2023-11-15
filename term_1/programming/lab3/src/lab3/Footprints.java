package lab3;

import java.util.Objects;

public class Footprints {
    private String description;

    public Footprints() {
    }

    public void describe(String description) {
        this.description = description;
        System.out.println("Есть " + description + " следы.");
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
        Footprints footprints = (Footprints) obj;
        return Objects.equals(description, footprints.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Следы{" +
                "характеристика=" + description +
                '}';
    }
}

