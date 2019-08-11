package heiniger.daniel.StockTrader.market.history;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Component
public class MarketHistoryPort extends ApiPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketHistoryPort.class);

    public MarketHistoryPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<List<MarketHistoryDTO>> retrieveAllTradeHistory(List<String> symbols){
        return new ResponseEntity<List<MarketHistoryDTO>>(symbols.stream()
                .map(s->retrieveTradeHistory(s).getBody()).collect(toList()), HttpStatus.OK);
    }

    public ResponseEntity<MarketHistoryDTO> retrieveTradeHistory(String symbol){
        //TODO
        try{
            ResponseEntity<MarketHistoryDTO> marketHistory = restTemplate.get(format("%s/stocks/%s?apikey=%s",
                    apiProperties.getBaseHistoryUrl(),
                    symbol,
                    apiProperties.getMarketDataApiKey()),
                    MarketHistoryDTO.class);
            LOGGER.debug("Found market history for {}", symbol);
            return marketHistory;
        }catch(HttpClientErrorException.NotFound e){
            LOGGER.debug("Could not retrieve market history for {}", symbol);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
