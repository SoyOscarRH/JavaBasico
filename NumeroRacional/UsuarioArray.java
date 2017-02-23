import java.util.*;                                                                 		//Añade API en general

public class Usuario {
	public static void main(String[] args){
        int menu = 20;
        String temporalString;
        ArraydeRacionales listaX = new ArraydeRacionales();

        Scanner escanerDelTeclado = new Scanner(System.in);                             	//Aqui esta el scanner para la entrada
        System.out.println("\n\n===== PROGRAMA: CONTROL DE RACIONALES ========");      		//Mostramos Mensaje por Consola
        
        String mensaje = "\n\n\n\n\n================ MENU DE OPCIONES ==============\n";
        mensaje += "1)Crear Racional\n2)Muestra Numeros\n3)Operacion entre Racionales";
        mensaje += "\n4)Ejemplo de Comparacion\n5)El numero Mayor\n6)El numero Menor";
        mensaje += "\n7)Ordena el Conjunto de Numerosn\n8)Eliminar\n0)Salir\n\nDame tu accion: ";

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
            if (menu == 4) {listaX.comparaElementos(0,1);}
            if (menu == 5) {listaX.muestraMayor();}
            if (menu == 6) {listaX.muestraMenor();}
            if (menu == 7) {listaX.ordenaElementos();}
            if (menu == 8) {listaX.eliminar();}
        }

        while (menu != 0); 
    }
}