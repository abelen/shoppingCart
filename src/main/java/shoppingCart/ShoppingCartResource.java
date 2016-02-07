package shoppingCart;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * The interface that is used for the Shopping Cart operations.
 */
public interface ShoppingCartResource {

    /**
     * Returns the shopping cart information
     *
     * @return the shopping cart information
     */
    @Get
    public String getShoppingCart();

    /**
     * Creates a shopping cart
     *
     * @param entity the information that is used to create the shopping cart
     * @return the shopping cart
     */
    @Post
    public Representation createShoppingCart(Representation entity);

}
