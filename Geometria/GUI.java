// ****************************************************************************************
// **********************       JAVA FX - GRAPHIC INTERFACE      **************************
// ****************************************************************************************

import javafx.application.Application;                                        //Library to import
import javafx.scene.Group;                                                    //Library to import
import javafx.scene.Scene;                                                    //Library to import
import javafx.stage.Stage;                                                    //Library to import
import javafx.scene.shape.*;                                                  //Library to import
import javafx.scene.paint.*;
public class GUI extends Application {                                        //Master class of GUI
   
   public void start(Stage Window) {                                          //@Override To Start GUI  
      
      // =========== PUNTOS ========================
      System.out.println("\n\n\n===  PUNTOS  ===");

      Punto a = new Punto(2, 2, 'q');
      Punto b = new Punto(6, -2, 'r');
      Punto c = new Punto(14,-2, 'm');
      
      System.out.println(a + " cuadrante: " + a.cuadrante());
      System.out.println(b + " cuadrante: " + b.cuadrante());

      System.out.println(c + " distancia (origen): " + c.distancia());
      System.out.println(a + " distancia (hasta a): " + c.distancia(a));
      

      // ======= RECTANGULO ========================
      System.out.println("\n\n\n==  RECTANGULO ==");

      Rectangulo N1 = new Rectangulo(new Punto(8, 8), new Punto(9, 10), "N1");
      Rectangulo N2 = new Rectangulo(new Punto(0, 0), new Punto(6, 6), "N2");
      Rectangulo N3 = new Rectangulo(new Punto(-4, 6), new Punto(-16, 12), "N3");
      Rectangulo N4 = new Rectangulo(new Punto(-10, -10), new Punto(-12, -12), "N4");
      Rectangulo N5 = new Rectangulo(new Punto(4, -12), new Punto(14, -10), "N3");
      Rectangulo N6 = new Rectangulo(new Punto(6, -10), new Punto(10, -14), "N4");

      System.out.println(N1.getUnion(N2));
      System.out.println(N1.getInteseccion(N2));

      System.out.println("El area de N1 es "+ N1.getArea());
      System.out.println("El area de N2 es "+ N2.getArea());

      if(N2.estaDentro(a))
         System.out.println("El punto" + a + " está adentro de " + N2);

      if(N1.compara(N2) == 0)
         System.out.println("R1 Y R2 Tienen la misma area");


      // ===== TRIANGULO ===========================
      System.out.println("\n\n\n==  TRIANGULO ==");
      Triangulo T1 = new Triangulo(new Punto(-12,-3), new Punto(-9,-9), new Punto(-8,-5), "T1");
      Triangulo T2 = new Triangulo(new Punto(-8,-3), new Punto(-12,-9), new Punto(-6,-5), "T2");
      System.out.println(T1);

      // =================================================
      // ================ DRAW ALL =======================
      // =================================================
      Rectangle N1D = N1.getDraw();                                           //Get an Object                
      Rectangle N2D = N2.getDraw();                                           //Get an Object
      Rectangle N3D = N3.getDraw();                                           //Get an Object
      Rectangle N4D = N4.getDraw();                                           //Get an Object
      Rectangle N1U2D = N1.getUnion(N2).getDraw();                            //Get an Object
      Rectangle N5D = N5.getDraw();                                           //Get an Object
      Rectangle N6D = N6.getDraw();                                           //Get an Object
      Rectangle N5I6D = N5.getInteseccion(N6).getDraw();                      //Get an Object

      Circle aD = a.getDrawCircle();
      Circle bD = b.getDrawCircle();
      Circle cD = c.getDrawCircle();
      
      Polygon T1D = T1.getDraw();                                              //Get an Object
      Polygon T2D = T2.getDraw();                                              //Get an Object 

      N1D.setOpacity(0.5);                                                    //Gives Opacity
      N2D.setOpacity(0.5);                                                    //Gives Opacity
      N3D.setOpacity(0.5);                                                    //Gives Opacity
      N4D.setOpacity(0.5);                                                    //Gives Opacity
      N1U2D.setOpacity(0.2);                                                  //Gives Opacity
      N5D.setOpacity(0.3);                                                    //Gives Opacity
      N6D.setOpacity(0.3);                                                    //Gives Opacity
      N5I6D.setOpacity(0.8);                                                  //Gives Opacity
      
      aD.setOpacity(0.8);                                                     //Gives Opacity
      bD.setOpacity(0.8);                                                     //Gives Opacity
      cD.setOpacity(0.8);                                                     //Gives Opacity

      T1D.setOpacity(0.5);                                                    //Gives Opacity
      T2D.setOpacity(0.5);                                                    //Gives Opacity
      
      aD.setFill(Color.RED);                                                  //Color
      bD.setFill(Color.RED);                                                  //Color
      cD.setFill(Color.RED);                                                  //Color

      N1D.setFill(Color.RED);                                                 //Color
      N2D.setFill(Color.GREEN);                                               //Gives Opacity
      N3D.setFill(Color.GREY);                                                //Color
      N4D.setFill(Color.BLUE);                                                //Gives Opacity
      N1U2D.setFill(Color.YELLOW);                                            //Gives Opacity
      N5D.setFill(Color.YELLOW);                                              //Color
      N6D.setFill(Color.BLUE);                                                //Gives Opacity
      N5I6D.setFill(Color.BLACK);                                             //Gives Opacity

      T1D.setFill(Color.RED);                                                 //Gives Opacity
      T1D.setFill(Color.BLUE);                                                //Gives Opacity

      if(N2.estaDentro(a))
         aD.setFill(Color.GREEN);







      // ================  STANDARD FOR ALL GRAPHICS ====================

      Group Screen = new Group();                                             //Creating a Group object 

      // ******
      Screen.getChildren().addAll(T1D, T2D);                                  //Add to scene
      Screen.getChildren().addAll(N1D,N2D,N1U2D,N3D,N4D,N5D,N6D,N5I6D);       //Add to scene
      Screen.getChildren().addAll(aD, bD, cD);                                //Add to scene
      
      // *****

      for (int i = 0; i < 1200; i += 20){                                     //Lets cover all the screen
         Line MiniLineA = new Line(0, i, 1200, i);                            //Create Line
         MiniLineA.setOpacity(0.2);                                           //set Opacity
         Line MiniLineB = new Line(i, 0, i, 720);                             //Create Line
         MiniLineB.setOpacity(0.2);                                           //set Opacity
         Screen.getChildren().addAll(MiniLineA, MiniLineB);                   //Add to Screen
      }

      Line CoordenadaX = new Line(0, 360, 1200, 360);                         //System coordinate  
      Line CoordenadaY = new Line(600, 0, 600, 720);                          //System coordinate

      Screen.getChildren().add(CoordenadaX);                                  //Add to scene
      Screen.getChildren().add(CoordenadaY);                                  //Add to scene


      // ========= CREATE A SCENE ===================

      Scene Scene = new Scene(Screen, 1200, 720);                             //Creating a scene object 
      Window.setTitle("Geometria");                                           //Title 
      Window.setScene(Scene);                                                 //Adding scene to the stage 
      Window.show();                                                          //Displaying the contents of the stage
   }      


   public static void main(String args[]){ 
      launch(); 
   } 
}

