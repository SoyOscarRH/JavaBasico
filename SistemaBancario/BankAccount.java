// ===================================================================================
// =============================	SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

import java.util.*;																//Library
import java.time.*;																//Library


public class BankAccount { 

	//============================================================
	// ==== STATIC CLASS ATRIBUTES AND METHODS: SERIAL NUMBER ====
	//============================================================
	
	private static short Serial = 0;											//Keep control of NumberClient
	private static char SerialChar = 'A';										//Keep control of NumberClient

	// ======= CREATE ACCOUNT NUMBER ============
	public static String GenerateBankAccountNumber(){		
		Serial++;																//Give me serial number
		if (Serial > 9) {SerialChar++; Serial = 0;}								//Reset the Serial number
		return (Character.toString(SerialChar) + ShowZeros(Serial));			//Return the String
	}

	// ====== SHOW STRING WITH ZEROS ============
	public static String ShowZeros(int number){
		String numberAsString = new String();									//Store result
		if (number < 10) numberAsString += "00";								//Add 	
		else if (number < 100) numberAsString += "0";							//Add
		return numberAsString + Integer.toString(number);						//Return the necessary
	}


	//===========================================================
	//============= 	ATRIBUTES AND CONSTRUCTORS 	 ============
	//===========================================================

	// ====== ATRIBUTES OF AN OBJECT ============ 
	private String BankAccountNumber;											//Special Number
	private int Balance;														//Balance
	private ArrayList<String> MovementDate; 									//Dates of movement

	// ====== CONSTRUCTORS  =====================
	public BankAccount(){this(0);}												//Create an BankAccount with $0

	public BankAccount(int Balance){
		this.Balance = (Balance * 100);											//Yous send me $ y store cents
		this.BankAccountNumber = GenerateBankAccountNumber();					//Lets generate an account number
		MovementDate = new ArrayList<String>();									//An start storing in the array
	}

	// ====== GETTER / SETTER ===================
	public int getBalance(){return (Balance/100);}								//

	// ===========================
	// ===== TAKE OUT MY MONEY ===
	// ===========================
	public boolean TakeOutMoney(int HowMuch, String Date){						
		return TakeOutMoney(HowMuch, Date, "Unknow Source");					//if you dont tell me who do it!
	}
	public boolean TakeOutMoney(int HowMuch, String Date, String Comment){
		HowMuch *= 100;															//You send me $, I work in cents

		if ((Balance - HowMuch) >= 0) Balance -= HowMuch;						//If you have enough $
		else return false;														//Else you cant do it!

		Date += (": Retiro $"+(HowMuch/100)+"\tBalance Actual: ");				//Here I will have the string	
		Date += ((Balance/100)+"."+ShowZeros(Balance%100)+"\t\t"+Comment);		//And here
		MovementDate.add(Date);													//Add to the list
		return true;															//You make it!
	}

	// =============================
	// ===== 	ADD TO ACCOUNT	 ===
	// =============================
	public void AddToBankAccount(int HowMuch, String Date){						
		AddToBankAccount(HowMuch, Date, "Unknow Source");						//if you dont tell me who do it!
	}
	public void AddToBankAccount(int HowMuch, String Date, String Comment){
		Balance += (HowMuch * 100);												//You send me $, I work in cents
		Date += (": Add $"+(HowMuch/100)+"\tBalance Actual: ");					//Here I will have the string	
		Date += ((Balance/100)+"."+ShowZeros(Balance%100)+"\t\t"+Comment);		//And here
		MovementDate.add(Date);													//Add to the list
	}


	// =============================
	// ===== 	SHOW THINGS 	 ===
	// =============================
	public void ShowMovements(){
		for (String Movimiento : MovementDate) System.out.println(Movimiento);	//Show all the Movements
	}

	public String toString(){
		String resultado = new String();										//Just to show
		resultado += ("== BankAccountNumber: "+BankAccountNumber+" ==\n");		//Show
		resultado += (" Balance: "+(Balance/100)+"."+ShowZeros(Balance%100));	//Show
		return resultado;														//Go away!
	}

}	