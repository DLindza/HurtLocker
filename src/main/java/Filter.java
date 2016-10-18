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

    public String valuePattern(String currentFoodItemProperty, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(currentFoodItemProperty);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }


    public void assignValueIntoFoodObject() {

        for (String[] currentFoodItem : rawFoodData) {
                String name = valuePattern(currentFoodItem[0], "(?<=[:])\\w+");
                String price = valuePattern(currentFoodItem[1], "(?<=[:])\\w+\\W+\\w+\\b");
                String type = valuePattern(currentFoodItem[2],"(?<=[:])\\w+");
                String expiration = valuePattern(currentFoodItem[3],"(?<=[:])\\w+\\W+\\w+\\W+\\w+\\b");

                Food food = new Food(name, price, type, expiration);
                foodList.add(food);
        }
    }

    public void populateRawFoodDataList(String output) {
        String[] objects = splitByObjects(output);
        for (int i = 0; i < objects.length; i++) {
            String[] currentFoodItem = splitByPairs(objects[i]);
            rawFoodData.add(currentFoodItem);
        }


    }

}











