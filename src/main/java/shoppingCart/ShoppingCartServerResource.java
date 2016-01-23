package shoppingCart;

import org.restlet.Component;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Implementation of {@link ShoppingCartResource}.
 */
public class ShoppingCartServerResource extends ServerResource implements ShoppingCartResource {

    public ShoppingCartServerResource() {

    }

    @Get("txt")
    public String getShoppingCart() {
        String cartId = (String) getRequestAttributes().get("cart_id");
        return "Cart " + cartId.toString();
    }

    @Post
    public Representation createShoppingCart(Representation entity) {
        Representation result = null;

        Form form = new Form(entity);
        String cartId = form.getFirstValue("cart_id");

        result = new StringRepresentation("Cart " + cartId + " was added.", MediaType.TEXT_PLAIN);

        ShoppingCartItemsResource shoppingCart = new ShoppingCartItemsResource(cartId);

        return result;
    }

    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);

        component.getDefaultHost().attach("/carts", ShoppingCartServerResource.class);
        component.getDefaultHost().attach("/carts/{cart_id}", ShoppingCartServerResource.class);
        component.getDefaultHost().attach("/carts/{cart_id}/items", ShoppingCartItemsResource.class);

        component.start();
    }

    /*
    @Override
    public String processRequest(Map json, String method) {
        if (method.equals("get")) {
            String returnString = "";
            returnString = new ResponseParseFactory().getSuccessJsonString(getShoppingCart());
            return returnString;
        } else if (method.equals("post")) {
            //createShoppingCart();
        }
        return null;
    }
    */
}