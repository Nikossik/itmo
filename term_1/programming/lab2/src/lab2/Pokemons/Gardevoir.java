package lab2.Pokemons;
import lab2.Moves.*;

public class Gardevoir extends Kirlia {
    public Gardevoir(String name, int level) {
        super(name, level);
        super.setStats(68, 65, 65, 125, 115, 80);
        Hypnosis hypnosis = new Hypnosis();

        addMove(hypnosis);
    }
}
