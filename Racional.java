import java.util.Scanner;

/**==================================================
 * ================= CLASE RACIONAL =================
 * ==================================================
 */
public class Racional {
    // ======= VARIABLE  ===================
    private int numerador, denominador;
    public String ID;
    Scanner EscanerDelTeclado = new Scanner(System.in);

    //======== CONSTRUCTORES ===============
    public Racional(){
        System.out.print("Dame los datos de tu racional:");
        System.out.print("\nNumerador: ");
        numerador = EscanerDelTeclado.nextInt();
        System.out.print("\nDenominador: ");
        denominador = EscanerDelTeclado.nextInt();
        System.out.print("\nNombre del Racional: ");
        ID = EscanerDelTeclado.next();
    }
    public Racional(int numerador){
        this.numerador = numerador;
        this.denominador = 1;
        ID = "";
    }
    public Racional(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
        ID = "";
    }

    // =======  MUESTRA DATOS ============
    public void MuestraNumero(){
        System.out.println(numerador+"/"+denominador);
    }


    // =======  SUMA ============
    public Racional Suma(Racional A, Racional B){
        Racional Resultado = new Racional();
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
    public Racional Resta(Racional A, Racional B){
        B.numerador = B.numerador*-1;
        Racional Resultado = Suma(A,B);

        return Resultado;
    }
}
