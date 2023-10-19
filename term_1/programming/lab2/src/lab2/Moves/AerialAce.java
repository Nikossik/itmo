package lab2.Moves;
import ru.ifmo.se.pokemon.*;


public class AerialAce extends PhysicalMove {
    public AerialAce() {
        super(Type.FLYING, 60, Float.POSITIVE_INFINITY);
    }

    @Override
    protected void applyOppDamage(Pokemon opponent, double damage) {
        opponent.setMod(Stat.HP, (int) damage);
    }

    @Override
    protected String describe() {
        return "использует Aerial Ace";
    }
}


