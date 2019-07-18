package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.DTO;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class StockTraderMarketRestTemplate extends StockTraderRestTemplate{

    public StockTraderMarketRestTemplate(RestTemplate restTemplate, APIProperties properties) {
        super(restTemplate, properties);
    }

    @Override
    protected <D extends DTO> ResponseEntity<D> request(String location, HttpMethod method, Class<D> responseType, Optional<D> body) {
        return restTemplate.exchange(properties.getBaseMarketUrl() + location, method, getHttpRequest(body), responseType);
    }
}
