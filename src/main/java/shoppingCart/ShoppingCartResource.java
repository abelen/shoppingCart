package shoppingCart;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * The interface that is used for the Shopping Cart operations.
 */
public interface ShoppingCartResource {

    @Get
    public String getShoppingCart();

    @Post
    public Representation createShoppingCart(Representation entity);

}
