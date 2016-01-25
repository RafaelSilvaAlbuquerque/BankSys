package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.exception.NegativeAmountException;

public class AbstractAccountTest {
	    //Test Scenario 1 - Check method get number trough class OrdiaryAccount
		@Test
		public void testCheckMethodGetNumber() {
			AbstractAccount ordinayAccount = new OrdinaryAccount("123");
			assertEquals("123", ordinayAccount.getNumber());
		}
		
		//Test Scenario 2 - Check method getBalance trough OrdinaryAccount
		@Test
		public void testCheckMethodGetBalance(){
			AbstractAccount ordinayAccount = new OrdinaryAccount("123");
			assertTrue(0.0 == ordinayAccount.getBalance());
		}
		
		//Test Scenario 3 - Check method credit in amount negative
		@Test(expected=NegativeAmountException.class)
		public void testMethodCreditAmountNegative() throws NegativeAmountException{
			AbstractAccount ordinayAccount = new OrdinaryAccount("123");
			ordinayAccount.credit(-2.0);
		}
}
