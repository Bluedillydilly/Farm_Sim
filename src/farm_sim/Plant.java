package farm_sim;

public class Plant {
   private float age = 0; // in days
   private int mature_age;
   private float growth_rate;
   private String name;

   public Plant(){}

   public Plant(String name, int mature_age, float growth_rate){
      this.growth_rate = growth_rate;
      this.mature_age = mature_age;
      this.name = name;
   }

   public boolean is_mature(){
      return age >= mature_age;
   }

   public void age(){ age += growth_rate; }

   public String getName(){
      return name;
   }

   public String harvest_status(){
      int harvest_days = (int)((mature_age-age) / growth_rate);
      if(harvest_days < 0){
         harvest_days = 0;
      }
      if(growth_rate == 0){ return "Nothing growing."; }
      String harvest_status = "Ready to harvest in "+harvest_days+" days.";
      if(harvest_days==0){
         harvest_status = "Now Ready to harvest";
      }
      return harvest_status;
   }

   @Override
   public String toString(){
      return name+" is "+age+" days old. "+harvest_status();
   }

}
