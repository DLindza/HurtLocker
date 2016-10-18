import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by devon on 10/17/16.
 */
public class Food {

    private static int milkCounter = 0;
    private static int cookiesCounter = 0;
    private static int breadCounter = 0;
    private static int applesCounter = 0;

    private String name;
    private String price;
    private String type;
    private String expiration;

    public Food(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration= expiration;

    }


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


    public void replaceNameValuePattern() throws NoCurrentValueException {
        if (this.name.equals(null)){
            throw new NoCurrentValueException("This name does not have a value");
        }

        Pattern pattern = Pattern.compile("(?i)^m\\w+");
        Matcher matcher = pattern.matcher(this.name);
        if (matcher.find()){
            this.name = "Milk";
            milkCounter++;
        }

        Pattern pattern1 = Pattern.compile("(?i)^c\\w+");
        Matcher matcher1 = pattern.matcher(this.name);
        if (matcher.find()){
            this.name = "Cookies";
            cookiesCounter++;
        }

       Pattern pattern2 = Pattern.compile("(?i)^b\\w+");
        Matcher matcher2 = pattern.matcher(this.name);
        if (matcher.find()){
            this.name = "Bread";
            breadCounter++;
        }
      Pattern pattern3 = Pattern.compile("(?i)^a\\w+");
        Matcher matcher3 = pattern.matcher(this.name);
        if (matcher.find()){
            this.name = "Apples";
            applesCounter++;
        }
    }

    public void checkPrice() throws NoCurrentValueException {
        if(this.price.equals(null)) {
            throw new NoCurrentValueException("Price has not been assigned a value");
        }
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
