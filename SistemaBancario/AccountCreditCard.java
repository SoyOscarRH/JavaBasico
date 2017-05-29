// ===================================================================================
// =============================	SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

import java.util.*;																//Library
import java.time.*;																//Library


public class AccountCreditCard extends BankAccount{ 

	// ====== ATRIBUTES OF AN OBJECT ============ 
	private double CreditRate;
	private double Deficit;

	// ====== CONSTRUCTORS  =====================
	public AccountCreditCard(int Balance, Date ApertureDate, double CreditRate){
		super(Balance, ApertureDate);											//Call daddy
		this.CreditRate = CreditRate;											//Interests
		this.Deficit = 0;														//Interests
	}
	public AccountCreditCard(int Balance,String ApertureDate,double CreditRate){//Create an BankAccount with $$
		this(Balance, new Date(ApertureDate), CreditRate);						//Call daddy
	}
	public AccountCreditCard(Date ApertureDate, double CreditRate){							
		this(0, ApertureDate, CreditRate);										//Create an BankAccount with $0
	}				
	public AccountCreditCard(String ApertureDate, double CreditRate){
		this(0, new Date(ApertureDate), CreditRate);							//Create an BankAccount with $0
	}
	public AccountCreditCard(double CreditRate){								//Create an BankAccount with $0
		this(0, new Date(Date.Now()), CreditRate);
	}		

	// ===========================
	// ===== TAKE OUT MY MONEY ===
	// ===========================
	public boolean TakeOutMoney(int HowMuch, String Date){						
		return TakeOutMoney(HowMuch, Date, "Unknow Source");					//If you dont tell me who do it!
	}
	public boolean TakeOutMoney(int HowMuch, String StrDate, String Source){
		HowMuch *= 100;															//You send me $, I work in cents

		if ((Balance - HowMuch) > 0) {
			Deficit = HowMuch - Balance;
			Balance = 0;
		}
		else Balance -= HowMuch;												//If you have enough $

		String Info = ("Cash Out $"+(HowMuch/100)+"\tBalance: ");				//Here I will have the string	
		Info += ((Balance/100)+"."+ShowZeros(Balance%100)+"\t\t"+Source);		//And here
		Info += ("\t\tDeficit: "(Balance/100)+"."+ShowZeros(Balance%100)+"\t\t"+Source);		//And here

		MovementDate.add(new Date(StrDate));									//Add to the list
		MovementInfo.add(Info);													//Add to the list
		return true;															//You make it!
	}

	// =============================
	// ===== 	ADD TO ACCOUNT	 ===
	// =============================
	public void AddToBankAccount(int HowMuch, String Date){			
		AddToBankAccount(HowMuch, Date, "Unknow Source");						//if you dont tell me who do it!
	}
	public void AddToBankAccount(int HowMuch, String StrDate, String Source){
		HowMuch *= 100;															//You send me $, I work in cents

		if (Deficit > 0){
			if (Deficit >= HowMuch) Deficit =- HowMuch;
			else {
				Deficit = 0;
				Balance = HowMuch-Deficit;
			}
		}
		else Balance += HowMuch;												//You send me $, I work in cents
		String Info = ("Add Money $"+(HowMuch)+"\tBalance: ");					//Here I will have the string
		Info += ((Balance/100)+"."+ShowZeros(Balance%100)+"\t\t"+Source);		//And here

		MovementDate.add(new Date(StrDate));									//Add to the list
		MovementInfo.add(Info);													//Add to the list
	}



	// =============================
	// ===== 	SHOW THINGS 	 ===
	// =============================
	public String toString(){
		String resultado = new String();										//Just to show
		resultado += ("Savings Account: "+BankAccountNumber+"\t");				//Show
		resultado += ("Balance: $"+(Balance/100)+"."+ShowZeros(Balance%100));	//Show
		resultado += ("\tRate: $"+InterestRate*100 +"%");						//Show
		return resultado;														//Go away!
	}
}	