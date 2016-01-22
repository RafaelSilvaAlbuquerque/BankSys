package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;

public class AbstractAccountTest {

	//Test Scanerio 1 = Check method get number trough class OrdiaryAccount
	
	@Test
	public void testCheckMehotdGetNumber() {
		AbstractAccount ordinayAccount = new OrdinaryAccount("123");
		assertEquals("123", ordinayAccount.getNumber());
	}

}
