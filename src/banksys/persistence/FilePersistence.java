package banksys.persistence;

import banksys.account.AbstractAccount;
import banksys.persistence.exception.AccountCreationException;
import banksys.persistence.exception.AccountDeletionException;
import banksys.persistence.exception.AccountNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class FilePersistence implements IAccountRepository{

	private Vector<AbstractAccount> accounts = null;
	
	@SuppressWarnings("unchecked")
	public FilePersistence(){
		
		File arquivo = new File("contas.txt");
		this.accounts = new Vector<AbstractAccount>();
		
		if(!arquivo.exists()){
			this.serializeObj(this.accounts, "contas.txt");
		}
		else{
			this.accounts = (Vector<AbstractAccount>) this.loadObj("contas.txt");
		}
	}
	
	@Override
	public void create(AbstractAccount account) throws AccountCreationException {
		if (this.findAccount(account.getNumber()) == null || accounts.size() == 0) {
			this.accounts.addElement(account);
		} else {
			throw new AccountCreationException("OrdinaryAccount alredy exist!", account.getNumber());
		}
		
		//save object in file
		this.serializeObj(this.accounts, "contas.txt");
	}

	@Override
	public void delete(String number) throws AccountDeletionException {
		AbstractAccount account = this.findAccount(number);
		if (account != null) {
			this.accounts.remove(account);
		} else {
			throw new AccountDeletionException("OrdinaryAccount doesn't exist!", number);
		}
		
		//save object in file
		this.serializeObj(this.accounts, "contas.txt");
	}

	@Override
	public AbstractAccount retrieve(String number) throws AccountNotFoundException {
		AbstractAccount account = findAccount(number);
		if (account != null) {
			return account;
		} else {
			throw new AccountNotFoundException("OrdinaryAccount not found!", number);
		}
	}

	@Override
	public AbstractAccount[] list() {
		AbstractAccount[] list = null;
		if (this.accounts.size() > 0) {
			list = new AbstractAccount[this.accounts.size()];
			for (int i = 0; i < this.accounts.size(); i++) {
				list[i] = (AbstractAccount) this.accounts.elementAt(i);
			}
		}
		return list;
	}

	@Override
	public int mumberOfAccounts() {
		return this.accounts.size();
	}
	
	private AbstractAccount findAccount (String number) {

		if (!this.accounts.isEmpty()) {

			for (int i = 0; i < this.accounts.size(); i++) {
				AbstractAccount account = (AbstractAccount) this.accounts.elementAt(i);
	
				if (account.getNumber().equals(number)) {
					return account;
				}
			}
		}
		return null;
	}
	
	
	public void serializeObj(Object obj,String dir){
		
		try{
			FileOutputStream outFile = new FileOutputStream(dir);
			ObjectOutputStream outObj = new ObjectOutputStream(outFile);
			
			outObj.writeObject(obj);
			outObj.flush();
			outObj.close();
			
			outFile.flush();
			outFile.close();
		}
		catch(Exception e){
			e.printStackTrace( );
		}
	}
	
public Object loadObj(String dir){
		
		Object obj = null;
		
		try{
			FileInputStream inputFile = new FileInputStream(dir);
			ObjectInputStream inputObj = new ObjectInputStream(inputFile);
			
			obj = inputObj.readObject();
			
			inputObj.close();
			inputFile.close();
		}
		catch(Exception e){
			e.printStackTrace( );
		}
		
		return obj;
	}

	@Override
	public void save() {
		//save object in file
		this.serializeObj(this.accounts, "contas.txt");
	}
}
