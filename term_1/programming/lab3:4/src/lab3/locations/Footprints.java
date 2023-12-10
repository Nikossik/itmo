package lab3.locations;

import java.util.Objects;

public class Footprints {
    private String description;

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Есть " + description + " следы.");
    }

    @Override
    public String toString() {
        return "Следы{" +
                "характеристика=" + this.description +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footprints footprints = (Footprints) o;
        return Objects.equals(this.description, footprints.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description);
    }






}

