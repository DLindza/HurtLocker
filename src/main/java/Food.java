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

    public final static String milkRegex = "(?i)^m\\w+";
    public final static String cookiesRegex = "(?i)^c\\w+";
    public final static String breadRegex = "(?i)^b\\w+";
    public final static String applesRegex = "(?i)^a\\w+";



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

   public void replaceNameValuePattern(String foodName, String regex) throws NoCurrentValueException {
        if (foodName == null) {
            throw new NoCurrentValueException("This name does not have a value");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(foodName);
        if (m.find()) {

            //use a map Map <Regex, Integer>
            switch (regex) {
                case milkRegex:
                    name = "Milk";
                    milkCounter++;
                    break;
                case cookiesRegex:
                    name = "Cookies";
                    cookiesCounter++;
                    break;
                case breadRegex:
                    name = "Bread";
                    breadCounter++;
                    break;
                case applesRegex:
                    name = "Apples";
                    applesCounter++;
                    break;
            }
        }
    }


    public void checkPrice() throws NoCurrentValueException {
        if (this.price == null) {
            switch (name) {
                case "Milk":
                    milkCounter--;
                    break;
                case "Cookies":
                    cookiesCounter--;
                    break;
                case "Bread":
                    breadCounter--;
                    break;
                case "Apples":
                    applesCounter--;
                    break;
            }
            throw new NoCurrentValueException("Price has not been assigned a value");
        }

    }

    public static int getCounter(String name) {
        int temp = 0;
        switch (name) {
            case "Milk":
                temp = milkCounter;
                break;
            case "Cookies":
                temp = cookiesCounter;
                break;
            case "Bread":
                temp = breadCounter;
                break;
            case "Apples":
                temp = applesCounter;
                break;
        }
        return temp;
    }


}
