package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceRemoveAccount {
	
private BankController bank;
	
	public InterfaceRemoveAccount (BankController banco){
		this.bank = banco;
	}
	
	public void show(){
		String accountNumber = JOptionPane.showInputDialog("Enter the account number: ");
		
		if(accountNumber != null){
			try {
				bank.removeAccount(accountNumber);
				JOptionPane.showMessageDialog(null,"Operation was successful!");
			} catch (BankTransactionException bte) {
				JOptionPane.showMessageDialog(null,bte.getMessage());
			}
		}
	}
}
