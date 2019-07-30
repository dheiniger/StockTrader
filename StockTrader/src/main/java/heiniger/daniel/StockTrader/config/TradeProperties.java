package heiniger.daniel.StockTrader.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@ConfigurationProperties(prefix="heiniger.daniel.stocktrader")
@Getter @Setter
public class TradeProperties {
    private BigDecimal minimumSharePrice;
    private BigDecimal maximumSharePrice;
    private BigDecimal minimumLastDollarVolume;
    private BigDecimal defaultStop;
    private BigDecimal risk;
}
