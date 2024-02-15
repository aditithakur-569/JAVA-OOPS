public class Drinks {
    private DRINKTYPE drinkType;
    private DRINKSIZE drinkSize;
    // We can return this in the method, we do not need field member here
    private double price;

    public Drinks(DRINKTYPE drinkType, DRINKSIZE drinkSize){
        this.drinkType = drinkType;
        this.drinkSize = drinkSize;
    }

    public DRINKTYPE getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DRINKTYPE drinkType) {
        this.drinkType = drinkType;
    }

    public DRINKSIZE getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DRINKSIZE drinkSize) {
        this.drinkSize = drinkSize;
    }

    public double getPrice() {
        return price;
    }

    public double getPrice(DRINKTYPE drinkType, DRINKSIZE drinkSize) {
        DRINKTYPE drinktype = getDrinkType();
        DRINKSIZE drinksize = getDrinkSize();
        switch(drinktype){
            case FANTA, REGULARCOKE:

                if (drinkSize == DRINKSIZE.SMALL){
                    return 0.99;
                } else if (drinkSize == DRINKSIZE.MEDIUM){
                    return 1.99;
                } else if (drinkSize == DRINKSIZE.REGULAR){
                    return 2.99;
                }
            case DIETCOKE, SPRITE, DRPEPPER :
                if (drinkSize == DRINKSIZE.SMALL){
                    return 0.99;
                } else if (drinkSize == DRINKSIZE.MEDIUM){
                    return 2.99;
                } else if (drinkSize == DRINKSIZE.REGULAR){
                    return 3.99;
                }
        }
        return 0.0;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "drinkType=" + drinkType +
                ", drinkSize=" + drinkSize +
                ", price=" + price +
                '}';
    }
}
