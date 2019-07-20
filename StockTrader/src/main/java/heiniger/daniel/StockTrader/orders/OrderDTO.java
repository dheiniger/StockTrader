package heiniger.daniel.StockTrader.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrderDTO implements DTO {
    private String id;

    @JsonProperty("client_order_id")
    private String clientOrderId;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("submitted_at")
    private Date submittedAt;

    @JsonProperty("filled_at")
    private Date filledAt;

    @JsonProperty("expired_at")
    private Date expiredAt;

    @JsonProperty("canceled_at")
    private Date cancelledAt;

    @JsonProperty("failed_at")
    private Date failedAt;

    @JsonProperty("asset_id")
    private String assetId;

    private String symbol;

    @JsonProperty("asset_class")
    private String assetClass;

    private String qty;

    @JsonProperty("filled_qty")
    private Integer filledQty;

    private String type;

    @JsonProperty("order_type")
    private String orderType;
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
