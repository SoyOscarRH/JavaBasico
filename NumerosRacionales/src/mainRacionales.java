

import java.util.Scanner;

public class mainRacionales {
    public static void main(String[] args){


        Scanner EscanerDelTeclado = new Scanner(System.in);
        System.out.println("===== Programa Aritmetico Racional ===");
        System.out.println("Elige cuantos datos deseas añadir: ");

        int numeroDeRacionales = EscanerDelTeclado.nextInt();

        NumeroRacional[] ArraydeRacionales = new NumeroRacional[numeroDeRacionales];
        for (int i = 0; i < numeroDeRacionales; i++){
            ArraydeRacionales[i] = new NumeroRacional();
        }

        ArraydeRacionales[2] = ArraydeRacionales[2].Resta(ArraydeRacionales[0], ArraydeRacionales[1]);

        for (int i = 0; i < numeroDeRacionales; i++){
            ArraydeRacionales[i].MuestraNumero();
        }
    }
}
