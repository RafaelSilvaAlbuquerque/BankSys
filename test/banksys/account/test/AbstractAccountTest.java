package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;

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
}
