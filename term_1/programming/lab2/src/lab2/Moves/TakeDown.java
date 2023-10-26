package lab2.Moves;
import ru.ifmo.se.pokemon.*;

public class TakeDown extends PhysicalMove {
    public TakeDown() {
        super(Type.NORMAL, 90, 85);
    }

    @Override
    protected void applyOppDamage(Pokemon opponent, Pokemon pokemon, double damage) {
        opponent.setMod(Stat.HP, (int) damage);
        pokemon.setMod(Stat.HP, (int) Math.round(damage / 4));
    }

    @Override
    protected String describe() {
        return "использует Take Down";
    }
}
