package heiniger.daniel.StockTrader.assets;

import com.fasterxml.jackson.annotation.JsonProperty;
import heiniger.daniel.StockTrader.DTO;
import lombok.Data;

@Data
public class AssetDTO implements DTO {
    private String id;
    @JsonProperty("class")
    private String assetClass;
    private String exchange;
    private String symbol;
    private String status;
    private boolean tradable;
    private boolean marginable;
    private boolean shortable;
    @JsonProperty("easy_to_borrow")
    private boolean easyToBorrow;
}
