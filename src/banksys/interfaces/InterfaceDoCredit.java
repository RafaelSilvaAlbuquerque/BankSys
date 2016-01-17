package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceDoCredit {
	
	private BankController bank;
	
	public InterfaceDoCredit(BankController bank){
		this.bank = bank;
	}
	
	public void show(){
		
		String accountNumber = JOptionPane.showInputDialog("Enter the account number: ");
		
		if(accountNumber != null){
			String amountString = JOptionPane.showInputDialog("Enter the amount to be credited: ");
					
			if(amountString != null){
				double amount = Double.parseDouble(amountString);
				
				try {
					bank.doCredit(accountNumber, amount);
					JOptionPane.showMessageDialog(null,"Operation was successful!");
				} catch (BankTransactionException bte) {
					JOptionPane.showMessageDialog(null,bte.getMessage());
				}
			}
		}	
	}
}
