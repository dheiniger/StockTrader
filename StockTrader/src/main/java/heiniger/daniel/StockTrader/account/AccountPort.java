package heiniger.daniel.StockTrader.account;

import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountPort {

    private StockTraderRestTemplate restTemplate;

    @Autowired
    public AccountPort(StockTraderRestTemplate restTemplate, APIProperties properties) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<AccountDTO> retrieveAccountInformation() {
//       return restTemplate.get("account", AccountDTO.class);
       return null;//TODO
    }

}
