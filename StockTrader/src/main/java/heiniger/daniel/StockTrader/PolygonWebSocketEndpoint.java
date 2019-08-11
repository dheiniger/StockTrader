package heiniger.daniel.StockTrader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class PolygonWebSocketEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(PolygonWebSocketEndpoint.class);
    private String stockInfoUrl;
    private String apiKey;

    public PolygonWebSocketEndpoint(String stockInfoUrl, String apiKey){
        this.stockInfoUrl = stockInfoUrl;
        this.apiKey = apiKey;
    }

    public void connect(){
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            LOGGER.info("Connecting to " + stockInfoUrl);
            container.connectToServer(this, new URI(stockInfoUrl));
        } catch (DeploymentException | IOException | URISyntaxException e) {
            LOGGER.error("Could not connect to {}", stockInfoUrl, e);
            throw new WebSocketConnectionFailedException(e.getMessage());
        }
        LOGGER.info("Connected successfully");
    }

    public void subscribe(){

    }

    @OnMessage
    public void onMessage(String message) {
        LOGGER.info("Message recieved! {}", message);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        LOGGER.info("Authenticating...");
        String message = "{\"action\":\"auth\",\"params\":\"" + apiKey + "\"}";
        LOGGER.info("sending message for authentication... {}", message);
        session.getAsyncRemote().sendText(message);
    }

    public class WebSocketConnectionFailedException extends RuntimeException{
        private WebSocketConnectionFailedException(String message){
            super(message);
        }
    }
}
