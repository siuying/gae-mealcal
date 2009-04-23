package quiz.meal.web;

import java.util.ArrayList;
import java.util.List;

import quiz.meal.Menu;
import quiz.meal.OrderMaker;
import quiz.meal.model.Item;

public class OrderMakerFacade {
    private OrderMaker orderMaker;
    private Menu menu;
    
    public String[] makeOrder(String ... wantedFood) {
        List<Item> wantedItems = menu.getItems(wantedFood);
        List<Item> order = orderMaker.order(wantedItems.toArray(new Item[0]));
        return getItemNames(order.toArray(new Item[0]));
    }

    private String[] getItemNames(Item ... items) {
        List<String> orderItemNames = new ArrayList<String>();
        for(Item i : items) {
            orderItemNames.add(i.getName());
        }
        return orderItemNames.toArray(new String[0]);
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
