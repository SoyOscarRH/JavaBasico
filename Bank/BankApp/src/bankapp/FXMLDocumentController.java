/* =======================================================
 * =======      BANK APP IN JAVA / MATERIAL DESIGN =======
 * ======================================================= 
 */


package bankapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import java.awt.event.InputMethodEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class FXMLDocumentController {

    @FXML
    private JFXButton PayButton;

    @FXML
    private JFXButton TakeOutMoneyButton;

    @FXML
    private JFXButton ReportButton;

    @FXML
    private Slider MoneySelector;

    @FXML
    private Text MoneyText;
    
    @FXML
    private JFXButton ActionButton;

    @FXML
    private AnchorPane MoneySection;
    
    @FXML
    void setMoneySectionToPay(ActionEvent event) {
        TakeOutMoneyButton.setDisable(true);
        PayButton.setDisable(true);
        MoneySection.setVisible(true);
        
        ActionButton.setText("Pagar");
    }
    

    @FXML
    void setMoneySectionToTakeOut(ActionEvent event) {
        TakeOutMoneyButton.setDisable(true);
        PayButton.setDisable(true);
        MoneySection.setVisible(true);
        
        ActionButton.setText("Cobrar");
    }

}
