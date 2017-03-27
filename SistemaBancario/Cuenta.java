import java.util.*;
import java.time.*;


public class Cuenta{
	//===== Abritutos de Clase ===
	private static int Serial = 0;
	private static char SerialLetra = 'A';
	private ArrayList<String> FechasMovimientos = new ArrayList<String>(); 

	//==== Genera Numero de Cuenta ==
	public static String GeneraNumCuenta(){
		Serial++;
		if (Serial > 999){
			SerialLetra++;
			Serial = 0;
		}
		String resultado = new String();
		resultado+= Character.toString(SerialLetra);
		resultado+= MuestraConCeros(Serial);
		return resultado;
	}

	// ====	Atributos ======
	private String NumCuenta;
	private int Saldo;

	//==== Constructores ===
	public Cuenta(int Saldo){
		Saldo*=100; 
		this.Saldo = Saldo;
		this.NumCuenta = GeneraNumCuenta();
	}

	
	//==== Retirar ===
	public boolean Retirar(int Retiro, String Fecha){
		Retiro *= 100;

		if((Saldo - Retiro) >= 0) Saldo-=Retiro;
		else return false;

		Fecha += (": Retiro $"+(Retiro/100)+"\tSaldo Actual: ");
		Fecha +=  ((Saldo/100)+"."+MuestraConCeros(Saldo%100)+"\n");
		FechasMovimientos.add(Fecha);
		return true;
	}

	//==== Abonar ===
	public void Abonar(int Abono, String Fecha){
		Saldo += (Abono*100);
	}

	//==== Muestra con Ceros ===
	public static String MuestraConCeros(int numero){
		String resultado = new String();
		if(numero < 10) resultado+="00";
		else if(numero < 100) resultado+="0";

		return resultado + Integer.toString(numero);
	}

	//==== Muestra con Movimientos ===
	public void MuestraMovimientos(){
		for(String Movimiento : FechasMovimientos)
			System.out.println(Movimiento);
	}


	//=== toString ====
	public String toString(){
		String resultado = new String();
		resultado += ("== NumCuenta: "+NumCuenta+" ==\n");
		resultado += (" Saldo: "+(Saldo/100)+"."+MuestraConCeros(Saldo%100));
		return resultado;
	}

}	