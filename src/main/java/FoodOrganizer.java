import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by devon on 10/18/16.
 */
public class FoodOrganizer {
    ArrayList<Food> foodList = new ArrayList<Food>();
    Map<String, Integer> mapMilkCost = new HashMap<String, Integer>();
    Map<String, Integer> mapCookiesCost = new HashMap<String, Integer>();
    Map<String, Integer> mapBreadCost = new HashMap<String, Integer>();
    Map<String, Integer> mapApplesCost = new HashMap<String, Integer>();



//    public void fixAllNames(Food food) throws NoCurrentValueException {
//
//            try {
//
//            } catch (Exception e) {
//
//            }
//
//    }

//    public void checkPrices(Food food) throws NoCurrentValueException {
//            try {
//
//            } catch (Exception e) {
//
//            }
//    }

    public void makeMilkMap(Food food) {
            if(food.getName().equalsIgnoreCase("milk") && food.getPrice()!=null) {
                if (mapMilkCost.containsKey(food.getPrice())) {
                    mapMilkCost.put(food.getPrice(), mapMilkCost.get(food.getPrice()) + 1);

                } else {
                    mapMilkCost.put(food.getPrice(),1);
                }
            }
    }
    public void makeCookieMap(Food food) {
            if(food.getName().equalsIgnoreCase("Cookies") && food.getPrice()!=null) {
                if (mapCookiesCost.containsKey(food.getPrice())) {
                    mapCookiesCost.put(food.getPrice(), mapCookiesCost.get(food.getPrice()) + 1);

                } else {
                    mapCookiesCost.put(food.getPrice(),1);
                }
            }

    }
    public void makeBreadMap(Food food) {
            if(food.getName().equalsIgnoreCase("Bread") && food.getPrice()!=null) {
                if (mapBreadCost.containsKey(food.getPrice())) {
                    mapBreadCost.put(food.getPrice(), mapBreadCost.get(food.getPrice()) + 1);

                } else {
                    mapBreadCost.put(food.getPrice(),1);
                }
            }
    }
    public void makeAppleMap(Food food) {
            if(food.getName().equalsIgnoreCase("Apples") && food.getPrice()!=null) {
                if (mapApplesCost.containsKey(food.getPrice())) {
                    mapApplesCost.put(food.getPrice(), mapApplesCost.get(food.getPrice()) + 1);

                } else {
                    mapApplesCost.put(food.getPrice(),1);
                }
            }
    }

    public void organizeFood() throws NoCurrentValueException {
       for (Food food : foodList) {
           try {
               food.replaceNameValuePattern();
               food.checkPrice();

           switch (food.getName()) {
               case "Milk" :
                   makeMilkMap(food);
                   break;
               case "Cookies" :
                   makeCookieMap(food);
                   break;
               case "Bread" :
                   makeBreadMap(food);
                   break;
               case "Apples":
                   makeAppleMap(food);
                   break;

           }
           } catch (Exception e) {

           }


       }
    }

    //print everything
    public void printFood(){

        System.out.println("This is going to print stuff");

    }
}
