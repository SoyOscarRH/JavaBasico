import java.util.*;
import javafx.application.Application;                                  //Library to import
import javafx.scene.Group;                                              //Library to import
import javafx.scene.Scene;                                              //Library to import
import javafx.stage.Stage;                                              //Library to import
import javafx.scene.shape.*;                                    		//Library to import

public class Triangulo{
	private Punto a, b, c;												//Atributos
	private String nombre;												//Atributos

	Triangulo(Punto P1, Punto P2, Punto P3, String nombre) {			//Constructor base
		a = P1; b = P2; c = P3; this.nombre = nombre;					//Asignar valores
	}

	Triangulo(Triangulo T, String nombre){
		this(T.a, T.b, T.c, nombre);									//Constructor de copia
	}					


	public String toString(){
		if (this == null) return ("[ ]");								//si no eres nada
		return (nombre+"["+this.a+","+this.b+","+this.c+"]");			//Mostramos la info
	}	

	
	Polygon getDraw(){
		Polygon Resultado = new Polygon();

        Resultado.getPoints().addAll(new Double[]{
            a.getScreenX(), a.getScreenY(),
            b.getScreenX(), b.getScreenY(),
            c.getScreenX(), c.getScreenY()
        });
        
		return Resultado;
	}

}






