package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MarketDTO extends DTO {
    private String symbol;
    private float marketPercent;
    private int bidSize;
    private BigDecimal bidPrice;
    private int askSize;
    private BigDecimal askPrice;
    private int volume;
    private BigDecimal lastSalePrice;
    private long lastSaleTime;
    private long lastUpdated;
    private String sector;
    private String securityType;
}
