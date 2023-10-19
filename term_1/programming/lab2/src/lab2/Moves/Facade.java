package lab2.Moves;
import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon opponent, double damage) {
        Status status = opponent.getCondition();
        if (status.equals(Status.BURN) || status.equals(Status.PARALYZE) || status.equals(Status.POISON)) {
            opponent.setMod(Stat.HP, (int) Math.round(damage) * 2);
        }
    }

    @Override
    protected String describe() {
        return "использует Facade";
    }



}
