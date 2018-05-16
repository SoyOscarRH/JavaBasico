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
    private int MaxDeficit;

	// ====== CONSTRUCTORS  =====================
	public AccountCredit(int Balance, Date ApertureDate, double Rate, int MaxDeficit){
		super(Balance, ApertureDate);											//Call daddy
		this.InterestRate = Rate;												//Interests
		this.Type = "Credito";
		this.Deficit = 0;
        this.MaxDeficit = (MaxDeficit*100);
	}


	public void PayMontlyInterest(){

        int HowMuch = 0;
        
        if (Balance < 0){
            HowMuch = (int)(Balance*InterestRate);
            Balance -= (HowMuch);                                                   //You send me $, I work in cents

            if (Balance < 0){
                Deficit = Balance *-1;
                Balance = 0;
            }
        }
        else{
            HowMuch = (int)(Deficit*InterestRate);
            Deficit += HowMuch;
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

        @Override
    public void AddToBankAccount(int HowMuch, String Date){         
        AddToBankAccount(HowMuch, Date, "Unknow Source");                       //if you dont tell me who do it!
    }

        @Override
    public void AddToBankAccount(int HowMuch, String StrDate, String Source){
        HowMuch *= 100;
        
        if (Deficit > 0){
            Deficit -= HowMuch;

            if (Deficit < 0){
                Balance = Deficit * -1;
                Deficit = 0;
            }
        }
        else Balance += (HowMuch);                                             //You send me $, I work in cents


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





    // ===========================
    // ===== TAKE OUT MY MONEY ===
    // ===========================
    public boolean TakeOutMoney(int HowMuch, String Date){                      
        return TakeOutMoney(HowMuch, Date, "Unknow Source");                    //If you dont tell me who do it!
    }

    public boolean TakeOutMoney(int HowMuch, String StrDate, String Source){
        HowMuch *= 100;                                                         //You send me $, I work in cents
        int HowMuchTemporal = HowMuch;

        if ((Balance - HowMuchTemporal) >= 0) Balance -= HowMuchTemporal;                       //If you have enough $
        else if ( (Balance+MaxDeficit) >= HowMuchTemporal ) {
            HowMuchTemporal -= Balance;
            Balance = 0;
            Deficit = HowMuchTemporal;
        }
        else {
            return false;
        }

        Map Info = new HashMap<>();
        String SobreGiroString = ("Deficit: $"+String.valueOf(Deficit/100)+"."+String.valueOf(ShowZeros(Deficit%100)));
        SobreGiroString += ("\n" + "Balance: " +"$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        Info.put("Concept", "TakeOutMoney");
        Info.put("Author", Source);
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", SobreGiroString);

        MovementData.add(new Movement(Info));
        return true;                                                            //You make it!
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