package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceShowBalance {
	
	private BankController bank;
	
	public InterfaceShowBalance (BankController bank){
		this.bank = bank;
	}
	
	public void show(){
		String accountNumber = JOptionPane.showInputDialog("Enter the account number:");
		
		if(accountNumber != null){
			try {
				JOptionPane.showMessageDialog(null,"Balance: " + bank.getBalance(accountNumber));
			} catch (BankTransactionException bte) {
				JOptionPane.showMessageDialog(null,bte.getMessage());
			}
		}		
	}
}
