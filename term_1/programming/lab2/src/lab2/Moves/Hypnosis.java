package lab2.Moves;
import ru.ifmo.se.pokemon.*;

public class Hypnosis extends StatusMove {
    public Hypnosis() {
        super(Type.PSYCHIC, 0, 60);
    }

    @Override
    protected void applyOppEffects(Pokemon opponent) {
        super.applyOppEffects(opponent);
        Effect f = new Effect().turns(2).condition(Status.SLEEP);
        opponent.addEffect(f);
    }

    @Override
    protected String describe() {
        return "использует Hypnosis";
    }
}

