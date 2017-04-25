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
      
      // =========== MAIN ==========================
      System.out.println("===  PUNTOS  ===");
      Punto q = new Punto(1, 1, 'q');
      Punto r = new Punto(3, -1, 'r');

      System.out.println(q+" cuadrante: "+q.cuadrante());
      
      System.out.println(r+" cuadrante: "+r.cuadrante());

      Punto m = new Punto(7,-1, 'm');
      System.out.println(m+" distancia (origen): "+m.distancia());
      System.out.println(m+" distancia (a r): "+m.distancia(r));
      

      // ======= RECTANGULO ========================

      System.out.println("==  RECTANGULO ==");
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




      // ===== TRIANGULO ===========================
      Triangulo T1 = new Triangulo(new Punto(-1,-1), new Punto(-5,-5), new Punto(-2,-5), "T1");


      // =================================================
      // ================ DRAW ALL =======================
      // =================================================
      Rectangle N1D = N1.getDraw();                                           //Get an Object                
      Rectangle N2D = N2.getDraw();                                           //Get an Object
      Rectangle N1U2D = N1.getUnion(N2).getDraw();                            //Get an Object
      Rectangle R1D = R2.getDraw();                                           //Get an Object
      Rectangle R2D = R1.getUnion(N2).getDraw();                              //Get an Object
      Circle rD = r.getDrawCircle();
      Circle qD = q.getDrawCircle();
      Circle mD = x.getDrawCircle();
      Circle xD = x.getDrawCircle();
      Polygon T1D = T1.getDraw();                                              //Get an Object                


      R1D.setOpacity(0.5);                                                    //Gives Opacity
      R2D.setOpacity(0.5);                                                    //Gives Opacity
      N1D.setOpacity(0.5);                                                    //Gives Opacity
      N2D.setOpacity(0.5);                                                    //Gives Opacity
      N1U2D.setOpacity(0.2);                                                  //Gives Opacity
      xD.setOpacity(0.8);                                                     //Gives Opacity
      rD.setOpacity(0.8);                                                     //Gives Opacity
      qD.setOpacity(0.8);                                                     //Gives Opacity
      T1D.setOpacity(0.8);                                                    //Gives Opacity
      
      xD.setFill(Color.RED);                                                  //Color
      rD.setFill(Color.RED);                                                  //Color
      qD.setFill(Color.RED);                                                  //Color

      N1D.setFill(Color.RED);                                                 //Color
      N2D.setFill(Color.GREEN);                                               //Gives Opacity
      R1D.setFill(Color.GREY);                                                //Color
      R2D.setFill(Color.BLUE);                                                //Gives Opacity
      N1U2D.setFill(Color.YELLOW);                                            //Gives Opacity

      T1D.setFill(Color.RED);                                                 //Gives Opacity


      // ================  STANDARD FOR ALL GRAPHICS ====================

      Group Screen = new Group();                                             //Creating a Group object 

      // ******
      Screen.getChildren().addAll(T1D, R1D, R2D, N1D, N2D, N1U2D, xD, rD, qD);     //Add to scene
      // *****

      for (int i = 0; i < 1200; i += 10){                                     //Lets cover all the screen
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

