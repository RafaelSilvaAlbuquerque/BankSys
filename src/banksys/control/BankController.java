package banksys.control;

import banksys.account.AbstractAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;
import banksys.control.exception.BankTransactionException;
import banksys.control.exception.IncompatibleAccountException;
import banksys.persistence.IAccountRepository;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;
import banksys.persistence.LogData;

public class BankController {

	private IAccountRepository repository;

	public BankController(IAccountRepository repository) {
		this.repository = repository;
	}

	public void addAccount(AbstractAccount account) throws BankTransactionException {
		try {
			this.repository.create(account);
			
			//String log = "Account "+account.getNumber()+" added";
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Account "+account.getNumber()+" added");
			
		} catch (AccountCreationException ace) {
			throw new BankTransactionException(ace);
		}
	}

	public void removeAccount(String number) throws BankTransactionException {
		try {
			this.repository.delete(number);
			
			//String log = "Account "+number+" removed";
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Account "+number+" removed");
			
		} catch (AccountDeletionException ade) {
			throw new BankTransactionException(ade);
		}
	}

	public void doCredit(String number, double amount) throws BankTransactionException {
		AbstractAccount account;
		try {
			account = this.repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		try {
			account.credit(amount);
			
			//String log = "Value "+amount+" credited in account "+number;
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Value "+amount+" credited in account "+number);
			
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
		
		//save repository in file
		this.repository.save();

	}

	public void doDebit(String number, double amount) throws BankTransactionException {
		AbstractAccount account;
		try {
			account = this.repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
		try {
			account.debit(amount);
			
			//String log = "Value "+amount+" debited from account "+number;
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Value "+amount+" debited from account "+number);
			
		} catch (InsufficientFundsException ife) {
			throw new BankTransactionException(ife);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
		
		//save repository in file
		this.repository.save();
	}

	public double getBalance(String number) throws BankTransactionException {
		AbstractAccount conta;
		try {
			conta = this.repository.retrieve(number);
			return conta.getBalance();
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}
	}

	public void doTransfer(String fromNumber, String toNumber, double amount) throws BankTransactionException {
		AbstractAccount fromAccount;
		try {
			fromAccount = this.repository.retrieve(fromNumber);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}

		AbstractAccount toAccount;
		try {
			toAccount = this.repository.retrieve(toNumber);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}

		try {
			fromAccount.debit(amount);
			toAccount.credit(amount);
			
			//String log = "Value "+amount+" transfered from account "+ fromNumber+ "to account "+ toNumber;
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Value "+amount+" transfered from account "+ fromNumber+ "to account "+ toNumber);
			
		} catch (InsufficientFundsException sie) {
			throw new BankTransactionException(sie);
		} catch (NegativeAmountException nae) {
			throw new BankTransactionException(nae);
		}
		
		//save repository in file
		this.repository.save();
	}

	public void doEarnInterest(String number) throws BankTransactionException, IncompatibleAccountException, NegativeAmountException {
		AbstractAccount auxAccount;
		try {
			auxAccount = this.repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}

		if (auxAccount instanceof SavingsAccount) {
			((SavingsAccount) auxAccount).earnInterest();
			
			//String log = "Account "+number+" have got interest";
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Account "+number+" have got interest");
			
		} else {
			throw new IncompatibleAccountException(number);
		}
		
		//save repository in file
		this.repository.save();
	}

	public void doEarnBonus(String number) throws BankTransactionException, IncompatibleAccountException {
		AbstractAccount auxAccount;
		try {
			auxAccount = this.repository.retrieve(number);
		} catch (AccountNotFoundException anfe) {
			throw new BankTransactionException(anfe);
		}

		if (auxAccount instanceof SpecialAccount) {
			((SpecialAccount) auxAccount).earnBonus();
			
			//String log = "Account "+number+" have got bonus";
			//LogData.record("log_operations.txt",log);
			
			this.logOperation("Account "+number+" have got bonus");
			
		} else {
			throw new IncompatibleAccountException(number);
		}
		
		//save repository in file
		this.repository.save();
	}
	
	public void logOperation(String log){
		LogData.record("log_operations.txt",log);
	}
}
