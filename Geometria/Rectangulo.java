import java.util.*;

public class Rectangulo{
	private Punto a, b;													//Atributos
	private String nombre;												//Atributos

	Rectangulo(Punto a, Punto b, String nombre) {						//Constructor base
		this.a = a; this.b = b; this.nombre = nombre;					//Asignar valores
	}
	Rectangulo(int x1, int x2, int y1, int y2, String nombre){			//Constructor pro
		this(new Punto(x1, y1, '1'), new Punto(x2, y2, '2'), nombre);	//todo en una linea :v
	}
	Rectangulo(Rectangulo R, String nombre){this(R.a, R.b, nombre);}	//Constructor de copia


	public Punto getX(){return a;}										//Setters
	public Punto getY(){return b;}										//Setters




	public static void main(String[] args) {
		Punto q = new Punto(1, 1, 'q');
		Punto r = new Punto(3, -1, 'r');

		System.out.println(q.cuadrante());
		System.out.println(r.cuadrante());
	}
}






