package heiniger.daniel.StockTrader.orders;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderPort extends ApiPort {

    public OrderPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<List<OrderDTO>> retrieveOrders(){
        return restTemplate.getList(apiProperties.getBaseUrl() + "orders", OrderDTO.class);
    }

    public ResponseEntity<OrderDTO> buy(String stockSymbol, Integer amount){
        OrderDTO order = new OrderDTO();
        order.setSymbol(stockSymbol);
        order.setQty(amount.toString());
        order.setSide("buy");
        order.setType("market");
        order.setTimeInForce("day");
        return restTemplate.post(apiProperties.getBaseUrl() + "orders", OrderDTO.class, Optional.of(order));
    }
}
