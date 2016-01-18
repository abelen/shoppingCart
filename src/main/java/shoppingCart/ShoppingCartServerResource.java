package shoppingCart;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.restlet.Server;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.Map;

/**
 * Implementation of {@link ShoppingCartResource}.
 */
public class ShoppingCartServerResource extends BaseResource implements ShoppingCartResource {

    private ShoppingCart shoppingCart;

    public ShoppingCartServerResource() {
        shoppingCart = new ShoppingCart();
    }

    @Get
    public String getShoppingCart() {
        return shoppingCart.toString();
    }

    @Post
    public Representation createShoppingCart(Representation entity) {
        Representation result = null;

        Form form = new Form(entity);
        String cart = form.getFirstValue("cart");

        result = new StringRepresentation("Cart " + cart + " was added.", MediaType.TEXT_PLAIN);

        return result;
    }

    public static void main(String[] args) {
        try {
            new Server(Protocol.HTTP, 8182, ShoppingCartServerResource.class).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String processRequest(Map json, String method) {
        if (method.equals("get")) {
            String returnString = "";
            returnString = new ResponseParseFactory().getSuccessJsonString(getShoppingCart());
            return returnString;
        } else if (method.equals("post")) {
            // TODO: need to implement.
        }
        return null;
    }
}