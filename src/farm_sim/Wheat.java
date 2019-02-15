package farm_sim;

public class Wheat extends Plant {
   private int value;

   public Wheat(){
      super("Wheat", 5, 1);
      value = 1;
   }

   @Override
   public String toString(){
      return "W";
   }
}
