package lab2.Moves;
import ru.ifmo.se.pokemon.*;
public class BubbleBeam extends SpecialMove {
    public BubbleBeam() {
        super(Type.WATER, 65, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon opponent) {
        super.applyOppEffects(opponent);
        Effect f = new Effect().chance(0.1).stat(Stat.SPEED, -1);
        opponent.addEffect(f);
    }
    @Override
    protected void applyOppDamage(Pokemon opponent, double damage) {
        opponent.setMod(Stat.HP, (int) damage);
    }

    @Override
    protected String describe() {
        return "использует Bubble Beam";
    }
}
