import java.util.Scanner;                                                           //Añade API de Scanner
import java.util.*;                                                                 //Añade API en general

/**==================================================
 * ================= CLASE RACIONAL =================
 * ==================================================
 */
public class NumeroRacional {                                                       //======== CLASE RACIONAL ========
    // ======= VARIABLES  ===================
    private int numerador, denominador;                                             //Estos son nuestros datos importantes
    private int ID;                                                                 //Nos dice que cual es su lugar
    static int cantidadDeNumeros = 0;                                               //Crea un contador para la cantidad
    Scanner escanerDelTeclado = new Scanner(System.in);                             //Aqui esta el scanner para la entrada

    // ======= FUNCIONES AUXILIARES ========
    private int MCD(int m, int n){                                                  //=== Crea un MCD Auxiliar =======
        if(n == 0) return m;                                                        //Si ya llegaste al final, listo
        return MCD(n, (m%n));                                                       //Sino, sigue trabajando
    }

    public void MuestraNumero(){                                                    //=== Muestra un Numero ==========
        System.out.println("Numero #"+ID+" :"+numerador+"/"+denominador);           //Solo muestra tu numero
    }

    private boolean SonSoloNumeros(String cadenaX) {                                //=== Busca Si Solo hay Numero ==
        boolean loEres = false;                                                     //Se encarga de saber si lo eres
        if(!(cadenaX == null || cadenaX.equals("") || cadenaX.equals("null")))      //Busca que no este vacio
            loEres = cadenaX.matches("^[0-9]+$");                                   //Busca matches,de encontrarlas bien
        return loEres;                                                              //Regresa tu resultado
    }

    private void Reducir(){                                                         //=== Se encarga de Reducir a la max  
        int denominadorTemporal = denominador, numeradorTemporal = numerador;       //Crea copias
        if (denominador<0) denominadorTemporal *= -1;                               //Evita negativos
        if (numerador<0) numeradorTemporal *= -1;                                   //Evita negativos
        if(numerador-denominador==0){numerador=denominador=1;return;}

        int divisor = MCD(numeradorTemporal,denominadorTemporal);                   //Encontramos el divisor

        numerador /= divisor;                                                       //Y lo usamos con el numerados
        denominador /= divisor;                                                     //Y con el denominador
    }

    //======= CONSTRUCTORES DE "AUXILIO" ====
    private void CrearNumeroRacional(int tempNum, int tempDen){                     //Crea un racional en base a 2 enteros
        denominador = tempDen;                                                      //Pon lo que debe en el denominador
        if (tempDen==0) {denominador=1;}                                            //Excepto si un gracioso puso cero
        numerador = tempNum;                                                        //Y ponemos ahora lo que debe en num
        Reducir();                                                                  //Y mandamos a recudir la expresion
    }

    private void CrearNumeroRacional(String temporal){                              //===== FUNCION MAS PRO DEL MUNDO=== 
        int tempNum, tempDen;                                                       //Creamos dos temporales               
        String tempString;                                                          //Y creamos dos strings
        for (int i=0; i<temporal.length(); i++) {                                   //====== FORMA A/B ==========
            if (temporal.charAt(i)=='/') {                                          //Busquemos ese simbolo
                if (SonSoloNumeros(temporal.substring(0,i))) {                      //Si lo que tenemos solo son enteros
                    tempNum = Integer.parseInt(temporal.substring(0,i));            //Vamos a guardarlo como entero
                }
                else{tempNum=1;}                                                    //Sino mandemos un 1

                if (SonSoloNumeros(temporal.substring(i+1))) {                      //Si todo lo demas (b) es entero
                    tempDen = Integer.parseInt(temporal.substring(i+1));            //Guardalo en denominador
                }
                else{tempDen=1;}                                                    //Guardemos un uno sino lo es
                CrearNumeroRacional(tempNum,tempDen);
                return;                                                             //Y se acabo la diversion
            }
        }

        for (int i=0; i<temporal.length(); i++) {                                   //====== FORMA A.B ==========
            if (temporal.charAt(i)=='.') {                                          //Si es que encontraste un punto
                if(SonSoloNumeros(temporal.substring(0,i))){                        //Y solo son numeros lo anterior
                    if(SonSoloNumeros(temporal.substring(i+1))){                    //Y tambien lo siguiente
                        tempString = temporal.substring(0,i);                       //Guardamos A 
                        tempString += temporal.substring(i+1);                      //Y B
                        tempNum=Integer.parseInt(tempString);                       //Hagamoslo entero

                        tempDen=(int)Math.pow(10,(temporal.length()-i-1));          //Y hagamos nuestro denominador
                        CrearNumeroRacional(tempNum,tempDen);                       //Creamos un numero racional
                        return;                                                     //Y nos vamos wey!
                    }
                }   
                CrearNumeroRacional(1,1);                                           //Si algo salio mal, solo mando un 1/1
            }
        }          
        CrearNumeroRacional(temporal+="/1");                                        //Sino tiene nada de eso, recursividad
    }

