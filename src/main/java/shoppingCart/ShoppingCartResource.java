package shoppingCart;

import org.restlet.resource.Get;

/**
 * The interface that is used for the Shopping Cart operations.
 */
public interface ShoppingCartResource {

    @Get
    public String getShoppingCart();

}
