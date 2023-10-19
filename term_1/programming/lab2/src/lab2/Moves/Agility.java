package lab2.Moves;
import ru.ifmo.se.pokemon.*;

public class Agility extends StatusMove {
    public Agility() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect f = new Effect().stat(Stat.SPEED, +2);
        pokemon.addEffect(f);
    }

    @Override
    protected String describe() {
        return "использует Agility";
    }
}
