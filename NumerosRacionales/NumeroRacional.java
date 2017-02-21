

import java.util.Scanner;

/**==================================================
 * ================= CLASE RACIONAL =================
 * ==================================================
 */
public class NumeroRacional {
    // ======= VARIABLE  ===================
    private int numerador, denominador;
    private int ID;
    Scanner EscanerDelTeclado = new Scanner(System.in);

    //======== CONSTRUCTORES ===============
    public NumeroRacional(int ID){
        System.out.println("Datos Racional #");
        System.out.println("Numerador: ");
        numerador = EscanerDelTeclado.nextInt();
        System.out.println("Denominador: ");
        denominador = EscanerDelTeclado.nextInt();
        this.ID = ID;
    }

    public void MuestraNumero(){
        System.out.println("Datos Racional #"+ID);
        System.out.println(numerador+"/"+denominador);
    }
}