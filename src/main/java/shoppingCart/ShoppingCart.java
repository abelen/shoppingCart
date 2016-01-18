package shoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * A shopping cart object that contains items.
 */
public class ShoppingCart {

    List<String> items;

    public ShoppingCart() {
        items = new ArrayList<String>();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (String s : items) {
            sb.append(s.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addToCart(String item) {
        items.add(item);
    }
}
