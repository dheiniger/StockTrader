package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MarketDTO implements DTO {
    private String symbol;//"Snap"
    private float marketPercent;
    private int bidSize;//0
    private BigDecimal bidPrice;//0
    private int askSize;//0
    private BigDecimal askPrice;//0
    private long volume;
    private BigDecimal lastSalePrice;//14.925
    private int lastSaleSize;
    private long lastSaleTime;
    private long lastUpdated;//156...
    private String sector;//"mediaentertainment
    private String securityType;//"commonstock"
}
