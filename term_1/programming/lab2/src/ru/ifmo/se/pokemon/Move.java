package ru.ifmo.se.pokemon;

public abstract class Move {
   protected Type type;
   protected double power = 0.0;
   protected double accuracy = 1.0;
   protected int priority = 0;
   protected int hits = 1;
   private static final Move noMove = new Move(Type.NONE, 0.0, 0.0, -100, 0) {
      @Override
      public final void attack(Pokemon var1, Pokemon var2) {
      }

      @Override
      public String describe() {
         return Messages.get("noattack");
      }
   };
   private static final Move struggleMove = new PhysicalMove(Type.NONE, 50.0, 1.0) {
      @Override
      public final String describe() {
         return Messages.get("struggle");
      }

      @Override
      public final void applySelfDamage(Pokemon var1, double var2) {
         var1.setMod(Stat.HP, (int)Math.round(var2 / 4.0));
      }
   };
   private static final Move confusionMove = new PhysicalMove(Type.NONE, 40.0, 1.0) {
      @Override
      public final String describe() {
         return Messages.get("confusion");
      }

      @Override
      public final void applySelfDamage(Pokemon var1, double var2) {
         var1.setMod(Stat.HP, (int)var2);
      }

      @Override
      public double calcCriticalHit(Pokemon var1, Pokemon var2) {
         return 1.0;
      }

      @Override
      protected void applyOppDamage(Pokemon var1, double var2) {
      }
   };

   public Move() {
      this(Type.NONE, 0.0, 1.0, 0, 1);
   }

   public Move(Type var1, double var2, double var4) {
      this(var1, var2, var4, 0, 1);
   }

   public Move(Type var1, double var2, double var4, int var6, int var7) {
      this.type = var1;
      this.accuracy = var4;
      this.power = var2;
      this.priority = var6;
      this.hits = var7;
   }

   protected abstract void attack(Pokemon var1, Pokemon var2);

   protected boolean checkAccuracy(Pokemon var1, Pokemon var2) {
      return this.accuracy * var1.getStat(Stat.ACCURACY) / var2.getStat(Stat.EVASION) > Math.random();
   }

   public final int getPriority() {
      return this.priority;
   }

   protected String describe() {
      return Messages.get("attack");
   }

   protected void applyOppEffects(Pokemon var1) {
   }

   protected void applyOppEffects(Pokemon var1, Pokemon var2) {
   }

   protected void applySelfEffects(Pokemon var1) {
   }

   public static final Move getNoMove() {
      return noMove;
   }

   public static final Move getStruggleMove() {
      return struggleMove;
   }

   public static final Move getConfusionMove() {
      return confusionMove;
   }
}
