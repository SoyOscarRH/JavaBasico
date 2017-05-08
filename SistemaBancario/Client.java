import java.util.*;

public class Client{
	private HashMap<String, BankAccount> Accounts;
	private String NameClient;

	Client(String NameClient){
		Accounts = new HashMap<String, BankAccount>();
		this.NameClient = NameClient;
	}

	void AddAccount(BankAccount NewAccount){
		Accounts.put(NewAccount.getID(), NewAccount);
	}

	BankAccount getAccount(String Key){
		return Accounts.get(Key);
	}

	public String toString(){
		String Result = new String();
		for (Map.Entry<String, BankAccount> entry : Accounts.entrySet()){
		    Result += (entry.getValue().toString() + "\n");
		}
		return Result;
	}

	public void ReportState(){
		System.out.println("== REPORT STATE ==\n");

		for (Map.Entry<String, BankAccount> entry : Accounts.entrySet()){
			System.out.println(entry.getValue());
		    entry.getValue().ShowMovements();
			System.out.println("\n");
		}
	}


}