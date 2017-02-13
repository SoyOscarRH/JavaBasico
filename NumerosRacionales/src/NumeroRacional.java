

import java.util.Scanner;

/**==================================================
 * ================= CLASE RACIONAL =================
 * ==================================================
 */
public class NumeroRacional {
    // ======= VARIABLE  ===================
    private int numerador, denominador;
    public String ID;
    Scanner EscanerDelTeclado = new Scanner(System.in);

    //======== CONSTRUCTORES ===============
    public NumeroRacional(){
        System.out.println("Datos Racional");
        System.out.println("Nombre del Racional: ");
        ID = EscanerDelTeclado.next();
        System.out.println("Numerador: ");
        numerador = EscanerDelTeclado.nextInt();
        System.out.println("Denominador: ");
        denominador = EscanerDelTeclado.nextInt();

    }
    public NumeroRacional(int numerador){
        this.numerador = numerador;
        this.denominador = 1;
        ID = "";
    }
    public NumeroRacional(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
        ID = "";
    }

    // =======  MUESTRA DATOS ============
    public void MuestraNumero(){
        System.out.println(ID+" "+numerador+"/"+denominador);
    }


    // =======  SUMA ============
    public NumeroRacional Suma(NumeroRacional A, NumeroRacional B){
        NumeroRacional Resultado = new NumeroRacional();
        if (A.denominador == A.denominador){
            Resultado.numerador=(A.numerador+B.numerador);
            Resultado.denominador= A.denominador;
        }
        else {
            Resultado.numerador=(B.denominador*A.numerador + A.denominador*B.numerador);
            Resultado.denominador=(A.denominador * B.denominador);
        }
        return Resultado;
    }
    public NumeroRacional Resta(NumeroRacional A, NumeroRacional B){
        B.numerador = B.numerador*-1;
        NumeroRacional Resultado = Suma(A,B);

        return Resultado;
    }
}