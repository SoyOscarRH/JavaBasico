import java.util.Scanner;
import java.util.*;

/**==================================================
 * ================= CLASE RACIONAL =================
 * ==================================================
 */
public class NumeroRacional {
    // ======= VARIABLE  ===================
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
    private void CrearNumeroRacional(int tempNum, int tempDen){
        System.out.println("Bien");
        denominador = tempDen;
        if (tempDen==0) {denominador=1;}
        numerador = tempNum;
        Reducir();
    }

    private void CrearNumeroRacional(String temporal){                              //Este contructor decide        
        int tempNum, tempDen;
        String tempStringNum,tempStringDen;
        for (int i=0; i<temporal.length(); i++) {
            if (temporal.charAt(i)=='/') {

                if (SonSoloNumeros(temporal.substring(0,i))) {
                    tempNum = Integer.parseInt(temporal.substring(0,i));
                }
                else{tempNum=1;}

                if (SonSoloNumeros(temporal.substring(i+1))) {
                    tempDen = Integer.parseInt(temporal.substring(i+1));
                }
                else{tempDen=1;}
                CrearNumeroRacional(tempNum,tempDen);
                return;
            }
        }

        for (int i=0; i<temporal.length(); i++) {
            if (temporal.charAt(i)=='.') {

                if(SonSoloNumeros(temporal.substring(0,i))){
                    if(SonSoloNumeros(temporal.substring(i+1))){
                        tempStringNum = temporal.substring(0,i);
                        tempStringDen = temporal.substring(i+1);
                        tempStringNum += tempStringDen;
                        tempNum=Integer.parseInt(tempStringNum);

                        tempDen=(int)Math.pow(10,(temporal.length()-i-1));
                        System.out.println("Creando un racional con:"+tempNum+tempDen);
                        CrearNumeroRacional(tempNum,tempDen);
                        return;
                    }
                }
                CrearNumeroRacional(1,1);
            }
        }

        temporal+='/';
        temporal+='1';
        CrearNumeroRacional(temporal);
    }

    //======== CONSTRUCTORES ===============
    public NumeroRacional(){                                                        //Nuestro constructor por defecto
        ID = cantidadDeNumeros++;
        System.out.println("Dato #"+(cantidadDeNumeros)+"\nDame un numero: ");      //Muestra mensajito :3
        String temporal = escanerDelTeclado.nextLine();
        temporal = temporal.replaceAll("\\s","");
        CrearNumeroRacional(temporal);
    }

    public NumeroRacional(String temporal){
        ID = cantidadDeNumeros++;
        CrearNumeroRacional(temporal);
    }

    public NumeroRacional(int tempNum, int tempDen){
        ID = cantidadDeNumeros++;
        CrearNumeroRacional(tempNum, tempDen);
    }
}