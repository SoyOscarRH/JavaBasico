import java.util.*;
import javafx.application.Application;                                  //Library to import
import javafx.scene.Group;                                              //Library to import
import javafx.scene.Scene;                                              //Library to import
import javafx.stage.Stage;                                              //Library to import
import javafx.scene.shape.Rectangle;                                    //Library to import


public class Rectangulo{
	private Punto a, b;													//Atributos
	private String nombre;												//Atributos

	Rectangulo(Punto P1, Punto P2, String nombre) {						//Constructor base
		a = P1; b = P2; this.nombre = nombre;							//Asignar valores
		if (a.distancia() > b.distancia()){a = P2; b = P1;} 			//Si pusiste los puntos al reves
	}
	Rectangulo(int x1, int x2, int y1, int y2, String nombre){			//Constructor pro
		this(new Punto(x1, y1, '1'), new Punto(x2, y2, '2'), nombre);	//todo en una linea :v
	}
	Rectangulo(Rectangulo R, String nombre){this(R.a, R.b, nombre);}	//Constructor de copia


	public String toString(){
		if (this == null) return ("[ ]");								//si no eres nada
		return (nombre+"["+this.a+","+this.b+"]");						//Mostramos la info
	}	

	public Punto getX(){return a;}										//Setters
	public Punto getY(){return b;}										//Setters

	Rectangulo getUnion(Rectangulo R){
		int[] arrayX = {a.getX(), b.getX(), R.a.getX(), R.b.getX()};	//Dame todas las x
		int[] arrayY = {a.getY(), b.getY(), R.a.getY(), R.b.getY()};	//Dame todas las y

		Arrays.sort(arrayX);											//Ordename esta (de la manera mas respetable posible)
		Arrays.sort(arrayY);											//Ordename esta (de la manera mas respetable posible)

		String nuevoNombre = "Union "+nombre+" + "+R.nombre+": ";		//Creemos un nuevo nombre
		Punto nuevoX = new Punto(arrayX[0], arrayY[0]);					//El primer punto es la mas pequeña de todo
		Punto nuevoY = new Punto(arrayX[3], arrayY[3]);					//y el segundo es la mas grande

		return new Rectangulo(nuevoX, nuevoY, nuevoNombre);				//Ahora regresame ese objeto, andale!
	}

	Rectangulo getInteseccion(Rectangulo R){
		boolean sePuede = false;										//Veamos si se puede
		Punto NP1 = new Punto(R.a.getX(), R.b.getY());					//Dame el nuevo punto
		Punto NP2 = new Punto(R.b.getX(), R.a.getY());					//Dame el nuevo punto


		if ( sePuede || (this.estaDentro(R.a)) ) sePuede = true;		//Compara
		if ( sePuede || (this.estaDentro(R.b)) ) sePuede = true;		//Compara
		if ( sePuede || (this.estaDentro(NP1)) ) sePuede = true;		//Compara
		if ( sePuede || (this.estaDentro(NP2)) ) sePuede = true;		//Compara

		if (!sePuede) return null;										//Si no se puede : (

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

		if (P.getX() == arrayX[0] && P.getX() == arrayY[1])				//si eres el mismo
			return false;												//wi!

		if (P.getX() == arrayX[0] && P.getX() == arrayY[1])				//si eres el mismo
			return false;												//wi!

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

	int cuadrante(){return a.cuadrante();}								//get me the String


	Rectangle getDraw(){												//Draw the Rectangle
		double cartX, cartY, h, w;										//Variables

		if (a.getX() < b.getX()) cartX = a.getX();						//Select bigger
		else cartX = b.getX();											//Select bigger

		if (a.getY() > b.getY()) cartY = a.getY();						//Select smaller
		else cartY = b.getY();											//Select smaller


		double screenX =  (20*cartX) + (1200 / 2);						//Screeen Coordenates
		double screenY = -(20*cartY) + (720 / 2);						//Screeen Coordenates

		w = Math.abs(a.getX() - b.getX()) * 20;							//Get the with
		h = Math.abs(a.getY() - b.getY()) * 20;							//Get the height

		return new Rectangle(screenX, screenY, w, h); 					//Create a Rectangle   
	}

	
}






