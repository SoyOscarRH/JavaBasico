import java.util.*;

public class Banco{
	public static void main(String[] args) {
		java.util.Date FechaActual = new java.util.Date();
		System.out.println("Date: "+FechaActual);


		BankAccount C1 = new BankAccount(100, "23/03/17");
		System.out.println(C1);

		C1.TakeOutMoney(10, "22/03/17", "Bank");
		C1.TakeOutMoney(15, "25/03/17");
		C1.AddToBankAccount(15, "27/03/17", "Me :D");

		C1.ShowMovements();


	}


	
}