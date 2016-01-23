package shoppingCart;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.List;

/**
 * A shopping cart object that contains items.
 */
public class ShoppingCartItemsResource extends ServerResource {

    String cartId = "";

    List<String> items;

    public ShoppingCartItemsResource(String cartId) {
        this.cartId = cartId;
        items = new ArrayList<String>();
    }

    @Get
    public String toString() {
        return "Items are placed here.";
        /*
        StringBuffer sb = new StringBuffer();
        for (String s : items) {
            sb.append(s.toString());
            sb.append("\n");
        }
        return sb.toString();
        */
    }

    @Post
    public void addToCart(String item) {
        items.add(item);
    }
}
