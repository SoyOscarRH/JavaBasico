import java.util.*;                                                                 		//Añade API en general

public class ListaDeRacionales {
	private static ArrayList<Racional> listaNumeros = new ArrayList<Racional>();  			//Crea una lista de Numeros Racionales
	Scanner escanerDelTeclado = new Scanner(System.in);                     				//Aqui esta el scanner para la entrada

    // ========== INSERTAR EN ARRAY =============
	public void inserta(Racional nuevoRacional){listaNumeros.add(nuevoRacional);}

    // ========== MUESTRA LOS ELEMENTOS  =============
	public void muestraElementos(){
		System.out.println("\n=========================");                     				//Muestro el menu
        for (int i = 0; i < listaNumeros.size(); i++)                      					//Recorre nuestro list
            System.out.println(listaNumeros.get(i));
        System.out.println("=========================");                            		//Salida de todo
	}

    // ========== GENERA UNA OPERACION ===============
	public void generaOperacion(){                                        					//Genera String tipo C=A*B ==
        System.out.println("\nDame tu Operacion en el estilo C=A+B");               		//Pide tu operacion
        String tempString = escanerDelTeclado.nextLine();                                  	//Y da un scanner
        tempString = tempString.replaceAll("\\s","");                               		//Quitemos espacios por si los puso

        if(tempString.length()!=5 && tempString.charAt(1)!='='){generaOperacion();}			//Si algo salio mal, repite

        try {																				//Intenta pasarlo a numeros
        	System.out.println("Entre");
        	Racional A = listaNumeros.get(Character.getNumericValue(tempString.charAt(2)));	//Ponemos operadores 
        	Racional B = listaNumeros.get(Character.getNumericValue(tempString.charAt(4)));	//Ponemos operadores 
        	Racional C = listaNumeros.get(Character.getNumericValue(tempString.charAt(0)));	//Ponemos operadores

        	if(tempString.charAt(3) == '+'){C.Suma(A,B); C.toString();}
        	if(tempString.charAt(3) == '-'){C.Resta(A,B); C.toString();}
        	if(tempString.charAt(3) == '*'){C.Multiplicacion(A,B); C.toString();}
        	if(tempString.charAt(3) == '/'){C.Division(A,B); C.toString();}
        }						
        catch (NumberFormatException e) {generaOperacion();}								//Sino, repite
    }

    // ========== COMPARA ELEMENTOS ===============
    public void comparaElementos(int A, int B){                                             //Compara si dos elementos son iguales
        if(listaNumeros.get(A).equals(listaNumeros.get(B))){                                //Usa equals
            System.out.println("Son iguales");                                              //Si son diferentes
        }
        else{System.out.println("Son diferentes");}                                         //Si son diferentes dilo
    }

    // ========== MUESTRA ANTERIOR ===============
    public void muestraMenor(){                                                             //Muestra el elemento Menor
        int menorID = 0;                                                                    //Aqui guardamos su ID
        for (int i = 0; i < listaNumeros.size(); i++){                                      //Buscamos en todos lados
            if (listaNumeros.get(menorID).compara(listaNumeros.get(i)) == 1){               //Si lo encuentras
                menorID = listaNumeros.get(i).getID();                                      //Cambia si encontraste aun mas pequeño
            }
        }
        System.out.println("El menor es: "+listaNumeros.get(menorID));                      //Mostramos por pantalla
    }

    // ========== MUESTRA MAYOR ===============
    public void muestraMayor(){                                                             //Muestra el mayor
        int mayorID = 0;                                                                    //Aqui guardamos su ID
        for (int i = 0; i < listaNumeros.size(); i++){                                      //Buscamos en todos lados
            if (listaNumeros.get(mayorID).compara(listaNumeros.get(i)) == -1){              //Si lo encuentras
                mayorID = listaNumeros.get(i).getID();                                      //Cambia si encontraste aun mas grande
            }
        }
        System.out.println("El mayor es: "+listaNumeros.get(mayorID));                      //Mostramos por pantalla
    }


    // ========== ORDENA ELEMENTOS ===============
    public void ordenaElementos(){
        int mcmComun = Racional.MCM(1,listaNumeros.get(0).getDenominador());

        for (int i = 1; i < listaNumeros.size(); i++){
            int a = listaNumeros.get(i).getDenominador();
            mcmComun = Racional.MCM(a,mcmComun);
        }

        for (int i = 0; i < listaNumeros.size(); i++){
            int num = listaNumeros.get(i).getNumerador();
            int den = listaNumeros.get(i).getDenominador();

            listaNumeros.get(i).setNumerador((num*mcmComun)/den);
            listaNumeros.get(i).setDenominador(mcmComun);
        }
        Collections.sort(listaNumeros);
        for (int i = 0; i < listaNumeros.size(); i++){listaNumeros.get(i).Reducir();listaNumeros.get(i).setID(i);}
        muestraElementos();
    }


}



