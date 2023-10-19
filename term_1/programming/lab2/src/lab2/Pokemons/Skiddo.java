package lab2.Pokemons;
import lab2.Moves.*;
import ru.ifmo.se.pokemon.*;

public class Skiddo extends Pokemon {
    public Skiddo(String name, int level) {
        super(name, level);
        super.setStats(66, 65, 48, 62, 57, 52);
        super.setType(Type.GRASS);

        DoubleTeam doubleTeam = new DoubleTeam();
        TakeDown takeDown = new TakeDown();
        LeafBlade leafBlade = new LeafBlade();

        setMove(doubleTeam, takeDown, leafBlade);
    }
}
