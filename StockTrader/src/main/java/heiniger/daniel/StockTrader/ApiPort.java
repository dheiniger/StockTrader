package heiniger.daniel.StockTrader;

import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class ApiPort {

    protected StockTraderRestTemplate restTemplate;
    protected APIProperties apiProperties;

    @Autowired
    public ApiPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties){
        this.restTemplate = restTemplate;
        this.apiProperties = apiProperties;
    }
}
