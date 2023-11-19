package Mini_Exceptions;

public class FoodItemAlreadyThereException extends Exception{
    String Name;
   
    public FoodItemAlreadyThereException(String Name) {
        this.Name=Name;
    }
   
    public String toString() {
        return "FoodItemAlreadyThereException : For [ " +Name +" ]";
    }
}

public class FoodItemNotFoundException extends Exception {
    String Name;
   
    public FoodItemNotFoundException(String Name) {
        this.Name=Name;
    }
   
    public String toString() {
        return "FoodNotFoundException : For [ " +Name +" ]";
    }
}

public class OrderNotFoundException extends Exception {
   
    public String toString() {
        return "FoodNotFoundException : For [ Empty Order ]";
    }
}

public class QuantityTooLowException extends Exception {
    int Qty;
   
    public QuantityTooLowException(int Qty) {
        this.Qty=Qty;
    }
   
    public String toString() {
        return "QuantityTooLowException : For [ "+Qty+" ]";
    }
}
