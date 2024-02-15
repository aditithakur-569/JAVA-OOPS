import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME TO BRIAN'S BURGER!!!!!");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter (A for BASIC Meal, B for MAKE YOUR MEAL, C FOR DELUXE BURGER, Q FOR QUIT)");
            String choice = scanner.nextLine();
            if ("Qq".contains(choice)){
                break;
            }
            if ("Aa".contains(choice)){
                MealOrder mealOrder = new MealOrder();
                mealOrder.printItemizedList("A");

            }else if("Bb".contains(choice)){

                Burger newBurgerOrder = printBurgerOptions(3);
                Drinks newDrinksOrder = printDrinksOptions();
                SideItem newSideItem = printSideItemOptions();
                MealOrder newYourMealOrder = new MealOrder(newBurgerOrder, newDrinksOrder, newSideItem);
                newYourMealOrder.printItemizedList("B");
                break;

            }else if ("Cc".contains(choice)){
                Burger newBurgerOrder = printBurgerOptions(5);
                Drinks newDrinksOrder = printDrinksOptions();
                SideItem newSideItem = printSideItemOptions();
                MealOrder newDeluxeMealOrder = new MealOrder(newBurgerOrder, newDrinksOrder, newSideItem);
                newDeluxeMealOrder.printItemizedList("C");
                break;
            }
        }
    }

    public static SideItem printSideItemOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE SELECT SIDE ITEM OF YOUR CHOICE: ");
        System.out.println(" [0 -> ONION RINGS, 1 -> POTATO CHIPS, 2 -> FRIES, 3 -> SALAD, 4 -> CUCUMBERS]");
        int item = scanner.nextInt();
        SideItem sideItem = new SideItem(SIDEITEMTYPE.values()[item],SideItem.getPricePerSideItem(SIDEITEMTYPE.values()[item]));
        return sideItem;
    }

    public static Drinks printDrinksOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("SELECT YOUR DRINK..");
        System.out.println(" [0 -> DIET COKE, 1 -> REGULAR COKE, 2 -> SPRITE, 3 -> DR PEPPER, 4 -> FANTA]");

        int drinkType = scanner.nextInt();
        System.out.printf("SELECT YOUR DRINK SIZE");
        System.out.println("[0 -> SMALL, 1 -> MEDIUM, 2 -> REGULAR]");

        int drinkSize = scanner.nextInt();
        Drinks drinks = new Drinks(DRINKTYPE.values()[drinkType],DRINKSIZE.values()[drinkSize]);
        return drinks;
    }
    public static Burger printBurgerOptions(int count){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select the Burger type: ");
        System.out.println("0 -> HAMBURGER, 1 -> VEGGIEBURGER, 2 -> WILD SALMON BURGER, 3 -> BEAN BURGER," +
                " 4 -> CHEESE BURGER, 5 -> BEYOND MEAT BURGER");

        int burgerType = scanner.nextInt();
        Burger burger = new Burger(BURGERTYPE.values()[burgerType],Burger.getPricePerBurgerType(BURGERTYPE.values()[burgerType]));

        System.out.println("Add extra toppings. You can add upto " + count + " toppings...");
        System.out.println("PLEASE SELECT TOPPINGS OF YOUR CHOICE... ");
        System.out.println("0 -> BACON, 1 -> LETTUCE, 2 -> AVOCADO, 3 -> PICKLES, 4 -> MAYO, 5 -> PINEAPPLE," +
                " 6 -> CHEESE, 7 -> JALAPENOS," + " 8 -> CHILIES, 9 -> KETCHUP");
        int idx = 2;
        while (count > 0) {
            int extraToppings = scanner.nextInt();
            burger.setToppings(String.valueOf(TOPPINGS.values()[extraToppings]),idx);
            count--;
            idx++;
        }
        return burger;
    }
}

