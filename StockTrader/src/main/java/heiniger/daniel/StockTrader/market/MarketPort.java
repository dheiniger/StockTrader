package heiniger.daniel.StockTrader.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MarketPort {

    private StockTraderMarketRestTemplate restTemplate;

    @Autowired
    public MarketPort(StockTraderMarketRestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<MarketDTO> retrieveMarketData(){
        return restTemplate.get("tickers", MarketDTO.class);
    }
}
