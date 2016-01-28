package banksys.controller.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;
import banksys.persistence.AccountVector;
import banksys.persistence.IAccountRepository;


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
		 * Atualizar o método "mumberof" por "numberof"
		 */
		@Test
		public void addAccountTest() throws BankTransactionException  {
		controller.addAccount(account);
		assertEquals(1 , repository.mumberOfAccounts(), 0);

		}




		


}
