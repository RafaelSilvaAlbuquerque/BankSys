package banksys.controller.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.SavingsAccount;

public class BankControllerTest {

private AbstractAccount account;
	
	@Before
	public void setUp() throws Exception {
	account = new SavingsAccount("123456");
	}

	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