    //======== CONSTRUCTORES ===============
    public NumeroRacional(){                                                        //Nuestro constructor por defecto
        ID = cantidadDeNumeros++;                                                   //Asignamos y aumentamos el contador
        System.out.println("Dato #"+(cantidadDeNumeros)+"\nDame un numero: ");      //Muestra mensajito :3
        String temporal = escanerDelTeclado.nextLine();                             //Creamos un scanner temporal
        temporal = temporal.replaceAll("\\s","");                                   //Quitemos espacios por si los puso
        CrearNumeroRacional(temporal);                                              //Llamemos a una funcion que interprete eso
    }

    public NumeroRacional(String temporal){                                         //Creamos un racional si nos dan string
        ID = cantidadDeNumeros++;                                                   //Asignamos y aumentamos el contador
        CrearNumeroRacional(temporal);                                              //Llamemos a una funcion que interprete eso  
    }

    public NumeroRacional(int tempNum, int tempDen){                                //Creamos un racional si nos dan 2 numeros
        ID = cantidadDeNumeros++;                                                   //Asignamos y aumentamos el contador
        CrearNumeroRacional(tempNum, tempDen);                                      //Llamemos a una funcion que interprete eso
    }
    public NumeroRacional(NumeroRacional A){                                        //Creamos un racional si nos dan 1 racional
        ID = cantidadDeNumeros++;                                                   //Asignamos y aumentamos el contador
        CrearNumeroRacional(A.numerador, A.denominador);                            //Llamemos a una funcion que interprete eso
    }


    //======== OPERACIONES ===============
    public NumeroRacional Suma(NumeroRacional A){return Suma(A,this);}
    public NumeroRacional Suma(NumeroRacional A, NumeroRacional B){
        int tempNum,tempDen;
        tempDen = A.denominador * B.denominador;
        tempNum = (B.denominador*A.numerador) + (A.denominador*B.numerador);
        numerador=tempNum;denominador=tempDen;
        Reducir(); 
        return this;
    }
    public NumeroRacional Resta(NumeroRacional A){return Resta(A,this);}
    public NumeroRacional Resta(NumeroRacional A, NumeroRacional B){
        int tempNum,tempDen;
        tempDen = A.denominador * B.denominador;
        tempNum = (B.denominador*A.numerador) - (A.denominador*(B.numerador*-1));
        numerador=tempNum;denominador=tempDen;
        Reducir();
        return this; 
    }
    public NumeroRacional Multiplicacion(NumeroRacional A){return Multiplicacion(A,this);}
    public NumeroRacional Multiplicacion(NumeroRacional A, NumeroRacional B){
        int tempNum,tempDen;
        tempDen = A.denominador * B.denominador;
        tempNum = A.numerador * B.numerador;
        numerador=tempNum;denominador=tempDen;
        Reducir(); 
        return this;
    }
    public NumeroRacional Division(NumeroRacional A){return Division(A,this);}
    public NumeroRacional Division(NumeroRacional A, NumeroRacional B){
        int tempNum,tempDen;
        tempDen = A.denominador * B.numerador;
        tempNum = B.denominador * A.numerador;
        numerador=tempNum;denominador=tempDen;
        Reducir(); 
        return this;
    }
}