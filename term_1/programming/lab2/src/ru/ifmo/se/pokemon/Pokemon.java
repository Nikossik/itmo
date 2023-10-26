package ru.ifmo.se.pokemon;

import java.util.LinkedList;
import java.util.List;

public class Pokemon {
   private String name;
   private List<Type> types = new LinkedList<>();
   private List<Move> moves = new LinkedList<>();
   private Move preparedMove;
   private Effect stage = new Effect();
   private Effect condition = new Effect();
   private List<Effect> effects = new LinkedList<>();
   private int confusion;
   private int level = 1;
   private double[] base = new double[Stat.values().length];

   public Pokemon(String var1, int var2) {
      this.types.add(Type.NONE);
      this.moves.add(Move.getStruggleMove());
      this.name = var1;
      this.setLevel(var2);
   }

   public Pokemon() {
      this(Messages.get("noname"), 1);
   }

   public final void setStats(double var1, double var3, double var5, double var7, double var9, double var11) {
      this.base[Stat.HP.ordinal()] = var1;
      this.base[Stat.ATTACK.ordinal()] = var3;
      this.base[Stat.DEFENSE.ordinal()] = var5;
      this.base[Stat.SPECIAL_ATTACK.ordinal()] = var7;
      this.base[Stat.SPECIAL_DEFENSE.ordinal()] = var9;
      this.base[Stat.SPEED.ordinal()] = var11;
   }

   public final void setLevel(int var1) {
      if (var1 < 1) {
         var1 = 1;
      }

      if (var1 > 100) {
         var1 = 100;
      }

      this.level = var1;
   }

   public final double getStat(Stat var1) {
      double var2 = 15.0;
      double var4 = 0.0;
      double var6 = this.base[var1.ordinal()];
      double var8 = (double)this.stage.stat(var1);
      var8 += this.condition.success() ? (double)this.condition.stat(var1) : 0.0;

      for(Effect var11 : this.effects) {
         var8 += var11.success() ? (double)var11.stat(var1) : 0.0;
      }

      if (Math.abs(var8) > 6.0) {
         var8 = var8 > 0.0 ? 6.0 : -6.0;
      }

      double var17 = var1.isHidden() ? 0.0 : (var1 == Stat.HP ? (double)this.level + 10.0 : 5.0);
      double var12 = var1.isHidden() ? 3.0 : 2.0;
      var6 *= var1 == Stat.HP ? 1.0 : (var8 > 0.0 ? (var12 + var8) / var12 : var12 / (var12 + var8));
      var6 = var1.isHidden() ? var6 : (var6 * 2.0 + var2 + Math.sqrt(var4) / 4.0) * (double)this.level / 100.0;
      return var6 + var17;
   }

   public final boolean hasType(Type var1) {
      for(Type var3 : this.types) {
         if (var3 == var1) {
            return true;
         }
      }

      return false;
   }

   public final void addEffect(Effect var1) {
      if (var1.condition() == Status.NORMAL) {
         this.effects.add(var1);
      } else {
         this.setCondition(var1);
      }
   }

   public final void setCondition(Effect var1) {
      if (var1.success() && this.condition.condition() != var1.condition()) {
         this.condition = var1;
         String var2 = "";
         switch(var1.condition()) {
            case BURN:
               var2 = Messages.get("burn");
               break;
            case FREEZE:
               var2 = Messages.get("freeze");
               break;
            case PARALYZE:
               var2 = Messages.get("paralyze");
               break;
            case POISON:
               var2 = Messages.get("poison");
               break;
            case SLEEP:
               var2 = Messages.get("sleep");
         }

         System.out.println(this + " " + var2);
      }
   }

   public final Status getCondition() {
      return this.condition.condition();
   }

   public final void confuse() {
      this.confusion = (int)(Math.random() * 4.0 + 1.0);
   }

   public final void restore() {
      this.base[Stat.ACCURACY.ordinal()] = 1.0;
      this.base[Stat.EVASION.ordinal()] = 1.0;
      this.condition.clear();
      this.stage.clear();
      this.effects.clear();
   }

   public final double getHP() {
      return this.getStat(Stat.HP) - (double)this.stage.stat(Stat.HP);
   }



