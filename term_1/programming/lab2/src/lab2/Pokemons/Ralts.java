package lab2.Pokemons;
import lab2.Moves.*;
import ru.ifmo.se.pokemon.*;

public class Ralts extends Pokemon {
    public Ralts(String name, int level) {
        super(name, level);
        super.setStats(28, 25, 25, 45, 35, 40);
        super.setType(Type.PSYCHIC, Type.FAIRY);

        DazzlingGleam dazzlingGleam = new DazzlingGleam();
        DrainingKiss drainingKiss = new DrainingKiss();

        setMove(dazzlingGleam, drainingKiss);
    }
}
