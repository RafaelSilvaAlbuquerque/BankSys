package banksys.persistence.test;

import static org.junit.Assert.*;

import org.junit.Test;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;
import banksys.persistence.AccountVector;
import banksys.persistence.exception.AccountCreationException;

public class AccountVectorTest {

	
	/*Cenario de Teste - Criando vetor de contas com sucesso
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
}

