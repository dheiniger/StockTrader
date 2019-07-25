package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.DTO;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

    //FOR TESTING ONLY
    public ResponseEntity<String> get(String location){
        return request(location, HttpMethod.GET, Optional.empty());
    }

    //FOR TESTING ONLY
    protected ResponseEntity<String> request(String location, HttpMethod method, Optional<String> body) {
        return restTemplate.exchange(properties.getBaseMarketUrl() + location, method, getHttpRequestForTesting(body), String.class);
    }

    //FOR TESTING ONLY
    protected HttpEntity getHttpRequestForTesting(Optional<String> body) {
        return new HttpEntity<>(body.orElse(null), getHeaders());
    }

    //FOR TESTING ONLY
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(properties.getPublicKeyHeader(), properties.getPublicKey());
        headers.set(properties.getPrivateKeyHeader(), properties.getPrivateKey());
        return headers;
    }

    @Override
    protected <D extends DTO> List<D> exchangeList(String location, HttpMethod get, Class<? extends DTO> responseType, Optional<D> body) {
        return (List<D>) restTemplate.exchange(properties.getBaseMarketUrl() + location + "?apikey=" + properties.getMarketDataApiKey(), get, getHttpRequest(body), List.class)
                .getBody()
                .stream()
                .map(this::jsonObject)
                .map(json -> jsonToDTO(json, responseType))
                .collect(Collectors.toList());
    }

    @Override
    protected <D extends DTO> ResponseEntity<D> request(String location, HttpMethod method, Class<D> responseType, Optional<D> body) {
        return restTemplate.exchange(properties.getBaseMarketUrl() + location + "?apikey=" + properties.getMarketDataApiKey(), method, getHttpRequest(body), responseType);
    }
}
