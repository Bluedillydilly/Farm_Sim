package farm_sim;

import java.util.ArrayList;
import java.util.List;

public class Farm {
   private Plant[][] plots;
   private Plant[] stock_pile;
   private int current_stock_pile_size;

   public Farm(int rows, int cols){
      this.plots = new Plant[rows][cols];
      this.stock_pile = new Plant[10];
      this.current_stock_pile_size = 0;
      init_farm();
   }

   private void init_farm(){
      for(Plant[] row: plots){
         for(Plant p: row){
            p = new Fallow();
         }
      }
   }

   public void plant(Plant p){
      plant_crop(0, 0, p);
   }

   private void plant_crop(int r, int c, Plant p){
      plots[r][c] = p;
   }

   private boolean stock_pile_room(){
      return current_stock_pile_size < stock_pile.length;
   }

   public void harvest_crops(){
      for(Plant[] row:plots){
         for(Plant p: row){
            if(p.is_mature() && stock_pile_room()){
               stock_pile[current_stock_pile_size] = p;
               current_stock_pile_size++;
               p = new Fallow();
            }
         }
      }
   }

   @Override
   public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("+");
      for(int i=2; i<plots[0].length; i++){
         sb.append("-");
      }
      sb.append("+\n");

      for(int row=2; row<plots.length; row++){
         sb.append("|");
         for(int col=1; col<plots[0].length-1; col++){
            sb.append(plots[col][row].toString());
         }
         sb.append("|\n");
      }


      sb.append("+");
      for(int i=2; i<plots[0].length; i++){
         sb.append("-");
      }
      sb.append("+\n");
      return sb.toString();
   }
}
