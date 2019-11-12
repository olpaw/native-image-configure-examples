import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.net.URLConnection;

public class Configuration {

    Handler handler;

    public Configuration(@JsonProperty("handlerClassName") String handlerClassName) throws Throwable {
        handler = (Handler) Class.forName(handlerClassName).getConstructor().newInstance();
    }

    public static Configuration loadFromFile() throws Throwable {
        URL resourceURL = Configuration.class.getResource("configuration.json");
        resourceURL.openConnection().setDefaultUseCaches(false);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resourceURL, Configuration.class);
    }
}
