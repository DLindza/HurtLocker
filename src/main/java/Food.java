import java.util.ArrayList;
import java.util.Date;

/**
 * Created by devon on 10/17/16.
 */
public class Food {

    private final String name;
    private final String price;
    private final String type;
    private final String expiration;

    public Food(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration= expiration;
    }

    //add price method

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }


    //add expiration method


}
