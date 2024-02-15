public class SideItem {

    private SIDEITEMTYPE sideItemType;
    private double price;

    public SideItem(SIDEITEMTYPE sideItemType, double price) {
        this.sideItemType = sideItemType;
        this.price = price;
    }

    public SIDEITEMTYPE getSideItemType() {
        return sideItemType;
    }

    public void setSideItemType(SIDEITEMTYPE sideItemType) {
        this.sideItemType = sideItemType;
    }
    public double getPrice() {
        return price;
    }

    public static double getPricePerSideItem(SIDEITEMTYPE sideitemtype){
        switch(sideitemtype){
            case SALAD, CUCUMBERS,ONIONRINGS:{
                return 1.99;
            }
            case FRIES,POTATOCHIPS:{
                return 0.99;
            }
        }
        return 0.0;
    }
}
