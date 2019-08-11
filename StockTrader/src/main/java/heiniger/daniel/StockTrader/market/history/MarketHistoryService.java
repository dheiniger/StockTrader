package heiniger.daniel.StockTrader.market.history;

import heiniger.daniel.StockTrader.market.MarketPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MarketHistoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketHistoryService.class);
    private MarketPort marketPort;
    private MarketHistoryPort marketHistoryPort;

    @Autowired
    public MarketHistoryService(MarketPort marketPort, MarketHistoryPort marketHistoryPort) {
        this.marketPort = marketPort;
        this.marketHistoryPort = marketHistoryPort;
    }

    public ResponseEntity<List<MarketHistoryDTO>> retrieveAllMarketHistories() {
        List<String> symbols = marketPort.retrieveStockData()
                .getBody()
                .getTickers()
                .stream()
                .map(t -> t.getName())
                .collect(toList());
        LOGGER.debug("Retrieving history for tickers...");
        LOGGER.debug("{}", symbols);
        return marketHistoryPort.retrieveAllTradeHistory(symbols);
    }
}
