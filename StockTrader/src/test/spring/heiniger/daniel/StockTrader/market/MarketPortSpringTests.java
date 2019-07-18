package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MarketPortSpringTests extends BaseSpringTest {

    @Autowired
    private MarketPort marketPort;

    @Test
    public void canGetMarketData(){
        System.out.println(marketPort.retrieveMarketData());
    }
}