   public final void setMod(Stat var1, int var2) {
      if (var2 != 0) {
         int var3 = var2 + this.stage.stat(var1);
         String var4 = "";
         if (var1 == Stat.HP) {
            var4 = Messages.get(var2 > 0 ? "minusHP" : "plusHP") + " " + Math.abs(var2);
         } else {
            if (Math.abs(var3) > 6) {
               var3 = var3 > 0 ? 6 : -6;
            }

            var4 = Messages.get(var2 < 0 ? "minusStat" : "plusStat");
         }

         this.stage.stat(var1, var3);
         System.out.println(this + " " + var4 + " " + Messages.get(var1.toString()) + ".");
      }
   }

   public final Type[] getTypes() {
      return this.types.toArray(new Type[0]);
   }

   public final int getLevel() {
      return this.level;
   }

   private double getAttackChance() {
      double var1 = this.stage.attack();
      var1 *= this.condition.attack();

      for(Effect var4 : this.effects) {
         var1 *= var4.attack();
      }

      return var1;
   }

   public final void prepareMove() {
      if (this.getAttackChance() > Math.random()) {
         if (this.moves.size() == 0) {
            this.preparedMove = Move.getStruggleMove();
         } else if (this.confusion > 0 && Math.random() < 0.33) {
            this.preparedMove = Move.getConfusionMove();
            --this.confusion;
         } else {
            this.preparedMove = this.moves.get((int)Math.floor(Math.random() * (double)this.moves.size()));
         }
      } else {
         this.preparedMove = Move.getNoMove();
      }
   }

   public final boolean isAlive() {
      return this.getStat(Stat.HP) > (double)this.stage.stat(Stat.HP);
   }

   public final boolean attack(Pokemon var1) {
      try {
         Thread.sleep(1000L);
      } catch (InterruptedException var3) {
      }

      this.preparedMove.attack(this, var1);
      if (this.isAlive() && var1.isAlive()) {
         System.out.println();
         return false;
      } else {
         if (!this.isAlive() && !var1.isAlive()) {
            System.out.println(Messages.get("bothFaint"));
         } else {
            System.out.println((this.isAlive() ? var1 : this) + " " + Messages.get("faint"));
         }

         return true;
      }
   }

   public final void turn() {
      this.setMod(Stat.HP, this.condition.stat(Stat.HP));
      if (this.condition.turn()) {
         this.condition.clear();
      }

      if (this.condition.condition() == Status.FREEZE && Math.random() < 0.2) {
         this.condition.clear();
         System.out.println(this + " " + Messages.get("thawn"));
      }

      for(Effect var2 : this.effects) {
         this.setMod(Stat.HP, var2.stat(Stat.HP));
         if (var2.turn()) {
            var2.clear();
         }
      }
   }

   protected final void setType(Type... var1) {
      this.types.clear();
      if (var1 == null) {
         this.types.add(Type.NONE);
      } else {
         for(Type var5 : var1) {
            this.types.add(var5);
            if (this.types.size() >= 2) {
               break;
            }
         }
      }
   }

   protected final void addType(Type var1) {
      if (this.types.size() < 2 && !this.types.contains(var1)) {
         this.types.add(var1);
      }
   }

   protected final void setMove(Move... var1) {
      this.moves.clear();
      if (var1 == null) {
         this.moves.add(Move.getStruggleMove());
      } else {
         for(Move var5 : var1) {
            this.moves.add(var5);
            if (this.moves.size() >= 4) {
               break;
            }
         }
      }
   }

   protected final void addMove(Move var1) {
      this.moves.add(var1);

      while(this.moves.size() > 4) {
         this.moves.remove(0);
      }
   }

   protected final Move getPreparedMove() {
      return this.preparedMove;
   }

   @Override
   public final String toString() {
      return (this.getClass().isAnonymousClass() ? Messages.get("poke") : this.getClass().getSimpleName()) + " " + this.name;
   }

   public void setHP(double newHP) {
      this.setMod(Stat.HP, (int) newHP);
   }

   public void restoreHP(double amount) {
      double newHP = this.stage.stat(Stat.HP) + amount;
      if (newHP > this.getStat(Stat.HP)) {
         newHP = this.getStat(Stat.HP);
      }
      this.setHP(newHP);
   }

}


