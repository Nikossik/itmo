package lab2.Moves;
import ru.ifmo.se.pokemon.*;

public class DrainingKiss extends SpecialMove {
    public DrainingKiss() {
        super(Type.FAIRY, 50, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon opponent, double damage) {
        opponent.setMod(Stat.HP, (int) damage);
    }


    @Override
    protected String describe() {
        return "использует Draining Kiss";
    }
}

