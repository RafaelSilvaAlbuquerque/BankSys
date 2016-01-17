package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceDoDebit {
	
	private BankController bank;
	
	public InterfaceDoDebit (BankController bank){
		this.bank = bank;
	}
	
	public void show(){
		String accountNumber = JOptionPane.showInputDialog("Enter the account number: ");
		
		if(accountNumber != null){
			String amountString = JOptionPane.showInputDialog("Enter the amount to be debited: ");
			
			if(amountString != null){
				double amount = Double.parseDouble(amountString);
				
				try {
					bank.doDebit(accountNumber, amount);
					JOptionPane.showMessageDialog(null,"Operation was successful!");
				} catch (BankTransactionException bte) {
					JOptionPane.showMessageDialog(null,bte.getMessage());
				}
			}
		}		
	}
}
