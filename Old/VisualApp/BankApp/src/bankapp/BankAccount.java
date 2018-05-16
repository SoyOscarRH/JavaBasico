package bankapp;

// ===================================================================================
// =============================    SUPER CLASS: ACCOUNT  ============================
// ===================================================================================

import java.io.Serializable;
import java.util.*;                                                             //Library
import java.time.*;                                                             //Library

public abstract class BankAccount implements Serializable{ 

    //============================================================
    // ==== STATIC CLASS ATRIBUTES AND METHODS: SERIAL NUMBER ====
    //============================================================

        private static short Serial = 0;                                            //Keep control of NumberClient
        private static char SerialChar = 'A';                                       //Keep control of NumberClient

        // ======= CREATE ACCOUNT NUMBER ============
        protected static String GenerateBankAccountNumber(){        
            Serial++;                                                               //Give me serial number
            if (Serial > 9) {SerialChar++; Serial = 0;}                             //Reset the Serial number
            return (Character.toString(SerialChar) + ShowZeros(Serial));            //Return the String

        }


        // ====== SHOW STRING WITH ZEROS ============
        protected static String ShowZeros(int number){
            String numberAsString = new String();                                   //Store result
            if (number < 10 && number > 0) numberAsString += "00";                  //Add   
            else if (number < 100) numberAsString += "0";                           //Add
            return numberAsString + Integer.toString(number);                       //Return the necessary
        }


    //===========================================================
    //=============     ATRIBUTES AND CONSTRUCTORS   ============
    //===========================================================

        // ====== ATRIBUTES OF AN OBJECT ============ 
        protected String BankAccountNumber;                                         //Special Number
        protected int Balance;                                                      //Balance
        protected Date ApertureDate;                                                //Aperture day
        protected ArrayList<Movement> MovementData;                                 //Info on change
        public String Type;                                                         //Info on change

        // ====== CONSTRUCTORS  =====================
        public BankAccount(int Balance, Date ApertureDate){
            this.Balance = (Balance * 100);                                         //You send me $ y store cents
            this.BankAccountNumber = GenerateBankAccountNumber();                   //Lets generate an account number
            this.ApertureDate = ApertureDate;                                       //Lets generate an Aperture
            this.MovementData = new ArrayList<Movement>();                          //Declare it empty
        }

        public BankAccount(int Balance, String ApertureDate){                       //Create an BankAccount with $$
            this(Balance, new Date(ApertureDate));                                  //Call daddy
        }

        public BankAccount(Date ApertureDate){this(0, ApertureDate);}               //Create an BankAccount with $0
        public BankAccount(String ApertureDate){this(0, new Date(ApertureDate));}   //Create an BankAccount with $0
        public BankAccount(){this(0, new Date(1,1,70));}                            //Create an BankAccount with $0


        // ====== GETTER / SETTER ===================
        public int getBalance(){return (Balance/100);}  
        public String getID(){return BankAccountNumber;}                                


        // =============================
        // =====    TO MY SONS       ===
        // =============================
        public abstract void PayMontlyInterest();
        public abstract void PayYearlyInterest();






    // ===========================
    // ===== TAKE OUT MY MONEY ===
    // ===========================
    public boolean TakeOutMoney(int HowMuch, String Date){                      
        return TakeOutMoney(HowMuch, Date, "Unknow Source");                    //If you dont tell me who do it!
    }

    public boolean TakeOutMoney(int HowMuch, String StrDate, String Source){
        HowMuch *= 100;                                                         //You send me $, I work in cents
        if ((Balance - HowMuch) >= 0) Balance -= HowMuch;                       //If you have enough $
        else return false;                                                      //Else you cant do it!

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


    // =============================
    // =====    TO STRING     ======
    // =============================

    public String toString(){
        String Data = "Account: ";
        Data += " ID: " + BankAccountNumber;
        Data += " Date: " + ApertureDate.toString();
        Data += " Balance: " + "$"+String.valueOf(Balance/100)+"."+String.valueOf(ShowZeros(Balance%100));

        return Data;
    }

    public String getType(){return Type;}


    public ArrayList<Movement> getMovements(){
        return MovementData;
    }
}   