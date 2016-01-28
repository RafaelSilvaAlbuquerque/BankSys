package banksys.interfaces;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import banksys.account.exception.NegativeAmountException;
import banksys.control.BankController;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceMainMenu {

private BankController bank;
	
	public InterfaceMainMenu(BankController bank){
		this.bank = bank;
	}
	
	public void show(){
		
		JButton newAccount = new JButton("New OrdinaryAccount");
		JButton doCredit = new JButton("Do Credit");
		JButton doDebit = new JButton("Do Debit");
		JButton doTransfer = new JButton("Do Transfer");
		JButton showBalance = new JButton("Show Balance");
		JButton removeAccount = new JButton("Remove Account");
		JButton earnInterest = new JButton("Earn Iterest");
		JButton earnBonus = new JButton("Earn Bonus");
		JButton exit = new JButton("Exit");

		JPanel painel = new JPanel(new GridLayout(0, 1));
		painel.add(newAccount);
		painel.add(doCredit);
		painel.add(doDebit);
		painel.add(doTransfer);
		painel.add(showBalance);
		painel.add(removeAccount);
		painel.add(earnInterest);
		painel.add(earnBonus);
		painel.add(exit);
		
		
		newAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceAccountType typeAccount = new InterfaceAccountType(bank);
  				typeAccount.show();
  			}
		});
		
		doCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceDoCredit interfaceCredit = new InterfaceDoCredit(bank);
  				interfaceCredit.show();
  			}
		});
		
		doDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceDoDebit iterfaceDebit = new InterfaceDoDebit(bank);
				iterfaceDebit.show();
  			}
		});
		
		doTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceDoTransfer interfaceTransfer = new InterfaceDoTransfer(bank);
  				interfaceTransfer.show();
  			}
		});
		
		showBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceShowBalance interfaceBalance = new InterfaceShowBalance(bank);
  				interfaceBalance.show();
  			}
		});
		
		removeAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceRemoveAccount interfaceRemove = new InterfaceRemoveAccount(bank);
  				interfaceRemove.show();
  			}
		});
		
		earnInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceEarnInterest interfaceInterest = new InterfaceEarnInterest(bank);
  				try {
					interfaceInterest.show();
				} catch (NegativeAmountException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  			}
		});
		
		earnBonus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				InterfaceEarnBonus interfaceBonus = new InterfaceEarnBonus(bank);
  				interfaceBonus.show();
  			}
		});
		
		exit.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				//JOptionPane.showMessageDialog(null,"Goodbye and have a nice day!!!");
    			System.exit(0);
  			}
		});
		
		
		JFrame window = new JFrame("Argentum");
		window.add(painel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		window.setSize(300,300);
	}
}


