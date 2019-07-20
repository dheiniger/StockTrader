package heiniger.daniel.StockTrader.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="heiniger.daniel.stocktrader")
@Getter @Setter
public class APIProperties {
    private String baseUrl;
    private String baseMarketUrl;
    private String privateKeyHeader;
    private String privateKey;
    private String publicKeyHeader;
    private String publicKey;
    private String polygonMarketKey;
}
