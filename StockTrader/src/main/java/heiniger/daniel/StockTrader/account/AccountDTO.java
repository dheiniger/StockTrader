package heiniger.daniel.StockTrader.account;

import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.util.Date;

@Data
public class AccountDTO extends DTO {
    private String id;
    private String poop;
    private String currency;
    private long buyingPower;
    private long cash;
    private long portfolioValue;
    private boolean patternDayTrader;
    private boolean tradingBlocked;
    private boolean transfersBlocked;
    private boolean accountBlocked;
    private Date createdAt;
    private boolean tradeSuspendedByUser;
    private int multiplier;
    private boolean shortingEnabled;
    private long equity;
    private long lastEquity;
    private long longMarketValue;
    private long shortMarketValue;
    private long initialMargin;
    private long sma;
    private int daytradeCount;
}
