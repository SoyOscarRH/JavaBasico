import java.util.*;

public class main{

	public static void main(String[] args) {

		System.out.println("== 	PUNTOS ==");
		Punto q = new Punto(1, 1, 'q');
		Punto r = new Punto(3, -1, 'r');

		System.out.println(q+" cuadrante: "+q.cuadrante());
		
		System.out.println(r+" cuadrante: "+r.cuadrante());

		Punto m = new Punto(7,-1, 'm');
		System.out.println(m+" distancia (origen): "+m.distancia());
		System.out.println(m+" distancia (a r): "+m.distancia(r));
		

		System.out.println("== 	RECTANGULO ==");
		Rectangulo N1 = new Rectangulo(new Punto(3, 3), new Punto(5, 5), "N1");
		Rectangulo N2 = new Rectangulo(new Punto(0, 0), new Punto(3, 3), "N2");
		System.out.println(N1.getUnion(N2));
		System.out.println(N1.getInteseccion(N2));


		Rectangulo R1 = new Rectangulo(new Punto(2, 3), new Punto(8, 6), "N3");
		System.out.println("El area de R1 es "+ R1.getArea());
     	Punto x = new Punto(3,3);
     	if(R1.estaDentro(x))
 			System.out.println("El punto" + x + " está adentro de " + R1);

 		Rectangulo R2 = new Rectangulo(new Punto(0, 0), new Punto(2, 9), "N4");
		System.out.println("El area de R2 es "+ R2.getArea());
     	if(R1.compara(R2) == 0)
 			System.out.println("Tienen la misma area");


 		// PARTE DEL RECTANGULO HECHO, FALTA TRIANGULO
	}
}






