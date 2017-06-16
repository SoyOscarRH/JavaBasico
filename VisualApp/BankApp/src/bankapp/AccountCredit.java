// ===================================================================================
// =============================	SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

package bankapp;
import java.io.Serializable;
import java.util.*;																//Library

public class AccountCredit extends BankAccount implements Taxes, Serializable{ 

	// ====== ATRIBUTES OF AN OBJECT ============ 
	private double InterestRate;
	private int Deficit;

	// ====== CONSTRUCTORS  =====================
	public AccountCredit(int Balance, Date ApertureDate, double Rate){
		super(Balance, ApertureDate);											//Call daddy
		this.InterestRate = Rate;												//Interests
		this.Type = "Credito";
		this.Deficit = 0;
	}

	public AccountCredit(Date ApertureDate, double Rate){							
		this(0, ApertureDate, Rate);											//Create an BankAccount with $0
	}				

	public AccountCredit(double Rate){this(0, new Date(Date.Now()), Rate);}	//Create an BankAccount with $0


	public void PayMontlyInterest(){
		int HowMuch = (int)(Balance*InterestRate);
		Balance -= (HowMuch);													//You send me $, I work in cents

		if (Balance < 0){
			Deficit = Balance *-1;
			Balance = 0;
		}

		String CreditBalance = ("Deficit: $"+String.valueOf(Deficit/100)+"."+String.valueOf(ShowZeros(Deficit%100)));
        CreditBalance += ("\n" + "Ratio de Interes: " +"%"+String.valueOf(InterestRate*100));
        CreditBalance += ("\n" + "Balance: " +"$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        Map Info = new HashMap<>();
		Info.put("Concept", "Pay Money (Interest - Montly)");
        Info.put("Author", "Bank");
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", CreditBalance);

        MovementData.add(new Movement(Info));
	}

	// =============================
    // =====    ADD TO ACCOUNT   ===
    // =============================

    public void AddToBankAccount(int HowMuch, String Date){         
        AddToBankAccount(HowMuch, Date, "Unknow Source");                       //if you dont tell me who do it!
    }

    public void AddToBankAccount(int HowMuch, String StrDate, String Source){
        HowMuch *= 100;
		int HowMuchTemporal = HowMuch;

		if (Balance < 0){
			Deficit -= HowMuch;
			if (Deficit < 0){
				Balance = Deficit*-1;
				Deficit = 0;
			}
		}  
		else  Balance += (HowMuch);                                             //You send me $, I work in cents

        Map Info = new HashMap<>();

        String CreditBalance = ("Deficit: $"+String.valueOf(Deficit/100)+"."+String.valueOf(ShowZeros(Deficit%100)));
        CreditBalance += ("\n" + "Ratio de Interes: " +"%"+String.valueOf(InterestRate*100));
        CreditBalance += ("\n" + "Balance: " +"$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        Info.put("Concept", "Add Money");
        Info.put("Author", Source);
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", CreditBalance);

        MovementData.add(new Movement(Info));
    }

    @Override
    public void PayYearlyInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public String toString(){
        String Data = "Account: ";
        Data += " ID: " + BankAccountNumber;
        Data += " Date: " + ApertureDate.toString();
        Data += " Balance: " + "$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100));
        Data += " Deficit: " + "$"+String.valueOf(Deficit/100)+"."+String.valueOf(ShowZeros(Deficit%100));
        Data += " Ratio: " + "Ratio de Interes: " +"%"+String.valueOf(InterestRate*100);

        return Data;
    }


}	