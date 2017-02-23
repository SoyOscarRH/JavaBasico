import java.util.*;                                                                 		//Añade API en general

public class ListaDeRacionales {
	private static ArrayList<Racional> listaNumeros = new ArrayList<Racional>();  			//Crea una lista de Numeros Racionales
	Scanner escanerDelTeclado = new Scanner(System.in);                     				//Aqui esta el scanner para la entrada

	public void inserta(Racional nuevoRacional){listaNumeros.add(nuevoRacional);}

	public void muestraElementos(){
		System.out.println("\n=========================");                     				//Muestro el menu
        for (int i = 0; i < listaNumeros.size(); i++)                      					//Recorre nuestro list
            System.out.println(listaNumeros.get(i));
        System.out.println("=========================");                            		//Salida de todo
	}

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

    public void ordenaElementos(){
    	for (int i = 0; i < listaNumeros.size(); i++){
    		int lugarARemplazar;
    		for (int j = 1; j < listaNumeros.size(); j++){
    			
    		}
    	}
    }

}



