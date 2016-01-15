package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banksys.account.SpecialAccount;
import banksys.account.exception.NegativeAmountException;


public class SpecialAccountTest {

	private SpecialAccount account = null;
	
	@Before
	public void setUp() throws Exception {
		account = new SpecialAccount("123ABC");
	}
	
	@Test
	public void getBonusTest() throws NegativeAmountException {
		account.credit(100);
		assertEquals(1, account.getBonus(), 0);
	}

}
