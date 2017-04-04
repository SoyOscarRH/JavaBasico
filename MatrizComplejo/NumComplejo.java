import java.util.*;                                                             //Añade API en general
import java.lang.*;                                                             //Añade API en general

public class NumComplejo {                                                      //======== CLASE COMPLEJO ========

    // ======= VARIABLES DE LA FORMA a + bi ==========================
    int a, b;

    // ======= FUNCIONES AUXILIARES  ===============
    public String toString() {return a+" + "+b+"i";}                            //=== Sobre escribir toString ======
    public boolean equals(NumComplejo A){                                       //=== Sobreescribe el Metodo de Equals
        if(A.a == a && A.b == b) return true;
        return false;
    }

    //======= CONSTRUCTORES ========================
    public NumComplejo(int a, int b){this.a = a; this.b = b;}                   //=== Crea el Objeto
    public NumComplejo(int a){this.a = a; this.b = 0;}                          //=== Crea el Objeto, solo real
    public NumComplejo(){this.a = 0; this.b = 0;}                               //=== Crea el Objeto, solo real

    //======== OPERACIONES ===============
    public NumComplejo Suma(NumComplejo A){return Suma(A,this);}
    public NumComplejo Suma(NumComplejo A, NumComplejo B){
        A.a += B.a;
        A.b += B.b;
        return this;
    }
    public NumComplejo Resta(NumComplejo A){return Resta(A,this);}
    public NumComplejo Resta(NumComplejo A, NumComplejo B){
        A.a -= B.a;
        A.b -= B.b;
        return this;
    }
    public NumComplejo Multiplicacion(NumComplejo A){return Multiplicacion(A,this);}
    public NumComplejo Multiplicacion(NumComplejo A, NumComplejo B){
        int temporalA = ((A.a * B.a) - (A.b * B.b));
        int temporalB = ((A.a * B.b) + (A.b * B.a));
        return this;
    }

    public String Polar(){

        double angulo = Math.atan(b/a);
        angulo = Math.round(angulo*100)/100.0d;

        double magnitud = Math.sqrt((double)((a*a)+(b*b)));
        magnitud = Math.round(magnitud*100)/100.0d;

        return (magnitud+" <"+angulo);
    }
}