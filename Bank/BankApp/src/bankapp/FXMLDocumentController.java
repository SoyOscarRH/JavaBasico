/* =======================================================
 * =======      BANK APP IN JAVA / MATERIAL DESIGN =======
 * ======================================================= 
 */


package bankapp;

import com.jfoenix.controls.JFXButton;
import java.awt.event.InputMethodEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FXMLDocumentController {

    @FXML
    private JFXButton PayButton;

    @FXML
    private JFXButton TakeOutMoneyButton;

    @FXML
    private JFXButton ReportButton;

    @FXML
    private JFXButton ActionButton;
    
    @FXML
    void handleButtonAction(ActionEvent event) {
        ActionButton.setDisable(true);
    }

}
