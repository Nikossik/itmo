package lab3;

import java.util.Objects;

public class Location {
    private Footprints footprints;
    private Rift rift;
    private PipeSound pipeSound;
    private GasolineSmell gasolineSmell;
    private boolean hasObstacle;
    private boolean hasLight;

    public Location(Footprints footprints, Rift rift, PipeSound pipeSound, GasolineSmell gasolineSmell, boolean hasObstacle, boolean hasLight) {
        this.footprints = footprints;
        this.rift = rift;
        this.pipeSound = pipeSound;
        this.gasolineSmell = gasolineSmell;
        this.hasObstacle = hasObstacle;
        this.hasLight = hasLight;
    }

    public void checkForFootprints(String description) {
        if (footprints != null) {
            footprints.describe(description);
        } else {
            System.out.println("Следов нет.");
        }
    }

    public void hasLight() {
        if (hasLight) {
            System.out.println("Есть свет.");
        } else {
            System.out.println("Света нет.");
        }
    }

    public void checkForRift(String description) {
        if (rift != null) {
            rift.describe(description);
        } else {
            System.out.println("Расщелины нет.");
        }
    }

    public void listenForPipeSound(String description) {
        if (pipeSound != null) {
            pipeSound.describe(description);
        } else {
            System.out.println("Трубных звуков нет.");
        }
    }

    public void smellForGasoline(String description) {
        if (gasolineSmell != null) {
            gasolineSmell.describe(description);
        } else {
            System.out.println("Запаха бензина нет.");
        }
    }

    public void checkForObstacle() {
        if (hasObstacle) {
            System.out.println("Впереди препятствие.");
        } else {
            System.out.println("Препятствий нет.");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(footprints, location.footprints) &&
                Objects.equals(rift, location.rift) &&
                Objects.equals(pipeSound, location.pipeSound) &&
                Objects.equals(gasolineSmell, location.gasolineSmell) &&
                Objects.equals(hasObstacle, location.hasObstacle) &&
                Objects.equals(hasLight, location.hasLight);
    }


    @Override
    public int hashCode() {
        return Objects.hash(footprints, rift, pipeSound, gasolineSmell, hasObstacle, hasLight);
    }

    @Override
    public String toString() {
        return "Location{" +
                "Следы=" + footprints.toString() +
                ", Расщелина=" + rift.toString() +
                ", Звук_трубы=" + pipeSound.toString() +
                ", Запах_бензина=" + gasolineSmell.toString() +
                ", Препятствие=" + hasObstacle +
                ", Свет=" + hasLight +
                '}';
    }
}

