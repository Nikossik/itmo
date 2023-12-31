package ru.ifmo.se.pokemon;

public enum Type {
   NORMAL,
   FIRE,
   WATER,
   ELECTRIC,
   GRASS,
   ICE,
   FIGHTING,
   POISON,
   GROUND,
   FLYING,
   PSYCHIC,
   BUG,
   ROCK,
   GHOST,
   DRAGON,
   DARK,
   STEEL,
   FAIRY,
   NONE;

   private static final int[][] effects = new int[values().length][values().length];

   private double effect(Type var1) {
      return 1.0 - (double)effects[this.ordinal()][var1.ordinal()] / 2.0;
   }

   private Type setX(int var1, Type... var2) {
      for(Type var6 : var2) {
         effects[this.ordinal()][var6.ordinal()] = var1;
      }

      return this;
   }

   private Type zero(Type... var1) {
      return this.setX(2, var1);
   }

   private Type half(Type... var1) {
      return this.setX(1, var1);
   }

   private Type doub(Type... var1) {
      return this.setX(-2, var1);
   }

   public double getEffect(Type... var1) {
      double var2 = 1.0;

      for(Type var7 : var1) {
         var2 *= this.effect(var7);
      }

      return var2;
   }

   static {
      NORMAL.half(ROCK, STEEL).zero(GHOST);
      FIRE.half(FIRE, WATER, ROCK, DRAGON).doub(GRASS, ICE, BUG, STEEL);
      WATER.doub(FIRE, GROUND, ROCK).half(WATER, GRASS, DRAGON);
      ELECTRIC.doub(WATER, FLYING).half(ELECTRIC, GRASS, DRAGON).zero(GROUND);
      GRASS.half(FIRE, GRASS, POISON, FLYING, BUG, DRAGON, STEEL).doub(WATER, GROUND, ROCK);
      ICE.half(FIRE, WATER, ICE, STEEL).doub(GRASS, GROUND, FLYING, DRAGON);
      FIGHTING.doub(NORMAL, ICE, ROCK, DARK, STEEL).half(POISON, FLYING, PSYCHIC, BUG, FAIRY).zero(GHOST);
      POISON.doub(GRASS, FAIRY).half(POISON, GROUND, ROCK, GHOST).zero(STEEL);
      GROUND.doub(FIRE, ELECTRIC, POISON, ROCK, STEEL).half(GRASS, BUG).zero(FLYING);
      FLYING.half(ELECTRIC, ROCK, STEEL).doub(GRASS, FIGHTING, BUG);
      PSYCHIC.doub(FIGHTING, POISON).half(PSYCHIC, STEEL).zero(DARK);
      BUG.half(FIRE, FIGHTING, POISON, FLYING, GHOST, STEEL, FAIRY).doub(GRASS, PSYCHIC, DARK);
      ROCK.doub(FIRE, ICE, FLYING, BUG).half(FIGHTING, GROUND, STEEL);
      GHOST.zero(NORMAL).doub(PSYCHIC, GHOST).half(DARK);
      DRAGON.doub(DRAGON).half(STEEL).zero(FAIRY);
      DARK.half(FIGHTING, DARK, FAIRY).doub(PSYCHIC, GHOST);
      STEEL.half(FIRE, WATER, ELECTRIC, STEEL, FAIRY).doub(ICE, ROCK);
      FAIRY.half(FIRE, POISON, STEEL).doub(FIGHTING, DRAGON, DARK);
   }
}
