package Database;

import Mini_Exceptions.*;
import java.util.*;

public class Add_FoodItem extends FoodItem{
    Scanner in=new Scanner(System.in);
   
    String name;
    double price;
    int qty;
    int choice;
    char ch;
    Search_FoodItem s =new Search_FoodItem();
    Food temp;

    public void add(Add_FoodItem a) throws FoodItemAlreadyThereException{
        do {
            System.out.println("\nchoose\n1.Starters\n2.MainDish\n3.SideDish");
            System.out.print("Enter your choice : ");
            choice=in.nextInt();

            System.out.print("\nEnter Food Name : ");
            name=in.next();
            try {
          	      temp=s.search(a, choice, name);
                throw new FoodItemAlreadyThereException(name);
            } catch (FoodItemNotFoundException ex) {
                System.out.print("Enter Food Price : ");
                price=in.nextDouble();
           
                switch(choice){
                    case 1:    
                        a.starters.add(new Food(name,price,qty));
                    break;
                    case 2:
                        a.mainDish.add(new Food(name,price,qty));
                        break;
                    case 3:
                        a.sideDish.add(new Food(name,price,qty));
                    break;
                }
            }/* catch (FoodItemAlreadyThereException e) {
                throw e;
            }*/
           
            System.out.println("\nDo You want to Add one more dish? (Yes/No)");
            System.out.print("Enter your choice: ");
            ch=in.next().charAt(0);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }while((ch == 'Y') || (ch == 'y'));
    }
}


public class Update_FoodItem {
    Scanner in = new Scanner(System.in);
    double Price;
    int choice;
    char ch;
    Food temp;
    String name;
    Menu m=new Menu();

           
    public void update(Add_FoodItem a) throws FoodItemNotFoundException{
        do {
            System.out.println("\nchoose\n1.Starters\n2.MainDish\n3.SideDish");
            System.out.print("Enter your choice : ");
            choice=in.nextInt();

            Search_FoodItem s= new Search_FoodItem();
            System.out.println("\nMenu\n");
            m.display(a, choice);
            System.out.print("\nEnter Food Name : ");
            name=in.next();
            try {
                temp=s.search(a, choice, name);
                switch(choice){
                    case 1:
                        a.starters.remove(temp);
                    break;
                    case 2:
                        a.mainDish.remove(temp);
                    break;
                    case 3:
                        a.sideDish.remove(temp);
                    break;
                }
                System.out.print("\nEnter the new Price : ");
                Price=in.nextDouble();
                temp.setPrice(Price);
             
                if(choice == 1)
                    a.starters.add(temp);
                else if(choice == 2)
                    a.mainDish.add(temp);
                else if(choice == 3)
                    a.sideDish.add(temp);
            }catch(FoodItemNotFoundException e) {
                    throw e;
            }
           
            System.out.println("\nDo You want to Update one more dish? (Yes/No)");
            System.out.print("Enter your choice: ");
            ch=in.next().charAt(0);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }while((ch == 'Y') || (ch == 'y'));
    }
}

public class Order_FoodItem implements BillCalculation {
    Scanner in = new Scanner(System.in);
    ArrayList<Food> order=new ArrayList<Food>();
    String name;
    int choice,Qty;
    Food temp;
    char ch;
    Menu m =new Menu();
   
    public void order(Add_FoodItem a) throws QuantityTooLowException{
        do {
            try {
                System.out.println("choose\n1.Starters\n2.MainDish\n3.SideDish");
                System.out.print("Enter your choice : ");
                choice=in.nextInt();
               
                Search_FoodItem s= new Search_FoodItem();
                System.out.println("\nMenu\n");
                m.display(a, choice);
                System.out.print("\nEnter Food Name : ");
                name=in.next();
                temp=s.search(a, choice, name);
               
                System.out.print("Enter the Qty : ");
                Qty=in.nextInt();
               
                if(Qty != 0) {
                    temp.setQty(Qty);
                    order.add(temp);
                }
                else
                    throw new QuantityTooLowException(Qty);
            }catch (FoodItemNotFoundException e) {
                System.out.println(e);
            }
                   
            System.out.println("\nDo You want to Order one more dish? (Yes/No)");
            System.out.print("Enter your choice: ");
            ch=in.next().charAt(0);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }while((ch == 'Y') || (ch == 'y'));
    }
   
    @Override
    public double CallculateBill(Order_FoodItem o){
        double amt=0.0;
        Iterator<Food> itr=o.order.iterator();
        System.out.println("\nyour order is : ");
        while(itr.hasNext()) {
            temp=itr.next();
            amt+=temp.getPrice()*temp.getQty();
            System.out.println(temp.display()+"\t"+"Total  :"+temp.getPrice()*temp.getQty());
        }
        return amt;
    }
}

public class Remove_FoodItem {
    Scanner in=new Scanner(System.in);
    String name;
    int choice;
    Food temp;
    Menu m=new Menu();
    char ch;
   
    public void remove(Add_FoodItem a) throws FoodItemNotFoundException {
        do {
            System.out.println("\nchoose\n1.Starters\n2.MainDish\n3.SideDish");
            System.out.print("Enter your choice : ");
            choice=in.nextInt();

            Search_FoodItem s= new Search_FoodItem();
            System.out.println("\nMenu\n");
            m.display(a, choice);
            System.out.print("\nEnter Food Name : ");
            name=in.next();
            try {
                temp=s.search(a, choice, name);
                switch(choice){
                    case 1:
                        a.starters.remove(temp);
                    break;
                    case 2:
                        a.mainDish.remove(temp);
                    break;
                    case 3:
                        a.sideDish.remove(temp);
                    break;
                    default:
                        System.out.println("\n <<< Invalid choice >>> \n");
                }
                System.out.println("\n*** Item removed ***\n");
            }catch(FoodItemNotFoundException e) {
                    throw e;
            }
            System.out.println("\nDo You want to remove one more dish? (Yes/No)");
            System.out.print("Enter your choice: ");
            ch=in.next().charAt(0);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }while((ch == 'Y') || (ch == 'y'));
    }
}

public class Search_FoodItem {
    Scanner in=new Scanner(System.in);
    int f;
    Food temp;
   
    public Food search(Add_FoodItem a,int choice,String name) throws FoodItemNotFoundException {
        f=0;
        Iterator<Food> itr=null;
           
        switch(choice){
            case 1:
                itr=a.starters.iterator();
            break;
            case 2:
                itr=a.mainDish.iterator();
            break;
            case 3:
                itr=a.sideDish.iterator();
            break;
            default:
                System.out.println("\n <<< Invalid choice >>> \n");
        }
           
        while(itr.hasNext()) {
            temp=itr.next();
            if(temp.getName().equals(name)) {
                f=1;
                break;
            }
        }
           
        if(f==1) {
            return temp;
        }
        else {
            throw new FoodItemNotFoundException(name);
        }
    }
}
