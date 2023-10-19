package lab2.Pokemons;
import lab2.Moves.*;

public class Gogoat extends Skiddo {
    public Gogoat(String name, int level) {
        super(name, level);
        super.setStats(123, 100, 62, 97, 81, 68);

        AerialAce aerialAce = new AerialAce();

        addMove(aerialAce);
    }
}
