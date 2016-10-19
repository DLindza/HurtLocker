import org.junit.Assert;
import org.junit.Test;

/**
 * Created by devon on 10/19/16.
 */
public class FoodTest {


@Test
public void replaceNameValuePatternTest_Milk() {
    Food food = new Food("mIlK", "3.23", "Food", "1/25/2016");
    try {
        food.replaceNameValuePattern(food.getName(), Food.milkRegex);
    }catch (Exception e) {
        System.out.println("This threw an exception");
    }
    String expected = "Milk";
    String actual = food.getName();
    Assert.assertEquals(expected,actual);
}

@Test
public void replaceNameValuePatternTest_Cookies() {
    Food food = new Food("cO0ki3s", "3.23", "Food", "1/25/2016");
    try {
        food.replaceNameValuePattern(food.getName(), Food.cookiesRegex);
    }catch (Exception e) {
        System.out.println("This threw an exception");
    }
    String expected = "Cookies";
    String actual = food.getName();
    Assert.assertEquals(expected,actual);
}

@Test
public void replaceNameValuePatternTest_Bread() {
        Food food = new Food("Br3aD", "3.23", "Food", "1/25/2016");
        try {
            food.replaceNameValuePattern(food.getName(), Food.breadRegex);
        }catch (Exception e) {
            System.out.println("This threw an exception");
        }
        String expected = "Bread";
        String actual = food.getName();
        Assert.assertEquals(expected,actual);
}

@Test
public void replaceNameValuePatternTest_Apples() {
        Food food = new Food("ApPl4s", "3.23", "Food", "1/25/2016");
        try {
            food.replaceNameValuePattern(food.getName(), Food.applesRegex);
        }catch (Exception e) {
            System.out.println("This threw an exception");
        }
        String expected = "Apples";
        String actual = food.getName();
        Assert.assertEquals(expected,actual);
    }

@Test
public void replaceNameValuePatternTest_Exception() {
        Food food = new Food("null", "3.23", "Food", "1/25/2016");
        try {
            food.replaceNameValuePattern(food.getName(), Food.applesRegex);
        }catch (Exception e) {
            System.out.println("This threw an exception");
        }
        String expected = "null";
        String actual = food.getName();
        Assert.assertEquals(expected,actual);
    }

@Test
public void checkPriceTest() throws NoCurrentValueException {
    Food food = new Food("ApPl4s", null, "Food", "1/25/2016");
    try {
        food.replaceNameValuePattern(food.getName(), Food.applesRegex);
        food.checkPrice();
    }catch (Exception e) {
        System.out.println("This threw an exception");
    }

    int expected = 0;
    int actual = food.getCounter("Apples");
    Assert.assertEquals(expected,actual);

}

@Test
public void getCounterTest() {
    Food food = new Food("ApPl4s", "3.23", "Food", "1/25/2016");
    try {
        food.replaceNameValuePattern(food.getName(), Food.applesRegex);
    }catch (Exception e) {
        System.out.println("This threw an exception");
    }
    int expected = 1;
    int actual = food.getCounter("Apples");
    Assert.assertEquals(expected,actual);
}
}
