package heiniger.daniel.StockTrader.orders;

import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.integration.IntegrationGraphEndpoint;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class OrderPort {

    private StockTraderRestTemplate restTemplate;

    @Autowired
    public OrderPort(StockTraderRestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<OrderDTO>> retrieveOrders(){
        return restTemplate.getList("orders", OrderDTO.class);
    }

    public ResponseEntity<OrderDTO> buy(String stockSymbol, Integer amount){
        OrderDTO order = new OrderDTO();
        order.setSymbol(stockSymbol);
        order.setQty(amount.toString());
        order.setSide("buy");
        order.setType("market");
        order.setTimeInForce("day");
        return restTemplate.post("orders", OrderDTO.class, Optional.of(order));
    }
}
