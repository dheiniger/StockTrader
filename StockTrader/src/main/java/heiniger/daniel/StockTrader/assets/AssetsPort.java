package heiniger.daniel.StockTrader.assets;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@Component
public class AssetsPort extends ApiPort {

    public AssetsPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<List<AssetDTO>> retrieveAssets(){
        return restTemplate.getList(format("%s/assets", apiProperties.getBaseUrl()), AssetDTO.class);
    }
}

