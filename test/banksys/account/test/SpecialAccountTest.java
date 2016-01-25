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
	/**
	 * Test Scenario: Check if the bonus is being 
	 * recovered correctly in the account.
	 */
	@Test
	public void getBonusTest() throws NegativeAmountException {
		account.credit(100);
		assertEquals(1, account.getBonus(), 0);
	}
	
	/**Test Scenario: Check if the bonus is being 
	 * generated correctly in the account.
	*/
	@Test
	public void earnBonusTest() throws NegativeAmountException {
		account.credit(100);
		account.earnBonus();
		assertEquals(101, account.getBalance(), 0);
	}
	
	/*
	 * Test Scenario: Checking Bonus after credit negative.
	 */
	@Test (expected = NegativeAmountException.class)
	public void testBonusNegative() throws NegativeAmountException {
		double bonusBeforeCredit = account.getBonus();
		account.credit(-100);
		account.earnBonus();
		assertEquals(bonusBeforeCredit, account.getBonus(), 0);		
	}

	/*
	 * Test Scenario: Properly crediting a value.
	 */
		@Test
		public void generatingCreditBonus() throws NegativeAmountException {
			account.credit(100);
			double bonus = account.getBonus();
			account.earnBonus();
			double saldo = account.getBalance();
			assertEquals(bonus, saldo - 100, 0);
		}
		
		/*
		 * Test Scenario: Checking credit a negative value.
		 */
	
		@Test(expected = NegativeAmountException.class)
		public void creditNegativeValueTest() throws NegativeAmountException {
			double balanceBeforeCredit = account.getBalance();
			account.credit(-100);
			double balanceAfterCredit = account.getBalance();
			assertEquals(balanceBeforeCredit, balanceAfterCredit, 0);
		}
		
		/*
		 *  Credit positive value
		 */
		@Test
		public void creditPositiveValueTest() throws NegativeAmountException {
			account.credit(100);
			assertEquals(100, account.getBalance(), 0);
		}
}
