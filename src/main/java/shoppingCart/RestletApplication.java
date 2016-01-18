package shoppingCart;

import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by anthonybelen on 1/18/16.
 */
public class RestletApplication extends org.restlet.Application {

    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/carts", ShoppingCartServerResource.class);
        router.attach("/carts/{cart}", ShoppingCartServerResource.class);
        router.attach("/carts/{cart}/items", ShoppingCartServerResource.class);
        return router;
    }
}
