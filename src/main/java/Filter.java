import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by devon on 10/17/16.
 */


public class Filter {
    int exceptions = 0;
    ArrayList<Food> foodList = new ArrayList<Food>();
    ArrayList<String[]> rawFoodData = new ArrayList<String[]>();


    public String[] splitByObjects(String output) {
        return output.split("##");
    }

    public String[] splitByPairs(String foodItem) {
        return foodItem.split("[^\\w:./]");
    }

    public String valueStringPattern(String currentFoodItemProperty) {
        Pattern pattern = Pattern.compile(":\\w+");
        Matcher matcher = pattern.matcher(currentFoodItemProperty);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public String valuePricePattern(String currentFoodItemProperty) {
        Pattern pattern = Pattern.compile(":\\w+\\W+\\w+");
        Matcher matcher = pattern.matcher(currentFoodItemProperty);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public String valueDatePattern(String currentFoodItemProperty) {
        Pattern pattern = Pattern.compile(":\\w+\\W+\\w+\\W+\\w+");
        Matcher matcher = pattern.matcher(currentFoodItemProperty);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public void assignValue() {

        for (String[] foodObject : rawFoodData) {
            for (int i = 0; i < 1; i++) {
                String name = valueStringPattern(foodObject[i]);
                String price = valuePricePattern(foodObject[i + 1]);
                String type = valueStringPattern(foodObject[i + 2]);
                String expiration = valueDatePattern(foodObject[i + 3]);

                Food food = new Food(name, price, type, expiration);
                foodList.add(food);
            }
        }
    }


    public void createFoodObject(String output) {
        String[] objects = splitByObjects(output);
        for (int i = 0; i < objects.length; i++) {
            String[] currentFoodItem = splitByPairs(objects[i]);
            rawFoodData.add(currentFoodItem);
        }


    }

}











