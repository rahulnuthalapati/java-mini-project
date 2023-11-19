import Database.*;
import Mini_Exceptions.*;
import java.util.*;

public class RestaurentManagement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double amt;
        int choice;
        char ch;
        Add_FoodItem a = new Add_FoodItem();
        Order_FoodItem o = new Order_FoodItem();
       
        do {
            System.out.println("choose\n1.Dish_Menu\n2.Add_Dish\n3.Remove_dish\n4.Update_dish\n5.place Order\n6.Bill Generation");
            System.out.print("Enter your choice : ");
            choice=in.nextInt();
            switch(choice) {
                case 1:
                    Menu m=new Menu();
                    System.out.println("\n... Starters ...");
                    m.display(a,1);
                    System.out.println("\n... MainDish ...");
                    m.display(a,2);
                    System.out.println("\n... SideDish ...");
                    m.display(a,3);
                break;
                case 2:
                    try {
                        System.out.println("\nAdding Food Items ");
                        a.add(a);
                    }catch(FoodItemAlreadyThereException e) {
                        System.out.println(e);
                    }
                    System.out.println();
                   
                break;
                case 3:
                    try {
                        Remove_FoodItem r = new Remove_FoodItem();
                        System.out.println("\nremoving Food Items ");
                        r.remove(a);
                    }catch(FoodItemNotFoundException e) {
                        System.out.println(e);
                    }
                    System.out.println();
                break;
                case 4:
                    try {
                        Update_FoodItem u = new Update_FoodItem();
                        System.out.println("\nUpdating Food Items ");
                        u.update(a);
                    }catch(FoodItemNotFoundException e) {
                        System.out.println(e);
                    }
                    System.out.println();
                break;
                case 5:
                    try {
                        System.out.println("\nordering Food Items ");
                        o.order(a);
                    }catch(QuantityTooLowException e) {
                        System.out.println(e);
                    }
                    System.out.println();
                break;
                case 6:
                    BillCalculation b = new Order_FoodItem();
                    amt=b.CallculateBill(o);
                    System.out.println("You need to pay : "+amt +" Rs/-");
                    System.out.println();
                break;
            }
            System.out.println("Do You want to Go to Main menu? (Yes/No)");
            System.out.print("Enter your choice: ");
            ch=in.next().charAt(0);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }while((ch == 'Y') || (ch == 'y'));
    }
}
