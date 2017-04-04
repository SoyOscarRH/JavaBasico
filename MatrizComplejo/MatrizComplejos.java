import java.util.*;                                            //Añade API en general
import java.util.Random;

public class MatrizComplejos {                                 //======== CLASE COMPLEJO ========

    // ======= VARIABLES DE LA FORMA una Matriz ==========
    ArrayList< ArrayList<NumComplejo> > Matriz;
    String Nombre;
    int m, n;

    //======= CONSTRUCTORES ========================
    public MatrizComplejos(String Nombre, int m, int n){
        this.m = m; this.n = n; this.Nombre = Nombre;

        Matriz = new ArrayList < ArrayList<NumComplejo> >();

        for (int i = 0; i < m; i++) {
            ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
            for (int j = 0; j < n; j++)
                Temporal.add(new NumComplejo(1,1));
            Matriz.add(Temporal);
        }
    }
    //======= CONSTRUCTORES ========================
    public MatrizComplejos(String Nombre, int m){
        this(Nombre, m, m);
    }

    //======= CONSTRUCTORES ========================
    public MatrizComplejos(String Nombre, int m, int n, String Rango){
        this.m = m; this.n = n; this.Nombre = Nombre;
        Matriz = new ArrayList < ArrayList<NumComplejo> >();

        Random NumeroRandom = new Random(System.nanoTime());                    //Creamos un numero random
        int signo = 1, numeroA = 1, numeroB = 1;                                //Veamos a el signo de nuestras variables
        
        if(Rango.charAt(1) == '+')signo =  1;                                   //Dependiendo de nuestro signo
        if(Rango.charAt(1) == '-')signo = -1;                                   //Dependiendo de nuestro signo
        if(Rango.charAt(1) == '*')signo =  0;                                   //Dependiendo de nuestro signo

        int numMaximo = Integer.parseInt(Rango.substring(2));                   //Dame el numero maximo

        for (int i = 0; i < m; i++) {
            ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
            for (int j = 0; j < n; j++){
                
                numeroA = NumeroRandom.nextInt(numMaximo);                       //Sacamos el random
                if(signo == 0 && NumeroRandom.nextInt(1) == 1) numeroA*=-1;      //Si tenemos ambos y la suerte quiere signo menos
                else if (signo == -1) numeroA *= -1;                             //Signos menos

                numeroB = NumeroRandom.nextInt(numMaximo);                       //Sacamos el random
                if(signo == 0 && NumeroRandom.nextInt(1) == 1) numeroB*=-1;      //Si tenemos ambos y la suerte quiere signo menos
                else if (signo == -1) numeroB *= -1;                             //Signos menos

                Temporal.add(new NumComplejo(numeroA, numeroB));
            }
            Matriz.add(Temporal);
        }   
    }


    //======= CONSTRUCTORES ========================
    public MatrizComplejos(String Nombre, MatrizComplejos A){
        this.m = A.m; this.n = A.n; this.Nombre = Nombre;

        Matriz = new ArrayList < ArrayList<NumComplejo> >();

        for (int i = 0; i < m; i++) {
            ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
            for (int j = 0; j < n; j++)
                Temporal.add((A.Matriz.get(i)).get(j));
            Matriz.add(Temporal);
        }
    }



    //=== Sobre escribir toString ======
    public String toString() {                                 
        String Resultado = new String();

        Resultado += ("=== "+Nombre+" ===\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                Resultado += ("["+(Matriz.get(i)).get(j)+"]\t");
            Resultado += "\n\n\n\n";
        }
        return Resultado;
    }


    //=== Sobre escribir toString ======
    public void imprimir(String Tipo) { 
        Tipo.toLowerCase();
        boolean formaMostrar = (Tipo == "binomio" || Tipo == "rectangular");

        String Resultado = new String();

        Resultado += ("=== "+Nombre+" ===\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (formaMostrar == false)
                    Resultado += ("["+(Matriz.get(i)).get(j)+"]\t");
                else
                    Resultado += ("["+(Matriz.get(i)).get(j).Polar()+"]\t");
            }
            Resultado += "\n\n\n\n";
        }
        System.out.print(Resultado);
    }






}