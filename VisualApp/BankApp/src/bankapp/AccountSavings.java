// ===================================================================================
// =============================	SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

package bankapp;
import java.util.*;																//Library
import java.time.*;																//Library

public class AccountSavings extends BankAccount implements Taxes{ 

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

	public AccountSavings(double Rate){this(0, new Date(Date.Now()), Rate);}	//Create an BankAccount with $0


	public void PayMontlyInterest(){
		int HowMuch = (int)(Balance*InterestRate);
		Balance += (HowMuch);													//You send me $, I work in cents

        Map Info = new HashMap<>();
		Info.put("Concept", "Add Money (Interest - Montly)");
        Info.put("Author", "Bank");
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", "$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        MovementData.add(new Movement(Info));
	}

	public void PayYearlyInterest(){
		int HowMuch = (int)(Balance*InterestRate*12);
		Balance += (HowMuch);													//You send me $, I work in cents

        Map Info = new HashMap<>();
		Info.put("Concept", "Add Money (Interest - Yearly)");
        Info.put("Author", "Bank");
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", "$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        MovementData.add(new Movement(Info));
	}

}	