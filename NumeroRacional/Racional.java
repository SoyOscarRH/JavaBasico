import java.util.*;                                                                 	//Añade API en general

public class Racional implements Comparable<Racional> {                                 //======== CLASE RACIONAL ========

    // ======= VARIABLES  ==========================
    static Scanner escanerDelTeclado = new Scanner(System.in);                     		//Aqui esta el scanner para la entrada
    static private int cantidadDeNumeros;												//Lleva conteo de cuantos para poner nombre
    static public int mcmComun;

    private int numerador, denominador;                                             	//Estos son nuestros datos importantes
    private int ID;                                                                 	//Nos dice que cual es su lugar

    public int getDenominador(){return this.denominador;}                               //Setter and Getter
    public int getNumerador(){return this.numerador;}                                   //Setter and Getter
    public void setNumerador(int num){numerador = num;}                                 //Setter and Getter
    public void setDenominador(int num){denominador = num;}                             //Setter and Getter
    public int getID(){return ID;}                                                      //Setter and Getter
    public void setID(int ID){this.ID = ID;}                                            //Setter and Getter
    
    // ======= METODOS DE CLASE  ===================
    static int MCD(int m, int n){                                          				//=== Crea un MCD Auxiliar ========
        if(n == 0) return m;                                                        	//Si ya llegaste al final, listo
        return MCD(n, (m%n));                                                       	//Sino, sigue trabajando
    }

    static int MCM(int a, int b){return ((a*b)/MCD(a,b));}                              //=== Crea un MCM Auxiliar ========


    static boolean EsUnNumero(String cadenaX) {                             			//=== Busca Si Solo hay Numeros ====
        boolean loEres = false;                                                     	//Se encarga de saber si lo eres
        try { int temporal = Integer.parseInt(cadenaX); loEres = true;}					//Intenta pasarlo a numeros
        catch (NumberFormatException e) {loEres = false;}								//Sino, hubo errores
		return loEres;																	//Regresa tus resultados
    }


    // ======= FUNCIONES AUXILIARES  ===============
    public String toString() {return "Numero #"+ID+" :"+numerador+"/"+denominador;}		//=== Sobre escribir toString ======

    public boolean equals(Racional A){                                                  //=== Sobreescribe el Metodo de Equals
        if(A.numerador == numerador && A.numerador == numerador){return true;}
        return false;
    }

    public void Reducir(){                                                         	    //=== Reducir una Fraccion =========
    	if(numerador-denominador==0){numerador=denominador=1; return;}					//Si es A/A sal entonces

    	boolean cambioSigno = false;													//Supongamos que no hay signos negativos
    	if (numerador<0 || denominador<0) {												//Pero si hay:
    		cambioSigno = true;															//Guardemos que habia y quitemoslo mientras
    		if(numerador<0 && denominador>0) {numerador *= -1;}							//Primero con caso -a / b
    		else if(numerador>0 && denominador<0) {numerador *= -1;}					//Despues con caso a / b
    		else{numerador *= -1; denominador *= -1; cambioSigno = false;}				//Y finalmenten con -a / -b
    	}
        
        int divisor = MCD(numerador, denominador);   	                				//Encontramos el divisor
        denominador /= divisor;                                             	        //Y con el denominador
        numerador /= divisor;                                           	            //Y lo usamos con el numerados
        if(cambioSigno){numerador *= -1;}												//Si habia un menos lo volvemos a poner
    }

    public int compara(Racional A){
        if(A.denominador*numerador < A.numerador*denominador){return -1;}               //Yo son menor
        if(A.denominador*numerador > A.numerador*denominador){return 1;}                //Yo soy mayor
        return 0;
    }

    public int compareTo(Racional A) {                                                  //=== Compara para Ordenar =========
        int comparacion = (A.numerador);                    
        return this.numerador-comparacion;
    }


