package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.TaxAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;



public class TaxAccountTest {

	private TaxAccount account;
	
	@Before
	public void setUp() throws Exception {
		account = new TaxAccount("123ABC");
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 * Checks that are debiting correctly with taxes.
	 */
	@Test
	public void testDebitNormal() throws NegativeAmountException, InsufficientFundsException {
		account.credit(10);
		account.debit(9);
		double result = 10 - (9+(9* 0.001));
		assertEquals(result,account.getBalance(),0);
	}
	
	

}
