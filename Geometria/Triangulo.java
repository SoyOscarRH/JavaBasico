import java.util.*;

public class Triangulo{
	private Punto a, b, c;												//Atributos
	private String nombre;												//Atributos

	Triangulo(Punto P1, Punto P2, , Punto P3, String nombre) {			//Constructor base
		a = P1; b = P2, c = P3; this.nombre = nombre;					//Asignar valores
	}

	Triangulo(Triangulo T, String nombre){
		this(R.a, R.b, R.c, nombre);									//Constructor de copia
	}					


	public String toString(){
		if (this == null) return ("[ ]");								//si no eres nada
		return (nombre+"["+this.a+","+this.b","+this.c"]");				//Mostramos la info
	}	


	Rectangulo getInteseccion(Rectangulo R){
		if ((this.estaDentro(R.a) || this.estaDentro(R.b)) == false )	//Si no comparten nada no hay interseccion
			return null;

		int[] arrayX = {a.getX(), b.getX(), R.a.getX(), R.b.getX()};	//Dame todas las x
		int[] arrayY = {a.getY(), b.getY(), R.a.getY(), R.b.getY()};	//Dame todas las y

		Arrays.sort(arrayX);											//Ordename esta (de la manera mas respetable posible)
		Arrays.sort(arrayY);											//Ordename esta (de la manera mas respetable posible)

		String nuevoNombre = "Interseccion "+nombre+" + "+R.nombre+": ";//Creemos un nuevo nombre
		Punto nuevoX = new Punto(arrayX[1], arrayY[1]);					//El primer punto es la mas pequeña de todo
		Punto nuevoY = new Punto(arrayX[2], arrayY[2]);					//y el segundo es la mas grande

		return new Rectangulo(nuevoX, nuevoY, nuevoNombre);				//Ahora regresame ese objeto, andale!
	}

	boolean estaDentro(Punto P){
		int[] arrayX = {a.getX(), b.getX(), P.getX()};					//Dame todas las x
		int[] arrayY = {a.getY(), b.getY(), P.getY()};					//Dame todas las y

		Arrays.sort(arrayX);											//Ordename esta (de la manera mas respetable posible)
		Arrays.sort(arrayY);											//Ordename esta (de la manera mas respetable posible)

		if (P.getX() == arrayX[1] && P.getY() == arrayY[1])				//si eres el de enmedio
			return true;												//wi!
		return false;													//sino : (
	}

	double getArea(){
		double area = ((a.getX()-b.getX())*(a.getY()-b.getY()));		//Dame el ares
		if (area < 0) return (area * -1);								//Si fue negativa
		return area;													//Sino todo bien
	}

	int compara(Rectangulo R){
		if (R.getArea() > this.getArea()) return -1;					//Si tu area es diferente
		if (R.getArea() < this.getArea()) return 1;						//Si tu area es diferente
		return 0;														//sino
	}

	void moverRectangulo(Punto P1, Punto P2){
		a = P1; b = P2;													//Asignar valores
		if (a.distancia() > b.distancia()){a = P2; b = P2;} 			//Si pusiste los puntos al reves
	}

	int cuadrante(){return a.cuadrante();}
}






