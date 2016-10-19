import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by devon on 10/18/16.
 */
public class Inventory {
//// TODO: 10/19/16 decrement counter when it's a null object

    ArrayList<Food> foodList = new ArrayList<Food>();



    ArrayList<Map<String,Integer>> maps = new ArrayList<>();

    Map<String, Integer> mapMilkCost = new HashMap<String, Integer>();
    Map<String, Integer> mapCookiesCost = new HashMap<String, Integer>();
    Map<String, Integer> mapBreadCost = new HashMap<String, Integer>();
    Map<String, Integer> mapApplesCost = new HashMap<String, Integer>();

    public void populateMap(Food food, Map<String,Integer> map) {
        if (map.containsKey(food.getPrice())) {
            map.put(food.getPrice(), map.get(food.getPrice()) + 1);
        } else {
            map.put(food.getPrice(),1);
        }
    }



    public void inventoryPrices() throws NoCurrentValueException {
        for (Food food : foodList) {
            try {
                food.replaceNameValuePattern(food.getName(), Food.milkRegex);
                food.replaceNameValuePattern(food.getName(), Food.cookiesRegex);
                food.replaceNameValuePattern(food.getName(), Food.breadRegex);
                food.replaceNameValuePattern(food.getName(), Food.applesRegex);
                food.checkPrice();

                if (!food.getPrice().equals(null)) {

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



    public void populateMaps() {
        maps.add(mapMilkCost);
        maps.add(mapCookiesCost);
        maps.add(mapBreadCost);
        maps.add(mapApplesCost);
    }


    public void addMap (Map<String,Integer> map) {maps.add(map); }

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
        StringBuilder firstline = new StringBuilder("name:     ");
        firstline.append(name);
        firstline.append("          ");
        firstline.append("seen:  ");
        firstline.append(Food.getCounter(name));
        firstline.append("  times\n");
        firstline.append(createDoubleLineFormat());
        return firstline.toString();
    }

    public String createPriceInventoryFormat(Map<String, Integer> map) {
       StringBuilder priceGroup = new StringBuilder();
        for (String price : map.keySet()) {
            StringBuilder priceLine = new StringBuilder("price:     ");
            priceLine.append(price);
            priceLine.append("          ");
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
        errors.append("          ");
        errors.append("seen:  ");
        errors.append(NoCurrentValueException.counter);
        errors.append("  times");
        return errors.toString();

    }

//    //print everything
//    public void printInventory(){
//       // populateFoodNames();
//        populateMaps();
//      //  for (String name : foodNames) {
//            System.out.println(createNameInventoryFormat(name));
//            for (Map map : maps ) {
//                System.out.println(createPriceInventoryFormat(map));
//            }
//        }
//        System.out.println(printErrors());
//    }
}
