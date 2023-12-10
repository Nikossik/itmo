package lab3.locations;

import java.util.Objects;

public class Location {
    private final Footprints footprints;
    private final Rift rift;
    private final PipeSound pipeSound;
    private final GasolineSmell gasolineSmell;
    private final boolean hasObstacle;
    private final boolean hasLight;

    public Location(Footprints footprints, Rift rift, PipeSound pipeSound, GasolineSmell gasolineSmell, boolean hasObstacle, boolean hasLight) {
        this.footprints = footprints;
        this.rift = rift;
        this.pipeSound = pipeSound;
        this.gasolineSmell = gasolineSmell;
        this.hasObstacle = hasObstacle;
        this.hasLight = hasLight;
    }

    public void checkForFootprints(String description) {
        if (this.footprints != null) {
            this.footprints.setDescription(description);
        } else {
            System.out.println("Следов нет.");
        }
    }

    public void hasLight() {
        if (this.hasLight) {
            System.out.println("Есть свет.");
        } else {
            System.out.println("Света нет.");
        }
    }

    public void checkForRift(String description) {
        if (this.rift != null) {
            this.rift.setDescription(description);
        } else {
            System.out.println("Расщелины нет.");
        }
    }

    public void listenForPipeSound(String description) {
        if (this.pipeSound != null) {
            this.pipeSound.setDescription(description);
        } else {
            System.out.println("Трубных звуков нет.");
        }
    }

    public void smellForGasoline(String description) {
        if (this.gasolineSmell != null) {
            this.gasolineSmell.setDescription(description);
        } else {
            System.out.println("Запаха бензина нет.");
        }
    }

    public void checkForObstacle() {
        if (this.hasObstacle) {
            System.out.println("Впереди препятствие.");
        } else {
            System.out.println("Препятствий нет.");
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "Следы=" + this.footprints.toString() +
                ", Расщелина=" + this.rift.toString() +
                ", Звук_трубы=" + this.pipeSound.toString() +
                ", Запах_бензина=" + this.gasolineSmell.toString() +
                ", Препятствие=" + this.hasObstacle +
                ", Свет=" + this.hasLight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return this.hasObstacle == location.hasObstacle &&
                this.hasLight == location.hasLight &&
                Objects.equals(this.footprints, location.footprints) &&
                Objects.equals(this.rift, location.rift) &&
                Objects.equals(this.pipeSound, location.pipeSound) &&
                Objects.equals(this.gasolineSmell, location.gasolineSmell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.footprints, this.rift, this.pipeSound, this.gasolineSmell, this.hasObstacle, this.hasLight);
    }
}

