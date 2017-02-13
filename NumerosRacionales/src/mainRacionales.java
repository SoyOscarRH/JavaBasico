

import java.util.Scanner;

public class mainRacionales {
    public static void main(String[] args){


        Scanner EscanerDelTeclado = new Scanner(System.in);
        System.out.println("===== Programa Aritmetico Racional ===");

        NumeroRacional A = new NumeroRacional();
        NumeroRacional B = new NumeroRacional();
        NumeroRacional C = new NumeroRacional(1,1);

        A.MuestraNumero();
        B.MuestraNumero();

    }
}
