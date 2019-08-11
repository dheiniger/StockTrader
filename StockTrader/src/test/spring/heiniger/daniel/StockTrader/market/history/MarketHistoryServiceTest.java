package heiniger.daniel.StockTrader.market.history;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MarketHistoryServiceTest extends BaseSpringTest {

    @Autowired
    private MarketHistoryService marketHistoryService;

    @Test
    public void canRetrieveAllMarketHistories(){
        marketHistoryService.retrieveAllMarketHistories();
    }
}
