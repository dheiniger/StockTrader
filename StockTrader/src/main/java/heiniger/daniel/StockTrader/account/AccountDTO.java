package heiniger.daniel.StockTrader.account;

import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountDTO implements  DTO {
    private String id;
    private String currency;
    private BigDecimal buyingPower;
    private BigDecimal cash;
    private BigDecimal portfolioValue;
    private boolean patternDayTrader;
    private boolean tradingBlocked;
    private boolean transfersBlocked;
    private boolean accountBlocked;
    private Date createdAt;
    private boolean tradeSuspendedByUser;
    private int multiplier;
    private boolean shortingEnabled;
    private BigDecimal equity;
    private BigDecimal lastEquity;
    private BigDecimal longMarketValue;
    private BigDecimal shortMarketValue;
    private BigDecimal initialMargin;
    private BigDecimal sma;
    private int daytradeCount;
}
