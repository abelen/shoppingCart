package shoppingCart;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.io.IOException;

/**
 * A shopping cart client.
 */
public class ShoppingCartClient {

    public static void main(String[] args) {

        ClientResource resource = new ClientResource("http://localhost:8182/carts");

        Form form = new Form();
        form.add("cart", "123");
        form.add("uname", "John");

        try {
            resource.post(form).write(System.out);
            System.out.println(resource.getResponse());
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
