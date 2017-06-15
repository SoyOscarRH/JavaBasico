package bankapp;
import java.util.*;



// =======================================================
// ===============  		 CLIENT 	   ===============
// =======================================================
public class Client {
	private HashMap<String, BankAccount> Accounts;
	private String NameClient;

	// ****** 	CONSTRUCTORES ****************
		Client(String NameClient){
			Accounts = new HashMap<String, BankAccount>();
			this.NameClient = NameClient;
		}

	// ***** ADD ACCOUNT ********************
	void AddAccount(BankAccount NewAccount){
		Accounts.put(NewAccount.getID(), NewAccount);
	}

	// ***** GET ACCOUNT ********************
	BankAccount getAccount(String Key){
		return Accounts.get(Key);
	}

	// ***** SHOW ACCOUNT ********************
	public String toString(){
		String Result = new String();
		for (Map.Entry<String, BankAccount> entry : Accounts.entrySet()){
		    Result += (entry.getValue().toString() + "\n");
		}
		return Result;
	}

	// ***** SHOW REPORT ********************
	public void ReportState(){
		System.out.println("== REPORT STATE ==\n");

	}


}