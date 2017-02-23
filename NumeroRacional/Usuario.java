import java.util.*;                                                                 		//Añade API en general

public class Usuario {
	public static void main(String[] args){
        int menu = 20;
        String temporalString;
        ListaDeRacionales listaX = new ListaDeRacionales();

        Scanner escanerDelTeclado = new Scanner(System.in);                             	//Aqui esta el scanner para la entrada
        System.out.println("\n\n===== PROGRAMA: CONTROL DE RACIONALES ========");      		//Mostramos Mensaje por Consola
        
        String mensaje = "\n\n\n\n\n================ MENU DE OPCIONES ==============\n";
        mensaje += "1)Crear Racional\n2)Muestra Numeros\n3)Operacion entre Racionales";
        mensaje += "\n4)Ordena el Conjunto de Numeros\n0)Salir\n\nDame tu accion: ";

        do {                               
            System.out.print(mensaje);														//==== MENU EN SI DEL USUARIO
            temporalString = escanerDelTeclado.nextLine();									//Generamos un String pequeño
            if (Racional.EsUnNumero(temporalString)) {                      				//Si lo que tenemos solo son enteros
                menu = Integer.parseInt(temporalString);            						//Vamos a guardarlo como entero
            }
            else{menu=10;}                                                    				//Sino mandemos un 1

            if (menu == 1) {
            	Racional temporal = new Racional();                     					//Crea una nueva referencia
            	listaX.inserta(temporal);
            }
            if (menu == 2) {listaX.muestraElementos();}
            if (menu == 3) {listaX.generaOperacion();}
            if (menu == 4) {listaX.ordenaElementos();}

        }

        while (menu != 0); 
    }
}