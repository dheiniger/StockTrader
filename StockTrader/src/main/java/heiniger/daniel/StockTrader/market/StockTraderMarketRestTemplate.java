package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.DTO;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StockTraderMarketRestTemplate extends StockTraderRestTemplate{

    public StockTraderMarketRestTemplate(RestTemplate restTemplate, APIProperties properties) {
        super(restTemplate, properties);
    }

    @Override
    protected <D extends DTO> List<D> exchangeList(String location, HttpMethod get, Class<? extends DTO> responseType, Optional<D> body) {
        return (List<D>) restTemplate.exchange(properties.getBaseMarketUrl() + location, get, getHttpRequest(body), List.class)
                .getBody()
                .stream()
                .map(this::jsonObject)
                .map(json -> jsonToDTO(json, responseType))
                .collect(Collectors.toList());
    }

    @Override
    protected <D extends DTO> ResponseEntity<D> request(String location, HttpMethod method, Class<D> responseType, Optional<D> body) {
        return restTemplate.exchange(properties.getBaseMarketUrl() + location, method, getHttpRequest(body), responseType);
    }
}
