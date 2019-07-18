package heiniger.daniel.StockTrader.account;

import heiniger.daniel.StockTrader.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;

public class AccountPortSpringTests extends BaseSpringTest {

	@Autowired
	private AccountPort accountPort;

	@Test
	public void accountInformationIsAccessible(){
		ResponseEntity<AccountDTO> accountResponse = accountPort.retrieveAccountInformation();
		System.out.println("Response: " + accountResponse.getBody());
		assertNotNull(accountResponse.getStatusCodeValue());
	}
}
