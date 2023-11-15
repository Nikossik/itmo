package lab3;

import java.util.Objects;

public class Rift {
    private String description;

    public Rift() {
    }

    public void describe(String description) {
        this.description = description;
        System.out.println("Спереди "+ description+ " расщелина." );
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
        Rift rift = (Rift) obj;
        return Objects.equals(description, rift.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Расщелина{" +
                "характеристика=" + description +
                '}';
    }
}

