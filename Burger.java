import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Burger {
    // Map for burger tyoe and price and another map for topping and price.
    private BURGERTYPE burgerType;
    // make this final and static and remove from constructor
    private double basePrice;
    private final String[] toppings;
    //take additional toppings that customer chose from constructor rather than setters
    public Burger(BURGERTYPE burgerType, double basePrice){
        this.burgerType = burgerType;
        this.basePrice = basePrice;
        // append this new list with existing list
        this.toppings = new String[]{"ONION", "TOMATO", "", "", "", "", ""};
    }

    public BURGERTYPE getBurgerType() {
        return burgerType;
    }

    public void setBurgerType(BURGERTYPE burgerType) {
        this.burgerType = burgerType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String[] getToppings() {
        return toppings;
    }
    public void setToppings(String topping,int index) {
        this.toppings[index] = topping.toUpperCase();
    }

    // have 1 method getPrice() which will check the toppings and burgertype to dteermine the price
    public double getToppingsPrice(){
        double toppingsPrice = 0.0;
        for (String topping: toppings){
            if (topping.length() > 0){
                toppingsPrice += ToppingsPrice(TOPPINGS.valueOf(topping));
            }
        }
        return toppingsPrice;
    }

    public double getIndividualToppingsPrice(String topping){
        return ToppingsPrice(TOPPINGS.valueOf(topping));
    }
    public double ToppingsPrice(TOPPINGS topping){
        switch(topping){
            case MAYO, CHEESE, KETCHUP, PICKLES, PINEAPPLE,CHILIES, LETTUCE:
                return 0.99;
            case BACON, AVOCADO, JALAPENOS:
                return 2.99;
        }
        return 0.0;
    }
    public static double getPricePerBurgerType(BURGERTYPE burgerType){
        switch(burgerType){
            case HAMBURGER,BEYONDMEATBURGER,WILDSALMONBURGER: {return 5.99;}
            case BEANBURGER,VEGGIEBURGER:{return 3.99;}
            case CHEESEBURGER:{return 2.99;}
            }
            return 0.0;
        }


    @Override
    public String toString() {
        return "Burger{" +
                "burgerType=" + burgerType +
                ", basePrice=" + basePrice +
                ", toppings=" + Arrays.toString(toppings) +
                '}';
    }
}
