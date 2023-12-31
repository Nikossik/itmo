package lab2.Moves;
import ru.ifmo.se.pokemon.*;
public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        super.applySelfEffects(pokemon);
        Effect f = new Effect().stat(Stat.EVASION, 1).turns(6);
        pokemon.addEffect(f);
    }

    @Override
    protected String describe() {
        return "использует Double Team";
    }
}
