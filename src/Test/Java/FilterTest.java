import org.junit.Assert;
import org.junit.Test;

/**
 * Created by devon on 10/17/16.
 */
public class FilterTest {

    @Test
    public void splitByObjectsTest(){
    Filter filter = new Filter();
    String[] expected = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016","naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
    String[] actual = filter.splitByObjects("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##");
    Assert.assertArrayEquals("String[] should match", expected,actual);
    }

    @Test
    public void splitByPairsTest() {
    Filter filter = new Filter();
        String temp = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String[] expected = {"naMe:Milk","price:3.23","type:Food","expiration:1/25/2016"};
        String[] actual = filter.splitByPairs(temp);
        Assert.assertArrayEquals("String[] should match",expected,actual);

    }

    @Test
    public void populateRawFoodObjectTest() {
        Filter filter = new Filter();
        filter.populateRawFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        int expected = 2;
        int actual = filter.rawFoodData.size();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void assignValueIntoFoodObjectTest(){
        Filter filter = new Filter();
        filter.populateRawFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        filter.assignValueIntoFoodObject();
        int expected = 2;
        int actual = filter.foodList.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void valuePatternTest() {
        Filter filter = new Filter();
        filter.populateRawFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        filter.assignValueIntoFoodObject();
        String expected = "Milk";
        String actual = filter.foodList.get(0).getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void valuePatternTest2() {
        Filter filter = new Filter();
        filter.populateRawFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        filter.assignValueIntoFoodObject();
        String expected = "3.23";
        String actual = filter.foodList.get(0).getPrice();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void valuePatternTest3() {
        Filter filter = new Filter();
        filter.populateRawFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        filter.assignValueIntoFoodObject();
        String expected = "1/25/2016";
        String actual = filter.foodList.get(0).getExpiration();
        Assert.assertEquals(expected,actual);
    }





}
