package shoppingCart;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * A shopping cart client.
 */
public class ShoppingCartClient {

    public static void main(String[] args) throws IOException {

        ClientResource resource = new ClientResource("http://localhost:8182/carts/");

        Form form = new Form();
        form.add("cart_id", "123");

        resource.post(form).write(System.out);

        ClientResource resource2 = new ClientResource("http://localhost:8182/carts/123");

        System.out.println(resource2.get().getText());

        ClientResource resource3 = new ClientResource("http://localhost:8182/carts/123/items");

        System.out.println(resource3.get());
    }
}
