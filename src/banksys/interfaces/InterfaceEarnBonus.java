package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceEarnBonus {
	
	private BankController bank;
	
	public InterfaceEarnBonus(BankController bank){
		this.bank = bank;
	}
	
	public void show(){
		String accountNumber = JOptionPane.showInputDialog("Enter the account number: ");
		
		if(accountNumber != null){
			try {
				bank.doEarnBonus(accountNumber);
				JOptionPane.showMessageDialog(null,"Operation was successful!");
			} catch (BankTransactionException bte) {
				JOptionPane.showMessageDialog(null,bte.getMessage());
			}
		}
	}
}
