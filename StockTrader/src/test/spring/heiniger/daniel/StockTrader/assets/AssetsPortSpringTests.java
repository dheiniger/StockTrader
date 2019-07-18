package heiniger.daniel.StockTrader.assets;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AssetsPortSpringTests extends BaseSpringTest {

    @Autowired
    private AssetsPort assetsPort;

    @Test
    public void assetInformationIsAccessible(){
        ResponseEntity<List<AssetDTO>> assetsResponse = assetsPort.retrieveAssets();
        assertNotNull(assetsResponse.getBody());
    }
}
