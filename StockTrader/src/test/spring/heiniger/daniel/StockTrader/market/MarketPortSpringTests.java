package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.BaseSpringTest;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarketPortSpringTests extends BaseSpringTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarketPortSpringTests.class);

    @Autowired
    private MarketPort marketPort;
    @Autowired
    private APIProperties properties;

    @Test
    public void canGetMarketData() {
        ResponseEntity<MarketDTO> marketData = marketPort.retrieveAllMarketData();
        assertEquals(HttpStatus.OK, marketData.getStatusCode());
        assertNotNull(marketData.getBody());
        LOGGER.debug(marketData.getBody().toString());
    }
}
