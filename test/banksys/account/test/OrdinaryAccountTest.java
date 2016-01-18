package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.OrdinaryAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;

public class OrdinaryAccountTest {

	
	// Test Scenario 1: Debit of account in balance Empty
	@Test (expected=InsufficientFundsException.class)
	public void testDebitAccountBalanceEmpty() throws NegativeAmountException, InsufficientFundsException {
		OrdinaryAccount ordinayAccount = new OrdinaryAccount("1234");
		ordinayAccount.debit(12);	
	}

}
