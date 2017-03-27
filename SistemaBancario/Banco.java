import java.util.*;

public class Banco{
	public static void main(String[] args) {
		java.util.Date FechaActual = new java.util.Date();
		System.out.println("Fecha: "+FechaActual);


		Cuenta C1 = new Cuenta(220);
		System.out.println(C1);

		C1.Retirar(10, "22/03/17");
		C1.Retirar(15, "25/03/17");

		C1.MuestraMovimientos();



	}

	private ArrayList<ClienteBanco> ClienteDelBanco;


	public boolean DepositaEnCuenta(String NumCuenta, int Dinero){
		for (ClienteBanco i: ClienteDelBanco) {
			ArrayList<Cuenta> temporal = ClienteDelBanco.CuentasDelCliente;
			for (Cuenta j: temporal) {
				NumCuenta.equals(j.getNumCuenta());
			}

		}
	}
	
}