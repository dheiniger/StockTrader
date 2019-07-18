package heiniger.daniel.StockTrader.orders;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OrderPortSpringTests extends BaseSpringTest {

    @Autowired
    private OrderPort orderPort;

    @Test
    public void orderInformationIsAccessible(){
        ResponseEntity<List<OrderDTO>> orderResponse = orderPort.retrieveOrders();
        System.out.println("Response: " + orderResponse.getBody());
        assertNotNull(orderResponse.getStatusCodeValue());
    }

    @Test
    public void canPostOrder(){
        ResponseEntity<OrderDTO> orderResponse = orderPort.buy("AAPL", 1);//TODO
        System.out.println("Response: " + orderResponse.getBody());
        assertNotNull(orderResponse.getStatusCodeValue());
    }
}
