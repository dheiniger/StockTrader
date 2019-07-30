package heiniger.daniel.StockTrader.market.history;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class MarketHistoryPort extends ApiPort {

    public MarketHistoryPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<TradeHistoryDTO> retrieveTradeHistory(String symbol){
        return restTemplate.get(format("%s/stocks/%s?apikey=%s", apiProperties.getBaseHistoryUrl(), symbol, apiProperties.getMarketDataApiKey()), TradeHistoryDTO.class);
    }

}
