package lab2.Moves;
import ru.ifmo.se.pokemon.*;

public class Charm extends StatusMove {
    public Charm() {
        super(Type.FAIRY, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon opponent) {
        super.applyOppEffects(opponent);
        Effect f = new Effect().stat(Stat.ATTACK, -2);
        opponent.addEffect(f);
    }

    @Override
    protected String describe() {
        return "использует Charm";
    }
}


