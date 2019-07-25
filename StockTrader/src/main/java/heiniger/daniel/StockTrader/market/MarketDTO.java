package heiniger.daniel.StockTrader.market;

import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MarketDTO implements DTO {

    private List<Ticker> tickers;

    @Data
    private static class Ticker {
        private String ticker;
        private String name;
        private String market;
        private String locale;
        private String currency;
        private boolean active;
        private String primaryExch;
        private Date updated;
        private String url;
    }
}
