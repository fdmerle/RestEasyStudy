import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;


public class RestEasySender {
    private ResteasyClient client;

    public RestEasySender() {
        client = new ResteasyClientBuilder().build();
    }

    public String sendGetRequest(String url) {
        ResteasyWebTarget target = client.target(url);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close();
        return value;
    }


}
