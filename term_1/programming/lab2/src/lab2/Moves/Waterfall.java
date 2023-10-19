package lab2.Moves;
import ru.ifmo.se.pokemon.*;
import lab2.utils.*;
public class Waterfall extends PhysicalMove {
    public Waterfall() {
        super(Type.WATER, 80, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon opponent) {
        super.applyOppEffects(opponent);
        if (RandomUtil.chance(0.2)) {
            Effect.flinch(opponent);
        }
    }

    @Override
    protected void applyOppDamage(Pokemon opponent, double damage) {
        opponent.setMod(Stat.HP, (int) damage);
    }
    @Override
    protected String describe() {
        return "использует Waterfall";
    }
}
