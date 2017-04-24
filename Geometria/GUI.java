// ****************************************************************************************
// **********************       JAVA FX - GRAPHIC INTERFACE      **************************
// ****************************************************************************************

import javafx.application.Application;                                        //Library to import
import javafx.scene.Group;                                                    //Library to import
import javafx.scene.Scene;                                                    //Library to import
import javafx.stage.Stage;                                                    //Library to import
import javafx.scene.shape.Rectangle;                                          //Library to import

public class GUI extends Application {                                        //Master class of GUI
   
   public void start(Stage Window) {                                          //@Override To Start GUI  

      Rectangulo N1 = new Rectangulo(new Punto(3, 3), new Punto(5, 5), "N1");

      Rectangle N1D = N1.getDraw();
      N1D.setOpacity(0.5);                                                    //Da opacidad

      Group root = new Group(N1D);                                            //Creating a Group object 
      Scene scene = new Scene(root, 1200, 720);                               //Creating a scene object 
      
      Window.setTitle("Geometria");                                           //Title 
      Window.setScene(scene);                                                 //Adding scene to the stage 
      Window.show();                                                          //Displaying the contents of the stage
   }      


   public static void main(String args[]){ 
      launch(); 
   } 
}