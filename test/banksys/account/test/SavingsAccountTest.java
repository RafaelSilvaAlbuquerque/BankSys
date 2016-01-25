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
	
	/*
	 * Test Scenario: Checking Interest after credit negative.
	 */
	@Test (expected = NegativeAmountException.class)
	public void testBonusNegative() throws NegativeAmountException {
		double balanceBeforeNegativeCredit = account.getBalance();
		account.credit(-100);
		account.earnInterest();
		assertEquals(balanceBeforeNegativeCredit, account.getBalance(), 0);		
	}

	/*
	 * Test Scenario: Generate interest for empty account.
	 */
	@Test
	public void emptyAccountTest() throws NegativeAmountException {
		account.earnInterest();
		assertEquals(0 , account.getBalance(), 0);
	}
	
	/*
	 * Test Scenario: Earn interest more than once.
	 */
	@Test
	public void earnInterestTwice() throws NegativeAmountException {
		account.credit(1000);
		account.earnInterest(); // result expected = 1001
		account.earnInterest(); // result expected = 1001 + (1001 * 0.001)
		double result = 1001 + (1001 * 0.001);
		assertEquals(result , account.getBalance(), 0);
	}
	
	
	/*
	 * Test Scenario: Earn interest into account with a balance with decimals.
	 */
	@Test
	public void earnInterestBallanceWithDecimals() throws NegativeAmountException {
		account.credit(105.2);
		account.earnInterest(); 		
		assertEquals(105.3052 , account.getBalance(), 0);
	}
	
	
	
}
