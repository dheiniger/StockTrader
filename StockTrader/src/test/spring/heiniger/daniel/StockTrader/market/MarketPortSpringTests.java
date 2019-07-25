package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarketPortSpringTests extends BaseSpringTest {

    @Autowired
    private MarketPort marketPort;

    @Test
    public void canGetMarketData(){
        ResponseEntity<MarketDTO> marketData = marketPort.retrieveMarketData();
        assertEquals(HttpStatus.OK, marketData.getStatusCode());
        assertNotNull(marketData.getBody());
        System.out.println(marketData.getBody().toString());
    }
}
