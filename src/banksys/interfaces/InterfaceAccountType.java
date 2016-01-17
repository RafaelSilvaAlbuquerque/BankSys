package banksys.interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;
import banksys.account.*;

public class InterfaceAccountType {
	
	private AbstractAccount account;
	private BankController bank;
	
	public InterfaceAccountType(BankController bank){
		this.account = null;
		this.bank = bank;
	}
	
	public void show(){
		
		JButton ordinary = new JButton("Ordinary");
		JButton special = new JButton("Special");
		JButton savings = new JButton("Savings");
		JButton tax = new JButton("Tax");
		

		JPanel painel = new JPanel(new GridLayout(0, 1));
		painel.add(ordinary);
		painel.add(special);
		painel.add(savings);
		painel.add(tax);
		
		ordinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String accountNumber = JOptionPane.showInputDialog("Enter the ordinary account number: ");
  				
  				if(accountNumber != null){
  					account = new OrdinaryAccount(accountNumber);
  	  				add(account);
  				}
  			}
		});
		
		special.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String accountNumber = JOptionPane.showInputDialog("Enter the special account number: ");
  				
  				if(accountNumber != null){
	  				account = new SpecialAccount(accountNumber);
	  				add(account);
  				}
  			}
		});
		
		savings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String accountNumber = JOptionPane.showInputDialog("Enter the saving account number: ");
  				
  				if(accountNumber != null){
	  				account = new SavingsAccount(accountNumber);
	  				add(account);
  				}
  			}
		});
		
		tax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  				String accountNumber = JOptionPane.showInputDialog("Enter the tax account number: ");
  				
  				if(accountNumber != null){
	  				account = new TaxAccount(accountNumber);
	  				add(account);
  				}
  			}
		});
		
		
		JFrame window = new JFrame("Argentum");
		window.add(painel);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		window.setSize(300,300);
	}
	
	public void add(AbstractAccount account){
		try {
			bank.addAccount(account);
			JOptionPane.showMessageDialog(null,"Operation was successful!");
		} catch (BankTransactionException bte) {
			JOptionPane.showMessageDialog(null,bte.getMessage());
		}
	}
}
