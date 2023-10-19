package lab2.Pokemons;
import lab2.Moves.*;


public class Kirlia extends Ralts {
    public Kirlia(String name, int level) {
        super(name, level);
        super.setStats(38, 35, 35, 65, 55, 50);

        Charm charm = new Charm();

        addMove(charm);
    }
}
