public class main {
	public static void main(String[] args) {

		/*
		Crea la matriz M1 de orden 3X3 (3 renglones y 3 columnas) inicializando todos sus 
		elementos al valor de 1. El nombre de la matriz es “M1”. 
		Tanto la parte real como la imaginaria de los complejos tienen el valor de 1
		*/
		MatrizComplejos M1 = new MatrizComplejos("M1",3);
		System.out.println(M1);

		/*
		Crea la matriz M2 de orden 3X4 (3 renglones y 4 columnas)
		e inicializa todos sus valores a 1. El nombre de la matriz es “M2”
		Tanto la parte real como imaginaria de los complejos tienen el valor de 1
		*/
		MatrizComplejos M2 = new MatrizComplejos("M2",3,4);    
		System.out.println(M2); 
		                      
		/*
		Crea la matriz M3 de orden 3X2 (3 renglones y 2 columnas)
		e inicializa los valores de los números complejos, tanto parte real como la imaginaria, con
		enteros positivos de forma aleatoria (Random) en el rango de 0 a 100.
		Nota: el parámetro “R+100” es un String y así debe ser manejado en el programa.
		El formato para este parámetro tiene tres componentes: 
		Letra: “R” indica que los valores se generarán de forma aleatoria; 
		Signo: “+” indica que los números serán positivos, “-“ indica que los números serán 
		negativos, “*” indica que los números serán tanto positivos como negativos;
		Rango: “100” indica que el rango es de 0 a 100, aquí podemos usar cualquier número entero.
		*/
		MatrizComplejos M3 = new MatrizComplejos("M3",3,2,"R+100");  
		System.out.println(M3);

		/*
		Crea la matriz M4 de orden 3X2 (3 renglones y 2 columnas)e inicializa los valores para 
		los números complejos, tanto parte real como la imaginaria, con enteros negativos de forma
		aleatoria (Random) en el rango de de 0 a 500.
		El nombre de la matriz es “M4”.
		*/
		MatrizComplejos M4 = new MatrizComplejos("M4",3,2,"R-500");  
		System.out.println(M4);



		/*
		Crea la matriz M5 con las mismas características de M1
		El nombre de la matriz es “M5”
		*/
		MatrizComplejos M5 = new MatrizComplejos("M5", M1);       
		
		M5.imprimir("binomio");
		M5.imprimir("polar"); 


	}
}
