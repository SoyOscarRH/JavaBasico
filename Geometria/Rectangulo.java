import java.util.*;

public class Rectangulo{
	private Punto a, b;													//Atributos
	private String nombre;												//Atributos

	Rectangulo(Punto P1, Punto P2, String nombre) {						//Constructor base
		a = P1; b = P2; this.nombre = nombre;							//Asignar valores
	}
	Rectangulo(int x1, int x2, int y1, int y2, String nombre){			//Constructor pro
		this(new Punto(x1, y1, '1'), new Punto(x2, y2, '2'), nombre);	//todo en una linea :v
	}
	Rectangulo(Rectangulo R, String nombre){this(R.a, R.b, nombre);}	//Constructor de copia


	public String toString(){return (nombre+"["+this.a+","+this.b+"]");}//Mostramos la info

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

		if (P.getX() == arrayX[1] && P.getY() == arrayY[1])
			return true;
		return false;
	}

	double getArea(){
		double area = ((a.getX()-b.getX())*(a.getY()-b.getY()));
		if (area < 0) return (area * -1);
		return area;
	}

	boolean compara(Rectangulo R){
		if (R.getArea() == this.getArea()) return true;
		return false;
	}

	void moverRectangulo(Punto P1, Punto P2){a = P1; b = P2;}

	int cuadrante(){return a.cuadrante();}
}






