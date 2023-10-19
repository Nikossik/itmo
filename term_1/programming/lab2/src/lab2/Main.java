package lab2;

import lab2.Pokemons.*;
import ru.ifmo.se.pokemon.*;


public class Main {
    public static void main(String[] args) {
        // Создаем покемонов
        Pokemon basculin = new Basculin("Basculin", 50);
        Pokemon skiddo = new Skiddo("Skiddo", 45);
        Pokemon gogoat = new Gogoat("Gogoat", 55);
        Pokemon ralts = new Ralts("Ralts", 40);
        Pokemon kirlia = new Kirlia("Kirlia", 48);
        Pokemon gardevoir = new Gardevoir("Gardevoir", 58);

        // Создаем бой
        Battle battle = new Battle();

        // Добавляем покемонов в команды
        battle.addAlly(basculin);
        battle.addAlly(skiddo);
        battle.addAlly(gogoat);

        battle.addFoe(ralts);
        battle.addFoe(kirlia);
        battle.addFoe(gardevoir);

        // Запускаем бой
        battle.go();
    }
}
