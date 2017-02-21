import java.util.ArrayList;                                                         //Añade API de Array List
import java.util.Scanner;                                                           //Añade API de Scanner

public class menuUsuarioRacional{                                                   //===== MENU USUARIO RACIONAL ===
    public static void main(String[] args){                                         //Aqui esta el main
        int menu;                                                                   //Es la accion que vamos a hacer
        int numeroActual = -1;                                                      //Este numero "apunta" al num. actual
        Scanner escanerDelTeclado = new Scanner(System.in);                         //Creamos un Scanner
        System.out.println("\n\n===== Programa Aritmetico Racional ===");           //Mostramos Mensaje por Consola
        ArrayList<NumeroRacional> listaNumeros = new ArrayList<NumeroRacional>();   //Crea una lista de Numeros Racionales
    
        do {                                                                        //==== MENU EN SI DEL USUARIO
            System.out.println("\n== Menu de Opciones ===");                        //Crea
            System.out.println("1)Crear nuevo Numero\t2)Muestra Numeros");          //Crea o muestra Racionales
            System.out.println("3)Suma\t4)Resta\t5)Multiplicacion\t6)Division");    //Operaciones Basicas
            System.out.println("\nDame tu accion: ");                               //Pide tu accion
            menu = escanerDelTeclado.nextInt();                                     //Y da un scanner 

            if (menu==1){
                numeroActual++;
                NumeroRacional temporal = new NumeroRacional(numeroActual);
                listaNumeros.add(temporal);
            }
            else if(menu==2){
                for (int i=0; i<=numeroActual ;i++) {
                    NumeroRacional temporal = listaNumeros.get(i);
                    temporal.MuestraNumero();
                }
            }
            else if(menu==3){

            }
        }
        while (menu != 0);                                                          //Mientras no quieras salir
    }
}
