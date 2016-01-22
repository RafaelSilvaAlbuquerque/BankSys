package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;

public class AbstractAccountTest {

	//Test Scenario 1 - Check method get number trough class OrdiaryAccount
	@Test
	public void testCheckMethodGetNumber() {
		AbstractAccount ordinayAccount = new OrdinaryAccount("123");
		assertEquals("123", ordinayAccount.getNumber());
	}
	
	//Test Scenario 2 - Check method get getBalance trough OrdinaryAccount
	@Test
	public void testCheckMethodGetBalance(){
		AbstractAccount ordinayAccount = new OrdinaryAccount("123");
		assertEquals(0.0, ordinayAccount.getBalance(),0);
	}
	
	//Test Scenario 3 - Check method credit in amount negative
	@Test (expected=NegativeAmountException.class)
	public void testMethodCreditAmountNegative() throws NegativeAmountException{
		AbstractAccount ordinayAccount = new OrdinaryAccount("123");
		ordinayAccount.credit(-2.0);
	}
	
	//Test Scenario 4 - Check method credit amount positive
	@Test
	public void testMethodCreditAmountPositive() throws NegativeAmountException{
		AbstractAccount ordinayAccount = new OrdinaryAccount("123");
		double  balanceBeforeCredit =  ordinayAccount.getBalance();
	
		ordinayAccount.credit(12.0);
		
		double balanceAfterCredit = ordinayAccount.getBalance();
		
		assertFalse(balanceBeforeCredit == balanceAfterCredit);
	}
	
	
	

}
