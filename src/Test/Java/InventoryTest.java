import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by devon on 10/18/16.
 */
public class InventoryTest {

    @Test
    public void populateMapTest() {
        Inventory inventory = new Inventory();
        Food food = new Food("Milk", "3.23", "Food", "1/25/2016");
        Food food1 = new Food("Milk", "3.23", "Food", "1/25/2016");
        Food food2 = new Food("Milk", "1.23", "Food", "1/25/2016");
        inventory.populateMap(food,inventory.mapMilkCost);
        inventory.populateMap(food1, inventory.mapMilkCost);
        inventory.populateMap(food2, inventory.mapMilkCost);
        int expected = 2;
        int actual = inventory.mapMilkCost.get("3.23");
        Assert.assertEquals(expected,actual);


    }


}


