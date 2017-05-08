// ===================================================================================
// =============================	SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

import java.util.*;																//Library
import java.time.*;																//Library


public class AccountSavings extends BankAccount{ 

	// ====== ATRIBUTES OF AN OBJECT ============ 
	private double InterestRate;

	// ====== CONSTRUCTORS  =====================
	public AccountSavings(int Balance, Date ApertureDate, double Rate){
		super(Balance, ApertureDate);											//Call daddy
		this.InterestRate = Rate;												//Interests
	}
	public AccountSavings(int Balance, String ApertureDate, double Rate){		//Create an BankAccount with $$
		this(Balance, new Date(ApertureDate), Rate);							//Call daddy
	}
	public AccountSavings(Date ApertureDate, double Rate){							
		this(0, ApertureDate, Rate);											//Create an BankAccount with $0
	}				
	public AccountSavings(String ApertureDate, double Rate){
		this(0, new Date(ApertureDate), Rate);									//Create an BankAccount with $0
	}
	public AccountSavings(double Rate){this(0, new Date(1,1,70), Rate);}		//Create an BankAccount with $0


	public void PayMontlyInterest(){
		int HowMuch = (int)(Balance*InterestRate);
		Balance += (HowMuch);													//You send me $, I work in cents
		String Info = ("Add Money $"+(HowMuch/100)+"\tBalance: ");				//Here I will have the string
		Info += ((Balance/100)+"."+ShowZeros(Balance%100));						//And here
		Info += ("\t\t"+"Montly Interest");										//And here

		MovementDate.add(new Date(Date.Now()));									//Add to the list
		MovementInfo.add(Info);													//Add to the list
	}

	public void PayYearlyInterest(){
		int HowMuch = (int)(Balance*InterestRate*12);
		Balance += (HowMuch);													//You send me $, I work in cents
		String Info = ("Add Money $"+(HowMuch/100)+"\tBalance: ");				//Here I will have the string
		Info += ((Balance/100)+"."+ShowZeros(Balance%100));						//And here
		Info += ("\t\t"+"Yearly Interest");										//And here

		MovementDate.add(new Date(Date.Now()));									//Add to the list
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