package heiniger.daniel.StockTrader.market.history;

import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradeHistoryDTO implements DTO {
    private String status;
    private String symbol;
    private Last last;

    @Data
    private static class Last{
        private BigDecimal price;
        private int size;
        private int exchange;
    }

}
