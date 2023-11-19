package Database;

import java.util.*;

public interface BillCalculation {
    public double CallculateBill(Order_FoodItem o);
}

public class FoodItem {
    ArrayList<Food> starters = new ArrayList<Food>();
    ArrayList<Food> mainDish = new ArrayList<Food>();
    ArrayList<Food> sideDish = new ArrayList<Food>();
}

public class Food {
    String Name;
    double Price;
    int Qty;

    public Food(String Name,double Price,int Qty) {
        this.Name=Name;
        this.Price=Price;
        this.Qty=Qty;
    }
   
    public String getName() {
        return Name;
    }
   
    public double getPrice() {
        return Price;
    }
       
    public int getQty() {
        return Qty;
    }
   
    public void setPrice(double Price) {
        this.Price=Price;
    }
   
    public void setQty(int Qty) {
        this.Qty=Qty;
    }
       
    @Override
    public String toString() {
        return "Name  : " +Name+"\tPrice : "+Price;
    }
   
    public String display() {
        return "Name   : " +Name+"\tPrice  : "+Price +"\tQty    : "+Qty;
    }
}

public class Menu {
    Food temp;
    Iterator<Food> itr=null;
    int t=0;
   
    public void display(Add_FoodItem a,int f) {
        if(f==1) {
            if(a.starters.size()!=0) {
                itr=a.starters.iterator();
                t=1;
                }
            else
                System.out.println("\nNo Dishes available in Starters...\n");
        }
       
        else if(f==2) {
            if(a.mainDish.size()!=0) {
                t=1;
                itr=a.mainDish.iterator();
                }
            else
                System.out.println("\nNo Dishes available in mainDish...\n");
        }
       
        else if(f==3) {
            if(a.sideDish.size()!=0) {
                t=1;
                itr=a.sideDish.iterator();
                }
            else
                System.out.println("\nNo Dishes available in sideDish...\n");
        }
        if(t==1) {
            while(itr.hasNext()) {
                temp=itr.next();
                System.out.println(temp.toString());
            }
        }
    }
}
