public class MealOrder {
    private Burger burger;
    private Drinks drinks;
    private SideItem sideItem;
    private TOPPINGS toppings;
    private String[] extraToppings;

    public MealOrder(){
        this.burger = new Burger(BURGERTYPE.HAMBURGER,5.00);
        this.drinks = new Drinks(DRINKTYPE.FANTA,DRINKSIZE.SMALL);
        this.sideItem = new SideItem(SIDEITEMTYPE.FRIES,0.99);
    }

    public MealOrder(Burger burger, Drinks drinks, SideItem sideItem){
        this.burger = burger;
        this.drinks = drinks;
        this.sideItem = sideItem;
    }

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Drinks getDrinks() {
        return drinks;
    }
    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public SIDEITEMTYPE getSideItem() {
        return sideItem.getSideItemType();
    }
    public void setSideItem(SideItem sideItem) {
        this.sideItem = sideItem;
    }

    public void printItemizedList( String choice){
        String welcome = "         Welcome to BRIAN's BURGER !!!       \n"
                         + "    655 South Fairoaks Avenue, San Jose, 94539\n     "
                         + "      (714) 345-7899     ";
        System.out.println(welcome);
        System.out.println("Items");
        System.out.println("---".repeat(12));
        if (choice.contentEquals("A")){
            System.out.println("REGULAR BURGER");
        }else if (choice.contentEquals("B")){
            System.out.println("BURGER OF YOUR CHOICE...");
        }else if (choice.contains("C")){
            System.out.println("DELUXE BURGER");
        }

        System.out.println("  Type: " + this.getBurger().getBurgerType());
        System.out.println("  Burger's Price: $" + this.calculateBurgerPrice() );
        String[] toppingsArray = this.getBurger().getToppings();

        System.out.println("  YOUR TOPPINGS: ");
        for (String t: toppingsArray){

            if (t.contentEquals("")){
                break;
            }else if ((t.contentEquals("ONION") || t.contentEquals("TOMTATO"))){
                System.out.println("    " + t + ": $" + 0.0);
            }else{
                System.out.println("    " + t + ": $" + burger.getIndividualToppingsPrice(t));
            }
        }
        System.out.println("TOTAL TOPPINGS PRICE: $" + this.calculateToppingsPrice());
        System.out.println("---".repeat(12));
        System.out.println("DRINKS");
        System.out.println("  Type: " + this.getDrinks().getDrinkType());
        System.out.println("  Size: " + this.getDrinks().getDrinkSize());
        System.out.println("Price: $" + this.calculateDrinkPrice());
        System.out.println("---".repeat(12));
        System.out.println("SIDE ITEM");
        System.out.println("  Item: " + this.getSideItem().toString());
        System.out.println("  Price: $" + this.calculateSideItemPrice());
        System.out.println("---".repeat(12));
        System.out.println("TOTAL MEAL PRICE: $" + this.calculateMealPrice());
        System.out.println("HAVE A GOOD DAY !!!!");

    }

    private double calculateToppingsPrice() {
       return Math.round(burger.getToppingsPrice());
    }

    private double calculateBurgerPrice(){
        return Math.round(burger.getBasePrice());
    }

    public double calculateDrinkPrice(){
        return Math.round(this.drinks.getPrice(drinks.getDrinkType(),drinks.getDrinkSize()));
    }

    public double calculateSideItemPrice(){
        return sideItem.getPrice();
    }
    public double calculateMealPrice(){
        return Math.round(calculateDrinkPrice() + calculateBurgerPrice() + calculateToppingsPrice() + calculateSideItemPrice());
    }

    @Override
    public String toString() {
        return "MealOrder{" +
                "burger=" + BURGERTYPE.HAMBURGER +
                ", drinks=" + DRINKTYPE.FANTA +
                ", sideItem=" + SIDEITEMTYPE.FRIES +
                ", toppings=" + toppings +
                '}';
    }
}
