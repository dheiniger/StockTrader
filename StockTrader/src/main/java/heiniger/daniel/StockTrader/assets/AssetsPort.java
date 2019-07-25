package heiniger.daniel.StockTrader.assets;

import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssetsPort {

    private StockTraderRestTemplate restTemplate;

    @Autowired
    public AssetsPort(StockTraderRestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<AssetDTO>> retrieveAssets(){
        return restTemplate.getList("assets", AssetDTO.class);
    }
}

