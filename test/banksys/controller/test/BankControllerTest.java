package banksys.controller.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.account.exception.NegativeAmountException;
import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;
import banksys.persistence.AccountVector;
import banksys.persistence.IAccountRepository;
import banksys.persistence.exception.AccountDeletionException;


public class BankControllerTest {
	
	private BankController controller;
	private IAccountRepository repository = new AccountVector();
	private SavingsAccount account = new SavingsAccount("12345");
	private SpecialAccount account2 = new SpecialAccount("2222");


	@Before
	public void setUp() throws Exception {
	controller = new BankController(repository);
	}


	@After
	public void tearDown() throws Exception {
	}

		/*
		 * Test Scenario: Test Scenario addAccount Controller.
		 * 
		 */
		@Test
		public void addAccountTest() throws BankTransactionException  {
		controller.addAccount(account);
		assertEquals(1 , repository.numberOfAccounts(), 0);

		}

		/*
		 * Test Scenario: Test Scenario removeAccount Controller.
		 * 
		 */

		@Test
		public void removeAccountTest() throws BankTransactionException  {
		controller.addAccount(account);
		controller.removeAccount(account.getNumber());
		assertEquals(0, repository.numberOfAccounts(), 0);

		}

		/**
		 * Test Scenario: Remove Account with inexistent number
		 * @throws BankTransactionException
		 */
		
		@Test(expected = BankTransactionException.class)
		public void removeAccountNullTest() throws BankTransactionException  {
			controller.removeAccount("113489");
			
		}
		
		/**
		 * Test Scenario: do credit test
		 * 
		 */
		
		@Test
		public void doCreditTest() throws BankTransactionException  {
		controller.addAccount(account);
		controller.doCredit("12345", 250);
		assertEquals(250, account.getBalance(), 0);
			
		}

		

}
