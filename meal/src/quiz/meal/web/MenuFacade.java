package quiz.meal.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import quiz.meal.Menu;
import quiz.meal.model.Food;
import quiz.meal.model.Item;
import quiz.meal.model.Meal;

public class MenuFacade {
    private Menu menu;

    public Map<String, Map<String, Double>> getFood() {
        Map<String, Map<String, Double>> foodMenu = new HashMap<String, Map<String, Double>>();
        for(Item i : menu.getAllItems().values()) {
            if (i instanceof Food) {
                Food f = (Food) i;
                foodMenu.put(f.getName(), dumpFood(f));
            }
        }        
        return foodMenu;
    }
    
    public Map<String, Map<String, Object>> getMeal() {
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
        foodDump.put("price", meal.getPrice());
        foodDump.put("foods", getItemNames(meal.getFood().toArray(new Food[0])));
        return foodDump;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
