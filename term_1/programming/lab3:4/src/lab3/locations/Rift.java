package lab3.locations;

import java.util.Objects;

public class Rift {
    private String description;

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Спереди "+ description+ " расщелина." );
    }

    @Override
    public String toString() {
        return "Расщелина{" +
                "характеристика=" + this.description +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rift rift = (Rift) o;
        return Objects.equals(this.description, rift.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description);
    }

}

