package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.account.exception.NegativeAmountException;
import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceEarnInterest {
	
	private BankController bank;
	
	public InterfaceEarnInterest(BankController banco){
		this.bank = banco;
	}
	
	public void show() throws NegativeAmountException{
		String accountNumber = JOptionPane.showInputDialog("Enter the account number: ");
		
		if(accountNumber != null){
			try {
				bank.doEarnInterest(accountNumber);
				JOptionPane.showMessageDialog(null,"Operation was successful!");
			} catch (BankTransactionException bte) {
				JOptionPane.showMessageDialog(null,bte.getMessage());
			}
		}
	}
}
