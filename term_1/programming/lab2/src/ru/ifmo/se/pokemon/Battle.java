package ru.ifmo.se.pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Battle {
   private Team allies;
   private Team foes;
   private String allyName;
   private String foeName;

   public Battle() {
      ArrayList var1 = new ArrayList();
      var1.addAll((List)Messages.getObj("teams"));
      Collections.shuffle(var1);
      this.allies = new Team((String)var1.get(0));
      this.foes = new Team((String)var1.get(1));
   }

   public void addAlly(Pokemon var1) {
      this.allies.add(var1);
   }

   public void addFoe(Pokemon var1) {
      this.foes.add(var1);
   }

   private boolean checkFirst(Pokemon var1, Pokemon var2) {
      if (var1.getPreparedMove().getPriority() == var2.getPreparedMove().getPriority()) {
         if (var1.getStat(Stat.SPEED) == var2.getStat(Stat.SPEED)) {
            return Math.random() >= 0.5;
         } else {
            return var1.getStat(Stat.SPEED) > var2.getStat(Stat.SPEED);
         }
      } else {
         return var1.getPreparedMove().getPriority() > var2.getPreparedMove().getPriority();
      }
   }

   public void go() {
      if (this.allies.isEmpty() || this.foes.isEmpty()) {
         System.out.println("One of the Pokemon is not set up properly!");
      } else {
         while (this.allies.hasNext() && this.foes.hasNext()) {
            this.allies.next();
            this.foes.next();

            do {
               this.allies.poke().prepareMove();
               this.foes.poke().prepareMove();
               Pokemon first = checkFirst(this.allies.poke(), this.foes.poke()) ? this.allies.poke() : this.foes.poke();
               Pokemon second = checkFirst(this.allies.poke(), this.foes.poke()) ? this.foes.poke() : this.allies.poke();

               System.out.println(first.toString() + " prepares to attack " + second.toString());

               if (first.attack(second) || second.attack(first)) {
                  break;
               }

               this.allies.poke().turn();
               if (!this.allies.poke().isAlive()) {
                  System.out.println(this.allies.poke().toString() + " has fainted!");
                  break;
               }

               this.foes.poke().turn();
               if (!this.foes.poke().isAlive()) {
                  System.out.println(this.foes.poke().toString() + " has fainted!");
                  break;
               }

            } while (this.foes.poke().isAlive());
         }

         if (!this.allies.hasNext() && !this.foes.hasNext()) {
            System.out.println(Messages.get("tie"));
         } else {
            String winningTeam = (allies.hasNext() && allies.poke() != null) ? allies.getName() : foes.getName();
            String losingTeam = (foes.hasNext() && foes.poke() != null) ? allies.getName() : foes.getName();

            System.out.println(Messages.get("inTeam") + " " + losingTeam + " " + Messages.get("empty"));
            System.out.println(Messages.get("team") + " " + winningTeam + " " + Messages.get("wins"));
         }
      }
   }





   public static void main(String[] var0) {
      Battle var1 = new Battle();
      var1.addAlly(new Pokemon("Весельчак У", 20) {
         {
            this.setStats(10.0, 20.0, 10.0, 10.0, 10.0, 20.0);
            this.setMove(new Move[]{new FireMove(Type.DRAGON, 5.0, 1.0)});
         }
      });
      var1.addFoe(new Pokemon("Тутан Хамон", 25) {
         {
            this.setStats(10.0, 10.0, 20.0, 10.0, 10.0, 10.0);
            this.addMove(new FireMove(Type.DARK, 4.0, 0.8));
         }
      });
      var1.go();
   }
}
