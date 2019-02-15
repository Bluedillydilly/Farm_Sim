package farm_sim;

import java.util.ArrayList;
import java.util.List;

public class Farm {
   private Plant[][] plots;
   private Plant[] stock_pile;
   private int plants_in_farm;
   private int current_stock_pile_size;
   private String name;

   public Farm(int rows, int cols, String name){
      this.plots = new Plant[rows][cols];
      this.stock_pile = new Plant[10];
      this.current_stock_pile_size = 0;
      this.name = name;
      init_farm();
   }

   private void init_farm(){
      for(int row=0; row<plots.length; row++){
         for(int col=0; col<plots[0].length; col++ ){
            plots[row][col] = new Fallow();
         }
      }
   }

   public void day_pass(){
      for(int row=0; row<plots.length; row++){
         for(int col=0; col<plots[0].length; col++){
            plots[row][col].age();
         }
      }

   }

   public void plant(Plant p){
      if(plants_in_farm==0){plant_crop(0,0,p);}
      else {
         plant_crop(plants_in_farm/plots.length - 1, plants_in_farm/plots[0].length - 1, p);
      }
      plants_in_farm++;
   }

   private void plant_crop(int r, int c, Plant p){
      plots[r][c] = p;
   }

   private boolean stock_pile_room(){
      return current_stock_pile_size < stock_pile.length;
   }

   private void harvest_crops(){
      for(int row=0; row<plots.length; row++){
         for(int col=0; col<plots[0].length; col++){
            if(plots[row][col].is_mature() && stock_pile_room()){
               stock_pile[current_stock_pile_size] = plots[row][col];
               current_stock_pile_size++;
               plots[row][col] = new Fallow();
            }
         }
      }
   }


   @Override
   public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("Name: "+name+"\n");
      sb.append("+");
      for(int i=0; i<plots[0].length; i++){
         sb.append("-");
      }
      sb.append("+\n");

      for(int row=0; row<plots.length; row++){
         sb.append("|");
         for(int col=0; col<plots[0].length; col++){
            sb.append(plots[col][row].toString());
         }
         sb.append("|\n");
      }


      sb.append("+");
      for(int i=0; i<plots[0].length; i++){
         sb.append("-");
      }
      sb.append("+\n");
      return sb.toString();
   }

   public void display(){
      System.out.println(this.toString());
   }
}
