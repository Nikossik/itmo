package lab2.Moves;

import ru.ifmo.se.pokemon.*;

public class LeafBlade extends PhysicalMove {
    public LeafBlade() {
        super(Type.GRASS, 90, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon opponent, double damage) {
        opponent.setMod(Stat.HP, (int) damage);
    }
    @Override
    protected String describe() {
        return "использует Leaf Blade";
    }
}
