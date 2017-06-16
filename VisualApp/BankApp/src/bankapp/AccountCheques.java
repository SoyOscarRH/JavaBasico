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
       	int HowMuchTemporal = HowMuch;

        if ((Balance - HowMuchTemporal) >= 0) Balance -= HowMuchTemporal;                       //If you have enough $
        else if ( (Balance+SobreGiro) >= HowMuchTemporal ) {
        	HowMuchTemporal -= Balance;
        	Balance = 0;
        	SobreGiro -= HowMuchTemporal;
        }
        else {
        	return false;
        }

        Map Info = new HashMap<>();
        String SobreGiroString = ("SobreGiro: $"+String.valueOf(SobreGiro/100)+"."+String.valueOf(ShowZeros(SobreGiro%100)));
        SobreGiroString += ("\n" + "Balance: " +"$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        Info.put("Concept", "TakeOutMoney");
        Info.put("Author", Source);
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", SobreGiroString);

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
        HowMuch *= 100;
       	int HowMuchTemporal = HowMuch;

    	if (Balance < 0){
            Balance += HowMuchTemporal;                                             //You send me $, I work in cents
    	}
    	else {
    		if (SobreGiro > HowMuchTemporal) SobreGiro-= HowMuchTemporal;
    		else{
    			HowMuchTemporal -= SobreGiro;
    			SobreGiro = 0;
    			Balance += HowMuchTemporal;
    		}
    	}


        Map Info = new HashMap<>();
        String SobreGiroString = ("SobreGiro: $"+String.valueOf(SobreGiro/100)+"."+String.valueOf(ShowZeros(SobreGiro%100)));
        SobreGiroString += ("\n" + "Balance: " +"$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100)));

        Info.put("Concept", "Add Money");
        Info.put("Author", Source);
        Info.put("HowMuch", "$"+String.valueOf(HowMuch/100)+"."+String.valueOf(ShowZeros(HowMuch%100)));
        Info.put("Balance", SobreGiroString);

        MovementData.add(new Movement(Info));
    }

    @Override
    public void PayMontlyInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PayYearlyInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}	