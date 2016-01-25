package banksys.account;

import java.io.Serializable;

import banksys.account.exception.InsufficientFundsException;
import banksys.account.exception.NegativeAmountException;
//class OrdinaryAccount 
public class OrdinaryAccount extends AbstractAccount implements Serializable {

	//method instantiation account 
	public OrdinaryAccount(String number) {
		super(number);
	}
	//method debit amount in account
	public void debit(double amount) throws NegativeAmountException, InsufficientFundsException {
		if (amount > 0) {
			if (this.balance >= amount) {
				this.balance = this.balance - amount;
			} else {
				throw new InsufficientFundsException(number, amount);
			}
		} else {
			throw new NegativeAmountException(amount);
		}
	}
}