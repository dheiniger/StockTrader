package heiniger.daniel.StockTrader.market.history;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarketHistoryPortTest extends BaseSpringTest {

    @Autowired
    private MarketHistoryPort port;

    @Test
    public void canRetrieveHistoricDataForSymbol(){
        ResponseEntity<TradeHistoryDTO> tradeHistory = port.retrieveTradeHistory("AAPL");
        assertEquals(HttpStatus.OK, tradeHistory.getStatusCode());
        assertNotNull(tradeHistory.getBody());
        System.out.println(tradeHistory.getBody().toString());
    }
}
