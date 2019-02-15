package farm_sim;

public class Game {

   private int day=0;
   private Farm farm;

   public Game(){
      start();
   }

   public void start(){
      int size = 2;
      farm = new Farm(size, size, "test");
      //sim_day();
      farm.plant(new Wheat());
      sim_day();
   }

   public void sim_day(){
      print("-----");
      print("Day: "+day);
      farm.day_pass();
      farm.display();
      day++;

   }

   private static void print(String str){
      System.out.println(str);
   }
}
