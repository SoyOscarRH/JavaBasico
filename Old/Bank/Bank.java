import java.util.*;

public class Bank{
    public static void main(String[] args) {

        Client SomeGuy = new Client("SomeGuy");                                     

        BankAccount C1 = new AccountSavings(100, "23/03/17", 0.1);
        BankAccount C2 = new AccountSavings(100, "20/03/17", 0.2);
        
        SomeGuy.AddAccount(C1);
        SomeGuy.AddAccount(C2);
        System.out.println(SomeGuy);

        BankAccount SomeGuySavings = SomeGuy.getAccount(C1.getID());

        SomeGuySavings.TakeOutMoney(10, "22/03/17", "Bank");
        SomeGuySavings.TakeOutMoney(15, "25/03/17");
        SomeGuySavings.AddToBankAccount(15, "30/03/17", "Me :D");
        SomeGuySavings.PayYearlyInterest();

        C2.TakeOutMoney(10, "22/03/17", "Bank");
        C2.TakeOutMoney(15, "25/03/17");

        SomeGuy.ReportState();
    }
}