    // ======= CONSTRUCTORES AUXILIARES  ===========
    private void CrearRacional(String temporal){                              			//=== FUNCION MAS PRO DEL MUNDO ====
        int tempNum, tempDen;                                                       	//Creamos dos temporales               
        String tempString;                                                          	//Y creamos dos strings

        for (int i=0; i<temporal.length(); i++) {                                   	//====== FORMA A/B ==========
            if (temporal.charAt(i)=='/') {                                          	//Busquemos ese simbolo
                if (EsUnNumero(temporal.substring(0,i))) {                      		//Si lo que tenemos solo son enteros
                    tempNum = Integer.parseInt(temporal.substring(0,i));            	//Vamos a guardarlo como entero
                }
                else{tempNum=1;}                                                    	//Sino mandemos un 1

                if (EsUnNumero(temporal.substring(i+1))) {                      		//Si todo lo demas (b) es entero
                    tempDen = Integer.parseInt(temporal.substring(i+1));            	//Guardalo en denominador
                }
                else{tempDen=1;}                                                    	//Guardemos un uno sino lo es
                CrearRacional(tempNum,tempDen);											//Crea nuestro racionales
                return;                                                             	//Y se acabo la diversion
            }
        }

        for (int i=0; i<temporal.length(); i++) {                                   	//====== FORMA A.B ==========
            if (temporal.charAt(i)=='.' && EsUnNumero(temporal.substring(0,i))) {       //Si es que encontraste un punto
            	if(EsUnNumero(temporal.substring(i+1))){                    			//Y tambien lo siguiente
                    tempString = temporal.substring(0,i);                       		//Guardamos A 
                    tempString += temporal.substring(i+1);                      		//Y B
                    tempNum=Integer.parseInt(tempString);                       		//Hagamoslo entero

                    tempDen=(int)Math.pow(10,(temporal.length()-i-1));          		//Y hagamos nuestro denominador
                    CrearRacional(tempNum,tempDen);                       				//Creamos un numero racional
                    return;                                                     		//Y nos vamos wey!
                }  
            }
        }

        if(EsUnNumero(temporal) == false){CrearRacional(1,1);}							//Si algo salio mal, solo mando un 1/1
        else{CrearRacional(temporal+="/1");}											//Sino tiene nada de eso, recursividad
    }
    private void CrearRacional(int tempNum, int tempDen){                     			//=== Crea un racional, todo por aqui
        denominador = tempDen;                                                      	//Pon lo que debe en el denominador
        if (tempDen==0) {denominador=1;}                                            	//Excepto si un gracioso puso cero
        numerador = tempNum;                                                        	//Y ponemos ahora lo que debe en num
        Reducir();                                                                  	//Y mandamos a recudir la expresion
    }


    //======= CONSTRUCTORES ========================
    public Racional(){                                                        			//Nuestro constructor por defecto
        ID = cantidadDeNumeros++;                                                   	//Asignamos y aumentamos el contador
        System.out.println("Dato #"+(cantidadDeNumeros)+"\nDame un numero: ");      	//Muestra mensajito :3
        String temporal = escanerDelTeclado.nextLine();                             	//Creamos un scanner temporal
        CrearRacional(temporal.replaceAll("\\s",""));                               	//Llamemos a una funcion que interprete eso
    }
    public Racional(String temporal){                                         			//Creamos un racional si nos dan string
        ID = cantidadDeNumeros++;                                                   	//Asignamos y aumentamos el contador
        CrearRacional(temporal);                                              			//Llamemos a una funcion que interprete eso
    }
    public Racional(int tempNum, int tempDen){                                			//Creamos un racional si nos dan 2 numeros
        ID = cantidadDeNumeros++;                                                   	//Asignamos y aumentamos el contador
        CrearRacional(tempNum, tempDen);                                      			//Llamemos a una funcion que interprete eso
    }
    public Racional(Racional A){                                        				//Creamos un racional si nos dan 1 racional
        ID = cantidadDeNumeros++;                                                   	//Asignamos y aumentamos el contador
        CrearRacional(A.numerador, A.denominador);                            			//Llamemos a una funcion que interprete eso
    }


    //======== OPERACIONES ===============
        public Racional Suma(Racional A){return Suma(A,this);}
        public Racional Suma(Racional A, Racional B){
            int tempNum,tempDen;
            tempDen = A.denominador * B.denominador;
            tempNum = (B.denominador*A.numerador) + (A.denominador*B.numerador);
            numerador=tempNum; denominador=tempDen;
            Reducir(); 
            return this;
        }
        public Racional Resta(Racional A){return Resta(A,this);}
        public Racional Resta(Racional A, Racional B){
            int tempNum,tempDen;
            tempDen = A.denominador * B.denominador;
            tempNum = (B.denominador*A.numerador) - (A.denominador*B.numerador);
            numerador=tempNum;  denominador=tempDen;
            Reducir();
            return this; 
        }
        public Racional Multiplicacion(Racional A){return Multiplicacion(A,this);}
        public Racional Multiplicacion(Racional A, Racional B){
            int tempNum,tempDen;
            tempDen = A.denominador * B.denominador;
            tempNum = A.numerador * B.numerador;
            numerador=tempNum; denominador=tempDen;
            Reducir(); 
            return this;
        }
        public Racional Division(Racional A){return Division(A,this);}
        public Racional Division(Racional A, Racional B){
            int tempNum,tempDen;
            tempDen = A.denominador / B.numerador;
            tempNum = B.denominador / A.numerador;
            numerador=tempNum; denominador=tempDen;
            Reducir(); 
            return this;
        }
}