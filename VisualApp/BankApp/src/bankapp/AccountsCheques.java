// ===================================================================================
// =============================	SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

package bankapp;
import java.io.Serializable;
import java.util.*;																//Library
import java.time.*;																//Library

public class AccountCheques extends BankAccount implements Serializable{ 

	// ====== ATRIBUTES OF AN OBJECT ============ 
	private int SobreGiro;

	// ====== CONSTRUCTORS  =====================
	public AccountCheques(int Balance, Date ApertureDate, int SobreGiro){
		super(Balance, ApertureDate);											//Call daddy
		this.InterestRate = Rate;												//Interests
		this.Type = "Cheques";
		this.SobreGiro = SobreGiro*100;
	}



    // ===========================
    // ===== TAKE OUT MY MONEY ===
    // ===========================
    public boolean TakeOutMoney(int HowMuch, String Date){                      
        return TakeOutMoney(HowMuch, Date, "Unknow Source");                    //If you dont tell me who do it!
    }

    public boolean TakeOutMoney(int HowMuch, String StrDate, String Source){
        HowMuch *= 100;                                                         //You send me $, I work in cents


        if ((Balance - HowMuch) >= 0) Balance -= HowMuch;                       //If you have enough $
        else if ( (Balance+SobreGiro) >= HowMuch ) {
        	HowMuch -= Balance;
        	Balance = 0;
        	SobreGiro -= HowMuch;
        }
        else {}

        Map Info = new HashMap<>();
        Info.put("Concept", "TakeOutMoney");
        Info.put("Author", Source);
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", "$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        MovementData.add(new Movement(Info));
        return true;                                                            //You make it!
    }



    // =============================
    // =====    ADD TO ACCOUNT   ===
    // =============================

    public void AddToBankAccount(int HowMuch, String Date){         
        AddToBankAccount(HowMuch, Date, "Unknow Source");                       //if you dont tell me who do it!
    }

    public void AddToBankAccount(int HowMuch, String StrDate, String Source){
        Balance += (HowMuch * 100);                                             //You send me $, I work in cents
        HowMuch *= 100;

        Map Info = new HashMap<>();
        Info.put("Concept", "Add Money");
        Info.put("Author", Source);
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", "$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        MovementData.add(new Movement(Info));
    }


}	