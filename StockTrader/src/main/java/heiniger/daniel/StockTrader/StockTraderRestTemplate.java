package heiniger.daniel.StockTrader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class StockTraderRestTemplate {

    protected RestTemplate restTemplate;
    protected APIProperties properties;
    private ObjectMapper mapper;

    @Autowired
    public StockTraderRestTemplate(RestTemplate restTemplate, APIProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
        this.mapper = defaultObjectMapper();
    }

    public <D extends DTO> ResponseEntity<List<D>> getList(String location, Class<D> responseType){
        List<D> dtos = exchangeList(location, HttpMethod.GET, responseType, Optional.empty());

        return ResponseEntity.of(Optional.of(dtos));
    }

    public <D extends DTO> ResponseEntity<List<D>> postList(String location, Class<D> responseType, Optional<D> body){
        List<D> dtos = exchangeList(location, HttpMethod.POST, responseType, body);

        return ResponseEntity.of(Optional.of(dtos));
    }

    public <D extends DTO>ResponseEntity<D> get(String location, Class<D> responseType) {
        return request(location, HttpMethod.GET, responseType, Optional.empty());
    }

    public <D extends DTO> ResponseEntity<D> post(String location, Class<D> responseType, Optional<D> body) {
        return request(location, HttpMethod.POST, responseType, body);
    }

    protected <D extends DTO> ResponseEntity<D> request(String location, HttpMethod method, Class<D> responseType, Optional<D> body) {
        return restTemplate.exchange(properties.getBaseUrl() + location, method, getHttpRequest(body), responseType);
    }

    protected <D extends DTO> HttpEntity getHttpRequest(Optional<D> body) {
        return new HttpEntity<>(body.orElse(null), getHeaders());
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(properties.getPublicKeyHeader(), properties.getPublicKey());
        headers.set(properties.getPrivateKeyHeader(), properties.getPrivateKey());
        return headers;
    }

    protected <D extends DTO> List<D> exchangeList(String location, HttpMethod get, Class<? extends DTO> responseType, Optional<D> body) {
        return (List<D>) restTemplate.exchange(properties.getBaseUrl() + location, get, getHttpRequest(body), List.class)
                .getBody()
                .stream()
                .map(this::jsonObject)
                .map(json -> jsonToDTO(json, responseType))
                .collect(Collectors.toList());
    }

    protected JSONObject jsonObject(Object o){
        JSONObject json = new JSONObject((Map)o);
        System.out.println("o: " + o.getClass().toString());
        System.out.println("json:" + json);
        return json;
    }

    protected <D extends DTO> D jsonToDTO(Object object, Class<? extends D> type){
        try {
            System.out.println("object: " + object.getClass().toString());
            return mapper.readValue(object.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new DTOMappingFailedException();
    }

    private ObjectMapper defaultObjectMapper(){
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private class DTOMappingFailedException extends RuntimeException{

    }

}