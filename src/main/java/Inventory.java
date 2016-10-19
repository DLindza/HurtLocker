import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by devon on 10/18/16.
 */
public class Inventory {
//// TODO: 10/19/16 decrement counter when it's a null object

    ArrayList<Food> foodList = new ArrayList<Food>();

    Map<String,Map<String,Integer>> mapList = new LinkedHashMap<>();

    Map<String, Integer> mapMilkCost = new HashMap<String, Integer>();
    Map<String, Integer> mapCookiesCost = new HashMap<String, Integer>();
    Map<String, Integer> mapBreadCost = new HashMap<String, Integer>();
    Map<String, Integer> mapApplesCost = new HashMap<String, Integer>();

    public void populateMap(Food food, Map<String,Integer> map) {
        String price = food.getPrice();
        if (map.containsKey(price)) {
            map.put(price, map.get(price) + 1);
        } else {
            map.put(price,1);
        }
    }

    public void fixUpFood(Food food) throws NoCurrentValueException {
        food.replaceNameValuePattern(food.getName(), Food.milkRegex);
        food.replaceNameValuePattern(food.getName(), Food.cookiesRegex);
        food.replaceNameValuePattern(food.getName(), Food.breadRegex);
        food.replaceNameValuePattern(food.getName(), Food.applesRegex);
        food.checkPrice();
    }

    public void inventoryPrices()  {
        for (Food food : foodList) {
            try {
                fixUpFood(food);
                if (food.getPrice() != null) {

                    switch (food.getName()) {
                        case "Milk":
                            populateMap(food, mapMilkCost);
                            break;
                        case "Cookies":
                            populateMap(food, mapCookiesCost);
                            break;
                        case "Bread":
                            populateMap(food, mapBreadCost);
                            break;
                        case "Apples":
                            populateMap(food, mapApplesCost);
                            break;
                    }

                }
            } catch (Exception e) {
                NoCurrentValueException.counter++;
            }
        }
    }

    public void populateMapList() {
        mapList.put("Milk",mapMilkCost);
        mapList.put("Bread", mapBreadCost);
        mapList.put("Cookies", mapCookiesCost);
        mapList.put("Apples", mapApplesCost);
    }

    public String createDoubleLineFormat() {
        StringBuilder line = new StringBuilder("=============");
        line.append("             ");
        line.append("=============");
        return line.toString();

    }

    public String createSingleLineFormat() {
        StringBuilder line = new StringBuilder("-------------");
        line.append("             ");
        line.append("-------------");
        return line.toString();

    }

    public String createNameInventoryFormat(String name) {
        StringBuilder firstline = new StringBuilder("name:   ");
        firstline.append(name);
        firstline.append("           ");
        firstline.append("seen:  ");
        firstline.append(Food.getCounter(name));
        firstline.append("  times\n");
        firstline.append(createDoubleLineFormat());
        return firstline.toString();
    }

    public String createPriceInventoryFormat(Map<String, Integer> map) {
       StringBuilder priceGroup = new StringBuilder();
        for (String price : map.keySet()) {
            StringBuilder priceLine = new StringBuilder("price:   ");
            priceLine.append(price);
            priceLine.append("           ");
            priceLine.append("seen:  ");
            priceLine.append(map.get(price));
            priceLine.append("  times\n");
            priceLine.append(createSingleLineFormat());
            priceLine.append("\n");
            priceGroup.append(priceLine.toString());
        }
        return priceGroup.toString();
    }

    public String printErrors() {
        StringBuilder errors = new StringBuilder("Errors:    ");
        errors.append("             ");
        errors.append("seen:  ");
        errors.append(NoCurrentValueException.counter);
        errors.append("  times");
        return errors.toString();

    }

    //print everything
    public void printInventory(){
        populateMapList();

        for (String name : mapList.keySet()) {
            System.out.println(createNameInventoryFormat(name));
            System.out.println(createPriceInventoryFormat(mapList.get(name)));
            }
        System.out.println(printErrors());
        }
}

