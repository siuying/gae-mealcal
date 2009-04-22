package quiz.meal.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import quiz.meal.Menu;
import quiz.meal.OrderMaker;
import quiz.meal.model.Food;
import quiz.meal.model.Item;
import quiz.meal.model.Meal;

public class OrderMakerFacade {
    private OrderMaker orderMaker;
    private Menu menu;
    
    public String[] makeOrder(String ... wantedFood) {
        List<Item> wantedItems = menu.getItems(wantedFood);
        List<Item> order = orderMaker.order(wantedItems.toArray(new Item[0]));
        return getItemNames(order.toArray(new Item[0]));
    }
        
    public Map<String, Map<String, Double>> getFoodMenu() {
        Map<String, Map<String, Double>> foodMenu = new HashMap<String, Map<String, Double>>();
        for(Item i : menu.getAllItems().values()) {
            if (i instanceof Food) {
                Food f = (Food) i;
                foodMenu.put(f.getName(), dumpFood(f));
            }
        }        
        return foodMenu;
    }
    
    public Map<String, Map<String, Object>> getMealMenu() {
        Map<String, Map<String, Object>> foodMenu = new HashMap<String, Map<String, Object>>();
        for(Item i : menu.getAllItems().values()) {
            if (i instanceof Meal) {
                Meal m = (Meal) i;
                foodMenu.put(m.getName(), dumpMeal(m));
            }
        }        
        return foodMenu;
    }

    private String[] getItemNames(Item ... items) {
        List<String> orderItemNames = new ArrayList<String>();
        for(Item i : items) {
            orderItemNames.add(i.getName());
        }
        return orderItemNames.toArray(new String[0]);
    }
    
    private Map<String, Double> dumpFood(Food food) {
        Map<String, Double> foodDump = new HashMap<String, Double>();
        foodDump.put("price", food.getPrice());
        return foodDump;
    }
    
    private Map<String, Object> dumpMeal(Meal meal) {
        Map<String, Object> foodDump = new HashMap<String, Object>();
        foodDump.put("price", String.format("%.2f", meal.getPrice()));
        foodDump.put("foods", getItemNames(meal.getFood().toArray(new Food[0])));
        return foodDump;
    }
    /**
     * @param orderMaker the orderMaker to set
     */
    public void setOrderMaker(OrderMaker orderMaker) {
        this.orderMaker = orderMaker;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
