/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;

class DrivableTrader extends Trader<Drivable> {
    /**
     * Construct a DrivableTrader, with the given inventory, wishlist and money.
     *
     * @param inventory Drivables in the trader's inventory
     * @param wishlist Drivables in the trader's wishlist
     * @param money The trader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a DrivableTrader, with the given money, setting wishlist and inventory to empty lists.
     *
     * @param money The trader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    /**
     * If the item is tradable, return the price + the max speed. If the item is not tradable, return
     * the missing price value.
     *
     * @param item The item we are getting the price of
     * @return The item's price + max speed if it is tradable, or the missing price value if it isn't.
     */
    @Override
    public int getSellingPrice(Drivable item) {
        if (item instanceof Tradable) {
            return ((Tradable) item).getPrice() + item.getMaxSpeed();
        }
        else {
            return Tradable.MISSING_PRICE;
        }
    }


}