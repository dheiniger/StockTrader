package heiniger.daniel.StockTrader.run;

import heiniger.daniel.StockTrader.market.MarketPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController//TODO
public class Trader {
    //1.  identify stocks
    //2.  buy stocks
    //3.  sell stocks at appropriate time.

    private MarketPort marketPort;

    @Autowired
    public Trader(MarketPort marketPort){
        this.marketPort = marketPort;
    }

    //TODO get rid of, or move this
    @RequestMapping("/")
    public String test(){
        marketPort.retrieveRealTimeStockData();
        return "Test 1";
    }
}

