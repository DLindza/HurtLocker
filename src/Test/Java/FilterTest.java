import org.junit.Assert;
import org.junit.Test;

/**
 * Created by devon on 10/17/16.
 */
public class FilterTest {
    @Test
    public void splitByObjectTest() {
    Filter filter = new Filter();
    CharSequence[] expected = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016","naME:BreaD;price:1.23;type:Food;expiration:1/02/2016"};
    CharSequence[] actual = filter.splitByObject("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
    Assert.assertArrayEquals("String[] should match",expected,actual);

    }



}
