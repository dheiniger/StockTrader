package heiniger.daniel.StockTrader.account;

import heiniger.daniel.StockTrader.ApiPort;
import heiniger.daniel.StockTrader.StockTraderRestTemplate;
import heiniger.daniel.StockTrader.config.APIProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class AccountPort extends ApiPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountPort.class);

    public AccountPort(StockTraderRestTemplate restTemplate, APIProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public ResponseEntity<AccountDTO> retrieveAccountInformation() {
        LOGGER.debug("Retrieving Account Information...");
        return restTemplate.get(format("%s/account", apiProperties.getBaseUrl()), AccountDTO.class);
    }

}
