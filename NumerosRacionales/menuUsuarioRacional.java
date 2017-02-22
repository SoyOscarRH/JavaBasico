import java.util.ArrayList;                                                         //Añade API de Array List
import java.util.Scanner;                                                           //Añade API de Scanner

public class menuUsuarioRacional{                                                   //===== MENU USUARIO RACIONAL ===
    static Scanner escanerDelTeclado = new Scanner(System.in);                      //Creamos un Scanner
    static String tempString;
    static char operacion;                                                          //Variables de la CLase
    static int operandoA, operandoB,operandoC;
    static ArrayList<NumeroRacional> listaNumeros=new ArrayList<NumeroRacional>();  //Crea una lista de Numeros Racionales

    static public void muestraNumeros(){                                            //===== MOSTRAMOS TODOS LOS NUMEROS ==
        System.out.println("\n\n\n===================");                            //Muestro el menu
        for (int i=0; i<NumeroRacional.cantidadDeNumeros ;i++)                      //Recorre nuestro list
            listaNumeros.get(i).MuestraNumero();                                    //Agarra y saca de la lista
        System.out.println("=========================");                            //Salida de todo
    }
    static public boolean generaOperacion(){                                        //===== GENERAMOS UNA OPERACION  C=A*B ==
        System.out.println("\nDame tu Operacion en el estilo C=A+B");               //Pide tu operacion

        tempString = escanerDelTeclado.nextLine();                                  //Y da un scanner
        tempString = escanerDelTeclado.nextLine();                                  //Y da un scanner
        tempString = tempString.replaceAll("\\s","");                               //Quitemos espacios por si los puso
        System.out.println(tempString);
        if(tempString.length()!=5 && tempString.charAt(1)=='='){return false;}
        operandoA = Character.getNumericValue(tempString.charAt(2));
        operacion = tempString.charAt(3);
        operandoB = Character.getNumericValue(tempString.charAt(4));
        operandoC = Character.getNumericValue(tempString.charAt(0));
        return true;
    }

    public static void main(String[] args){                                         //Aqui esta el main
        int menu;                                                                   //Es la accion que vamos a hacer

        System.out.println("\n\n===== Programa Aritmetico Racional ===");           //Mostramos Mensaje por Consola
    
        do {                                                                        //==== MENU EN SI DEL USUARIO
            System.out.println("\n\n\n\n\n== Menu de Opciones ===");                //Crea
            System.out.println("1)Crear nuevo Numero\t2)Muestra Numeros");          //Crea o muestra Racionales
            System.out.println("3)Operacion entre Racionales");                     //Operaciones Basicas
            System.out.println("0)Salir");                                          //Salir
            System.out.println("\nDame tu accion: ");                               //Pide tu accion
            menu = escanerDelTeclado.nextInt();                                     //Y da un scanner 

            if (menu==1) {                                                          //MENU 1: CREA UN NUEVO ELEMENTO
                NumeroRacional temporal = new NumeroRacional();                     //Crea una nueva referencia
                listaNumeros.add(temporal);                                         //Lo añade a nuestro arraylist
            }

            if (menu == 2 || menu == 3) {muestraNumeros();}                         //MENU 2: MUESTRA ELEMENTOS
            
            if (menu==3) {                                                          //MENU 3: HACER OPERACIONES     
                while(generaOperacion()==false);

                NumeroRacional A = listaNumeros.get(operandoA);
                NumeroRacional B = listaNumeros.get(operandoB);
                NumeroRacional C = listaNumeros.get(operandoC);

                if(operacion == '+'){C.Suma(A,B); C.MuestraNumero();}
                if(operacion == '-'){C.Resta(A,B); C.MuestraNumero();}
                if(operacion == '*'){C.Multiplicacion(A,B); C.MuestraNumero();}
                if(operacion == '/'){C.Division(A,B); C.MuestraNumero();}

            }                             
        }
        while (menu != 0);                                                          //Mientras no quieras salir

        //Demostraciones de las Funciones 
        muestraNumeros();
        System.out.println("La suma de 0=0+(1+2)");
        listaNumeros.get(0).Suma(listaNumeros.get(1).Suma(listaNumeros.get(2)));
        muestraNumeros();
    }
}


//CREA LAS REFERNCIAS LOS OBEJTOS DESDE LA PARTE DE LOS STATICS...CREO