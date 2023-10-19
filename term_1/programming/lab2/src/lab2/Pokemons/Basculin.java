package lab2.Pokemons;
import lab2.Moves.*;
import ru.ifmo.se.pokemon.*;

public class Basculin extends Pokemon {
    public Basculin(String name, int level) {
        super(name, level);
        super.setStats(70, 92, 65, 80, 55, 98);
        super.setType(Type.WATER);

        Waterfall waterfall = new Waterfall();
        Facade facade = new Facade();
        Agility agility = new Agility();
        BubbleBeam bubbleBeam = new BubbleBeam();

        setMove(waterfall, facade, agility, bubbleBeam);
    }
}
