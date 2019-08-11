package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.PolygonWebSocketEndpoint;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.format;

@Component
public class MarketPort extends ApiPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketPort.class);

    public MarketPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<MarketDTO> retrieveAllMarketData() {
        LOGGER.info("Retrieving market info...");
        String location = format("%s/tickers?apikey=%s&locale=us&perpage=500",
                apiProperties.getBaseMarketUrl(),
                apiProperties.getMarketDataApiKey());
        ResponseEntity<MarketDTO> market = restTemplate.get(location, MarketDTO.class);
        //todo
        LOGGER.info("What's this size? {}", market.getBody().getTickers().size());
        //TODO
        accumulateTickers();
//        LOGGER.info("What's this? {}", market.getBody().getTickers().stream().filter(t-> t.getTicker().equals("AAPL")).findFirst().get());
        LOGGER.debug("Successfully retrieved market data {}", market);
        return market;
    }

    public ResponseEntity<MarketDTO> retrieveStockData() {
        LOGGER.info("Retrieving stock info...");
        String location = format("%s/tickers?apikey=%s&market=stocks",
                apiProperties.getBaseMarketUrl(),
                apiProperties.getMarketDataApiKey());
        ResponseEntity<MarketDTO> market = restTemplate.get(location, MarketDTO.class);
        LOGGER.info("Successfully retrieved stock data {}", market);
        return market;
    }

    private ResponseEntity<MarketDTO> accumulateTickers(){
        ResponseEntity<MarketDTO> fullMarketInfo = retrieveMarketDataSegment(0);
        ResponseEntity<MarketDTO> marketInfoForSegment = fullMarketInfo;//TODO
        //TODO
        int i = 1;
        while(marketInfoForSegment.getBody().getTickers().size() > 0){
            marketInfoForSegment = retrieveMarketDataSegment(i++);
            fullMarketInfo.getBody().getTickers().addAll(marketInfoForSegment.getBody().getTickers());
        }
        LOGGER.info("Total number of stocks is {}", fullMarketInfo.getBody().getTickers().size());
        return fullMarketInfo;

    }

    private ResponseEntity<MarketDTO> retrieveMarketDataSegment(int pageNumber){
        LOGGER.info("Retrieving market info for page {}...", pageNumber);
        String location = format("%s/tickers?apikey=%s&locale=us&perpage=500&page=%d",
                apiProperties.getBaseMarketUrl(),
                apiProperties.getMarketDataApiKey(),
                pageNumber);
        ResponseEntity<MarketDTO> market = restTemplate.get(location, MarketDTO.class);
        LOGGER.debug("Successfully retrieved market data for page {}: {}",pageNumber, market);
        return market;
    }

    public void retrieveRealTimeStockData() {
        new PolygonWebSocketEndpoint(apiProperties.getRealTimeStockInfoUrl(), apiProperties.getMarketDataApiKey()).connect();
    }

}
