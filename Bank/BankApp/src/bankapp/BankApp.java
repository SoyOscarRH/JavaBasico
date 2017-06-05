/* =======================================================
 * =======      BANK APP IN JAVA / MATERIAL DESIGN =======
 * ======================================================= 
 */

package bankapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BankApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
    // ===== MAIN FUNCTION ==============
    public static void main(String[] args) {
        launch(args);
    }
    
}
