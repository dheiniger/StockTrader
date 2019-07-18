package heiniger.daniel.StockTrader.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrderDTO implements DTO {
    private String id;

    @JsonProperty("client_order_id")
    private String clientOrderId;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("submitted_at")
    private LocalDateTime submittedAt;

    @JsonProperty("filled_at")
    private LocalDateTime filledAt;

    @JsonProperty("expired_at")
    private LocalDateTime expiredAt;

    @JsonProperty("canceled_at")
    private LocalDate cancelledAt;

    @JsonProperty("failed_at")
    private LocalDateTime failedAt;

    @JsonProperty("asset_id")
    private String assetId;

    private String symbol;

    @JsonProperty("asset_class")
    private String assetClass;

    private String qty;

    @JsonProperty("filled_qty")
    private Integer filledQty;

    private String type;

    private String side;

    @JsonProperty("time_in_force")
    private String timeInForce;

    @JsonProperty("limit_price")
    private String limitPrice;

    @JsonProperty("stop_price")
    private String stopPrice;

    @JsonProperty("filled_avg_price")
    private BigDecimal filledAveragePrice;

    private String status;

    @JsonProperty("extended_hours")
    private boolean extendedHours;
}
