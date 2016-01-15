package banksys.persistence.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;
import banksys.persistence.AccountVector;
import banksys.persistence.exception.AbstractAccountEmptyException;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;

public class AccountVectorTest {

	
	/*Cenario de Teste 01 - Criando vetor de contas com sucesso
	 * Dados de Entrada: Conta Ordinary
	 * Dados de Saida: Vetor de contas criado e populado*/
	@Test
	public void testPopulandoVectorContasNormal() throws AccountCreationException{
		AccountVector accountVector = new AccountVector();
		OrdinaryAccount account = new OrdinaryAccount("1234");
		
		int numberBefore = accountVector.mumberOfAccounts(); 
		
		accountVector.create(account);
		
		int numberAfter = accountVector.mumberOfAccounts(); 
		
		//verificando o tamanho do vector de contas antes e depois da insercao
		assertFalse(numberAfter == numberBefore);
	}
	
	/*Test Scenario 02: Check add accounts with number account equals 
	 * */
	
	@Test (expected=AccountCreationException.class)
	public void testPopulandoVectorContasComUmaJaExistente() throws AccountCreationException{
		AccountVector accountVector = new AccountVector();
		OrdinaryAccount accountA = new OrdinaryAccount("1234");
		OrdinaryAccount accountB = new OrdinaryAccount("1234");
		
		accountVector.create(accountA);
		accountVector.create(accountB);
	}
	
	/*Test Scenario 03: Check method mumberOfAccounts in number of account equals zero and one*/
	@Test
	public void testNumeroDeContas() throws AccountCreationException{
		AccountVector accountVector = new AccountVector();
		assertEquals(0, accountVector.mumberOfAccounts());
		
		OrdinaryAccount accountA = new OrdinaryAccount("1234");
		accountVector.create(accountA);
		assertEquals(1, accountVector.mumberOfAccounts());
	}
	
	/*Test Scenario 04: Check method delete account with account doesn't exist*/
	@Test (expected=AccountDeletionException.class)
	public void testRemoverContaQaundoNaoExiste() throws AccountDeletionException{
		AccountVector accountVector = new AccountVector();
		accountVector.delete("1234");
	}
	
	/*Test Scenario 05: Check method list account with vector empty*/
	@Test (expected=AbstractAccountEmptyException.class)
	public void testListarVetorContasVazio() throws AbstractAccountEmptyException{
		AccountVector accountVector = new AccountVector();
		accountVector.list();
	}
	
	//Test Scenario 06: Check method list account with vector size equals one
	@Test
	public void testListarVectorContasPreenchido() throws AccountCreationException, AbstractAccountEmptyException{
		AccountVector accountVector = new AccountVector();
		OrdinaryAccount accountA = new OrdinaryAccount("1234");
		
		accountVector.create(accountA);
		
		assertEquals(1, accountVector.list().length);
	}
}


