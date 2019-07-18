package heiniger.daniel.StockTrader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("paper")
public class BaseSpringTest {

    @Test
    public void contextLoads(){
        assertFalse(false);
    }
}
