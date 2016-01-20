package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.SavingsAccount;
import banksys.account.exception.NegativeAmountException;


public class SavingsAccountTest {

	
private SavingsAccount account;
	
	@Before
	public void setUp() throws Exception {
	account = new SavingsAccount("12345");
	}

	@After
	public void tearDown() throws Exception {
	}
/*
 * Test Scenario: Properly earn interest.
 */
	
	@Test
	public void earnInterestTest() throws NegativeAmountException {
		account.credit(1000);
		account.earnInterest();
		assertEquals(1001 , account.getBalance(), 0);
	}

}
