import java.util.*;

public class Banco{
	public static void main(String[] args) {
		java.util.Date FechaActual = new java.util.Date();
		System.out.println("Date: "+FechaActual);


		BankAccount C1 = new BankAccount(220);
		System.out.println(C1);

		C1.TakeOutMoney(10, "22/03/17", "Bank");
		C1.TakeOutMoney(15, "25/03/17");

		C1.ShowMovements();



	}


	
}