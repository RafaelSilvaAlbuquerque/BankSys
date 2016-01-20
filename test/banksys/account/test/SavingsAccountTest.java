package banksys.account.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.SavingsAccount;


public class SavingsAccountTest {

	
private SavingsAccount account;
	
	@Before
	public void setUp() throws Exception {
	account = new SavingsAccount("12345");
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
