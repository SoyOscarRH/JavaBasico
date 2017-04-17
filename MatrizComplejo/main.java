public class main {
	public static void main(String[] args) {

		/*
		Crea la matriz M1 de orden 3X3 (3 renglones y 3 columnas) inicializando todos sus 
		elementos al valor de 1. El nombre de la matriz es “M1”. 
		Tanto la parte real como la imaginaria de los complejos tienen el valor de 1
		*/
		System.out.println("NUEVA MATRIZ");
		MatrizComplejos M1 = new MatrizComplejos("M1",3);
		System.out.println(M1);

		/*
		Crea la matriz M2 de orden 3X4 (3 renglones y 4 columnas)
		e inicializa todos sus valores a 1. El nombre de la matriz es “M2”
		Tanto la parte real como imaginaria de los complejos tienen el valor de 1
		*/
		System.out.println("NUEVA MATRIZ");
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
		System.out.println("NUEVA MATRIZ");
		MatrizComplejos M3 = new MatrizComplejos("M3",3,2,"R+100");  
		System.out.println(M3);

		/*
		Crea la matriz M4 de orden 3X2 (3 renglones y 2 columnas)e inicializa los valores para 
		los números complejos, tanto parte real como la imaginaria, con enteros negativos de forma
		aleatoria (Random) en el rango de de 0 a 500.
		El nombre de la matriz es “M4”.
		*/
		System.out.println("NUEVA MATRIZ");
		MatrizComplejos M4 = new MatrizComplejos("M4",3,2,"R-500");  
		System.out.println(M4);



		/*
		Crea la matriz M5 con las mismas características de M1
		El nombre de la matriz es “M5”
		*/
		System.out.println("NUEVA MATRIZ e imprimir");
		MatrizComplejos M5 = new MatrizComplejos("M5", M1);       
		
		M5.imprimir("binomio");
		M5.imprimir("polar"); 

		// Suma las matrices M3 y M4 ((siempre y cuando el orden de ambas matrices sea válido, de 
		// otra forma la operación no es realizada), el resultado queda en M3.
		// La operación matemática es: M3= M3 + M4
		System.out.println("SUMA");
		System.out.println(M3);
		System.out.println(M4);
		M3.sumar(M3,M4);
		System.out.println("Resultado: "+M3);

		/*
		Suma las matrices M1 y M2, y el resultado queda en M2 (siempre y cuando el orden de 
		ambas matrices sea válido, de otra forma la operación no es realizada).
		La operación matemática es: M1= M1 + M2
		*/
		System.out.println("SUMA");
		System.out.println(M1);
		System.out.println(M2);
		M1.sumar(M2);
		System.out.println("Resultado: "+M1);

		/*
		Suma la matriz M3 con M4, el resultado se suma con el contenido de M2. El resultado queda
		en M2.
		Equivalente a M2 = M2 + M3 + M4
		*/
		System.out.println("OTRA SUMA");
		System.out.println("Vamos a operacion");
		System.out.println(M4);
		System.out.println(M3);
		System.out.println(M2);
		//M2.sumar(M3.sumar(M4));					//Podria hacer esto, pero M2 no tiene tamano
		System.out.println("Resultado: "+M3.sumar(M4));		//Pero M3 y M4 si que puede

		/* 
		Hace la resta de M2 menos M1, dejando el resultado en M2 (siempre y cuando el orden de ambas 
		matrices sea válido, de otra forma la operación no es realizada).
		M2 = M2 - M1;
		*/
		System.out.println("RESTA");
		System.out.println(M2);
		M2.restar(M2); 
		System.out.println("Resultado: "+M2);

		/*
		Realiza la multiplicación de M5 por M6; el resultado es asignado a la matriz MM 
		Esta operación debe revisar que el producto sea válido, es decir, el número de 
		de columnas de la primera matriz (M5) debe coincidir con el número de renglones de la
		segunda matriz (M6). 
		La matriz resultante MM tiene el orden de los renglones de M5 por las columnas de M6, esto es 
		4X4
		*/

		/*
		Se crea la matriz M6 de 3 renglones por 4 columnas, e inicializa los valores
		para los números complejos, tanto parte real como la imaginaria, con enteros
		positivos de forma aleatoria (Random) en el 1 y 100
		*/

		System.out.println("NUEVA MATRIZ");

		MatrizComplejos M6 = new MatrizComplejos("M6", 3,4,"R+100");
		System.out.println(M6);

		MatrizComplejos MM = new MatrizComplejos("MM", 2,2,"R+2");
		System.out.println(MM);

		MatrizComplejos MM2 = new MatrizComplejos("MM2", 2,2,"R+2");
		System.out.println(MM2);

		MatrizComplejos MM3 = MM2.multiplicar(MM);
		System.out.println(MM3);


		/* 
		Se obtiene la matriz transpuesta de M3. Por lo tanto, la matriz M3 queda modificada, se
		convierte en la matriz transpuesta de sí misma.
		Nota: no es válido imprimir la matriz invirtiendo las columnas por los renglones, la
		matriz debe quedar modificada como su transpuesta.
		*/

		System.out.println("transpuesta");

		System.out.println(M3);
		System.out.println(M3.transpuesta());

		System.out.println("Espiral");
		System.out.println(M3);
		M3.Espiral();

		// Imprime cálculos: el valor máximo, el valor mínimo, el promedio
		System.out.println("\n\nCALCULOS");
		System.out.println(M4);
		M4.calculos();

		// El método equals prueba si dos matrices son iguales tanto en orden como en contenido.
		// Devuelve el valor true si son iguales, devuelve el valor false en caso contrario.
		System.out.println("\n\nEquals");
		boolean b = M2.equals(M2);           
		if (b) 
		     System.out.println("M2 es igual que M2");
		else
		    System.out.println("M2 no es igual a M2");

}

}
