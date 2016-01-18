package banksys.interfaces;

import javax.swing.JOptionPane;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;

public class InterfaceDoTransfer {
	
	private BankController bank;
	
	public InterfaceDoTransfer (BankController bank){
		this.bank = bank;
	}
	
	public void show(){
		String originAccount = JOptionPane.showInputDialog("Enter the origin account number: ");
		
		if(originAccount != null){
			String destinationAccount = JOptionPane.showInputDialog("Enter the destination account number: ");
			
			if(destinationAccount != null){
				String amountString = JOptionPane.showInputDialog("Enter the amount to be transferred: ");
				
				if(amountString != null){
					double amount = Double.parseDouble(amountString);
					
					try {
						bank.doTransfer(originAccount, destinationAccount, amount);
						JOptionPane.showMessageDialog(null,"Operation was successful!");
					} catch (BankTransactionException bte) {
						JOptionPane.showMessageDialog(null,bte.getMessage());
					}
				}
			}
		}
	}
}
