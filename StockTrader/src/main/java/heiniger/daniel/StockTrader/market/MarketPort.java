package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class MarketPort extends ApiPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketPort.class);

    public MarketPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<MarketDTO> retrieveMarketData(){
        LOGGER.debug("Retrieving tickers...");
        return restTemplate.get(format("%s/tickers?apikey=%s", apiProperties.getBaseMarketUrl(), apiProperties.getMarketDataApiKey()), MarketDTO.class);
    }

}
