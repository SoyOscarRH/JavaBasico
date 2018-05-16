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
            Resultado += "\n\n";
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



    public MatrizComplejos sumar(MatrizComplejos A){return sumar(A,this);}
    public MatrizComplejos sumar(MatrizComplejos A, MatrizComplejos B){
        if(A.m == B.m && A.n == B.n){
            m = A.m; n = A.n;
            ArrayList <ArrayList<NumComplejo> > NuevaMatriz = new ArrayList <ArrayList<NumComplejo> >();

            for (int i = 0; i < m; i++) {
                ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
                for (int j = 0; j < n; j++){
                    NumComplejo numTemporal1 = (A.Matriz.get(i)).get(j);
                    NumComplejo numTemporal2 = (B.Matriz.get(i)).get(j);
                    Temporal.add(numTemporal1.Suma(numTemporal2));
                }
                NuevaMatriz.add(Temporal);
            }
            Matriz = NuevaMatriz;
        }
        return this;
    }
    public MatrizComplejos restar(MatrizComplejos A){return restar(A,this);}
    public MatrizComplejos restar(MatrizComplejos A, MatrizComplejos B){
        if(A.m == B.m && A.n == B.n){
            m = A.m; n = A.n;
            ArrayList <ArrayList<NumComplejo> > NuevaMatriz = new ArrayList <ArrayList<NumComplejo> >();

            for (int i = 0; i < m; i++) {
                ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
                for (int j = 0; j < n; j++){
                    NumComplejo numTemporal1 = (A.Matriz.get(i)).get(j);
                    NumComplejo numTemporal2 = (B.Matriz.get(i)).get(j);
                    Temporal.add(numTemporal1.Resta(numTemporal2));
                }
                NuevaMatriz.add(Temporal);
            }
            Matriz = NuevaMatriz;
        }
        return this;
    }

    public MatrizComplejos multiplicar(MatrizComplejos A){return multiplicar(A,this);}
    public MatrizComplejos multiplicar(MatrizComplejos A, MatrizComplejos B){
        if(A.n == B.m){
            m = A.m; n = B.n;
            ArrayList <ArrayList<NumComplejo> > NuevaMatriz = new ArrayList <ArrayList<NumComplejo> >();

            NumComplejo elemento, temp1, temp2;
            for (int i = 0; i < m; i++){                                            //Recorre todas filas
                ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
                for(int j = 0; j < n; j++){                                         //Y para cada elemento de esta fila
                    elemento = new NumComplejo(0,0);                                //Aqui guardamos el resultado
                    for (int k = 0; k < A.n; k++){                                  //Recorremos toda la fila / columna
                        temp1 = (A.Matriz.get(i)).get(k);
                        temp2 = (B.Matriz.get(k)).get(j);
                        temp2 = temp2.Multiplicacion(temp1);
                        elemento.Suma(temp2);
                    }
                    Temporal.add(elemento);                                         //Y al guardalo
                }
                NuevaMatriz.add(Temporal);        
            }
            Matriz = NuevaMatriz;
        }
        return this;
    }




    MatrizComplejos transpuesta(){
        MatrizComplejos Nueva = new MatrizComplejos("M1-Transpuesta", n, m);
        ArrayList < ArrayList<NumComplejo> > NuevaMatriz = new ArrayList < ArrayList<NumComplejo> >();

        for (int i = 0; i < n; i++) {
            ArrayList<NumComplejo> Temporal = new ArrayList<NumComplejo>();
            for (int j = 0; j < m; j++)
                Temporal.add((Matriz.get(j)).get(i));
            NuevaMatriz.add(Temporal);
        }

        Nueva.Matriz = NuevaMatriz;
        return Nueva;
    }




    boolean MuestraContorno(int nivel){
        int xActual = 0 + nivel;
        int yActual = 0 + nivel;

        int movimientoEnX = n - (2*nivel);
        int movimientoEnY = ( m - (2*nivel) ) - 2;

        if (movimientoEnY < 1 && movimientoEnX > 0){
            for (int i = 0; i < movimientoEnX; i++){
                System.out.print((Matriz.get(yActual)).get(xActual+i)+" ");
            }
            return false;
        }

        if (movimientoEnX < 1 && movimientoEnY > 0){
            for (int i = 0; i < movimientoEnX; i++){
                System.out.print((Matriz.get(yActual)).get(xActual+i)+" ");
            }
            return false;
        }

        if (movimientoEnX < 1 && movimientoEnY < 1){
            return false;
        }

        for (int i = 0; i < movimientoEnX; i++){
            System.out.print((Matriz.get(yActual)).get(xActual+i)+" ");
        }

        xActual += (movimientoEnX-1); 
        yActual++;

        System.out.print(" // ");

        for (int i = 0; i < movimientoEnY; i++){
            System.out.print((Matriz.get(yActual+i)).get(xActual)+" ");
        }

        yActual += movimientoEnY; 

        System.out.print(" // ");

        for (int i = 0; i < movimientoEnX; i++){
            System.out.print((Matriz.get(yActual)).get(xActual-i)+" ");
        }

        xActual -= (movimientoEnX-1); 
        yActual--;

        System.out.print(" // ");
        
        for (int i = 0; i < movimientoEnY; i++){
            System.out.print((Matriz.get(yActual-i)).get(xActual)+" ");
        }

        System.out.print(" // ");
        return true;

    } 


    void Espiral(){
        int num = Math.max(m,n);
        for (int i = 0; i < num; i++){
            if (!MuestraContorno(i)) break;
        }
    }

    void calculos(){
        NumComplejo menor, mayor;
        menor = mayor = (Matriz.get(0)).get(0);
        NumComplejo promedio = new NumComplejo(0,0);

        for (int i = 0; i < m; i++) {                                      
            for (int j = 0; j < n; j++) {                                      
                if ( (Matriz.get(i)).get(j).magnitud() > mayor.magnitud()) mayor = (Matriz.get(i)).get(j);
                else if ( (Matriz.get(i)).get(j).magnitud() < menor.magnitud()) menor = (Matriz.get(i)).get(j);
                promedio.Suma((Matriz.get(i)).get(j));
            }
        }

        int sumaDeTodo = (m+n)-1;

        System.out.println("\nEl mayor elemento (en cuanto a magnitud) es el "+mayor+" y el menor es el "+menor+"\n");
        System.out.println("Y el promedio es "+(promedio.a)+"/"+sumaDeTodo+" + "+promedio.b+"/"+sumaDeTodo+" i");

    }




    //======= F ========================
    boolean equals(MatrizComplejos A){

        if( m != A.m || n != A.n) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if ((Matriz.get(i)).get(j).equals((A.Matriz.get(i)).get(j)) == false) return false;
        }

        return true;
    }



}