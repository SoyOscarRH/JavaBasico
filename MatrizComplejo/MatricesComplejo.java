import java.util.*;                                            //Añade API en general

public class MatricesComplejo {                                //======== CLASE COMPLEJO ========
    public static void main(String[] args) {
        NumComplejo C1 = new NumComplejo();
        System.out.println(C1);

        NumComplejo C2 = new NumComplejo(4);
        System.out.println(C2);

        NumComplejo C3 = new NumComplejo(3, 2);
        System.out.println(C3);

    }


    // ======= VARIABLES DE LA FORMA una Matriz ==========================
    ArrayList< ArrayList<NumComplejo> > Matriz;
    String Nombre;
    int m, n;

    //======= CONSTRUCTORES ========================
    public MatricesComplejo(String Nombre, int m, int n){
        this.m = m; this.n = n; this.Nombre = Nombre;

        Matriz = new ArrayList < ArrayList<NumComplejo> >();

        for (int i = 0; i < m; i++) {
            ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
            for (int j = 0; j < n; j++) Temporal.add(new NumComplejo(1,1));
            Matriz.add(Temporal);
        }
    }

    public String toString() {                                 //=== Sobre escribir toString ======
        String Resultado;

        Resultado += ("=== "+Nombre+" ===\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) Resultado += Matriz.get(i);
            Matriz.add(Temporal);
        }
    }






}