/* =======================================================================================
 * ======================      BANK APP IN JAVA / MATERIAL DESIGN    =====================
 * =====================================================================================*/

package bankapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;






public class BankApp extends Application {

    /* ====================================================================
    * ===================        JAVA FX VARIABLES       ==================
    * ==================================================================*/

        @FXML
        private JFXButton PayButton;

        @FXML
        private JFXComboBox ComboBoxAccount;

        @FXML
        private JFXButton TakeOutMoneyButton;

        @FXML
        private AnchorPane PromptSection;

        @FXML
        private JFXButton ActionButton2;

        @FXML
        private JFXButton ActionButton1;

        @FXML
        private JFXTextField PromptInfo1;

        @FXML
        private Text PromptText1;

        @FXML
        private JFXButton BorrarSelection;

        @FXML
        private JFXTextField PromptInfo2;

        @FXML
        private Text PromptText2;

        @FXML
        private Text MoneyText1;

        @FXML
        private JFXButton AddAccount;

        @FXML
        private Text PromptTextError;

        @FXML
        private Text DateText;


    //*********************************************************************
    //**********************   SET THE LAYOUT   ***************************
    //*********************************************************************

        //*************************************************
        //******   TURN BACK TO ORIGINAL LAYOUT   *********
        //*************************************************
        @FXML
        void setOriginal(ActionEvent event){
            PromptSection.setVisible(false);

            PromptInfo1.setText("");
            PromptInfo2.setText("");
            PromptText1.setText("");
            PromptText2.setText("");
            PromptInfo1.setVisible(false);
            PromptInfo1.setVisible(false);
            ActionButton1.setText("");
            ActionButton2.setText("");
            ActionButton2.setVisible(false);
            ActionButton1.setVisible(false);
            PromptTextError.setVisible(false);

            if ("Nothing".equals(NameAccount)){
                TakeOutMoneyButton.setDisable(true);
                PayButton.setDisable(true);
            }
            else {
                TakeOutMoneyButton.setDisable(false);
                PayButton.setDisable(false);
            }
        }


        //*************************************************
        //******       TURN LAYOUT TO PAY         *********
        //*************************************************
        @FXML
        void setMoneySectionToPay(ActionEvent event) {
            TakeOutMoneyButton.setDisable(true);
            PayButton.setDisable(true);

            PromptSection.setVisible(true);

            PromptInfo1.setText("");
            PromptInfo2.setText("");
            PromptInfo1.setVisible(true);
            PromptInfo2.setVisible(false);

            PromptText1.setText("Cantidad: ");
            PromptText2.setText("");
            PromptText1.setVisible(true);
            PromptText2.setVisible(false);


            ActionButton1.setText("Pagar");
            ActionButton2.setText("");
            ActionButton1.setVisible(true);
            ActionButton2.setVisible(false);
            PromptTextError.setVisible(false);

            Action1ToCall = "PayMoney";
        }


        //*************************************************
        //******       TURN LAYOUT TO TAKE OUT      *******
        //*************************************************
        @FXML
        void setMoneySectionToTakeOut(ActionEvent event) {
            TakeOutMoneyButton.setDisable(true);
            PayButton.setDisable(true);

            PromptSection.setVisible(true);

            PromptInfo1.setText("");
            PromptInfo2.setText("");
            PromptInfo1.setVisible(true);
            PromptInfo2.setVisible(false);

            PromptText1.setText("Cantidad: ");
            PromptText2.setText("");
            PromptText1.setVisible(true);
            PromptText2.setVisible(false);


            ActionButton1.setText("Sacar");
            ActionButton2.setText("");
            ActionButton1.setVisible(true);
            ActionButton2.setVisible(false);
            PromptTextError.setVisible(false);

            Action1ToCall = "TakeOutMoney";
        }


        //*************************************************
        //******       TURN LAYOUT TO ADD ACCOUNT     *****
        //*************************************************
        @FXML
        void setAddAccount(ActionEvent event) {
            TakeOutMoneyButton.setDisable(true);
            PayButton.setDisable(true);
            
            PromptSection.setVisible(true);
            
            PromptInfo1.setText("");
            PromptInfo2.setText("");
            PromptInfo1.setVisible(true);
            PromptInfo2.setVisible(true);


            PromptText1.setVisible(true);
            PromptText2.setVisible(true);
            PromptText1.setText("Tipo Cuenta: ");
            PromptText2.setText("Saldo Inicial: ");

            ActionButton1.setText("Añadir Cuenta");
            ActionButton1.setVisible(true);
            ActionButton2.setVisible(false);

            Action1ToCall = "AddAccount";
        }
        






    //*********************************************************************
    //**********************   ACTION BUTTON    ***************************
    //*********************************************************************

    //********************************************
    //***   WHAT HAPPENS WHEN CLICK BUTTON   *****
    //********************************************

        //*************************************
        //****   ACTION BUTTON  SELECTOR  *****
        //*************************************   
        @FXML
        void Action1FunctionSelector(ActionEvent event) {

            //==== ADD ACCOUNT ====
            if ("AddAccount".equals(Action1ToCall)){
                AddAccount();
                return;
            }
        }

        //**************************************
        //*****   CHECKBOX  SELECTOR   *********
        //************************************** 
        @FXML
        void setAccount(ActionEvent event) {
            String Seleccionado = (String) ComboBoxAccount.getValue();
            
            Seleccionado = Seleccionado.substring(Seleccionado.length() - 4);
            NameAccount = Seleccionado;

            PayButton.setDisable(false);
            TakeOutMoneyButton.setDisable(false);
        }
        




    
    //*************************************************
    //******      ADD A NEW ACCOUNT           *********
    //*************************************************
    void AddAccount(){

        // === GET THE DATA ===
        String TemporalType = PromptInfo1.getText();
        String MaybeBalance = PromptInfo2.getText();

        if (MaybeBalance.charAt(0) == '$')
            MaybeBalance = MaybeBalance.substring(1); 
        int TemporalBalance = Integer.parseInt(MaybeBalance);

        boolean CorrectData = false;
        BankAccount TemporalAccount = null;


        // === GET ALL POSIBLE ACCOUNTS ===
        if  ("Ahorros".equals(TemporalType)){
            CorrectData = true;
            TemporalAccount = new AccountSavings(TemporalBalance, DateLocal, 0.2);
        }


        // === ADD TO THE ACCOUNT NOW ===
        if (CorrectData){
            TestSubject.AddAccount(TemporalAccount);
            PromptTextError.setVisible(false);

            ObservableList<String> Options = ComboBoxAccount.getItems();
            Options.add(TemporalType+" - "+TemporalAccount.getID());
            ComboBoxAccount.setItems(Options);

            PromptSection.setVisible(false);
        }
        else {
            PromptTextError.setText("No es un Tipo Valido");
            PromptTextError.setVisible(true);
        }
    }























    









    /* =======================================================
     * =======                   MAIN                  =======
     * =====================================================*/
    private Client TestSubject = new Client("Willy");
    private String Action1ToCall = "Nothing";
    private String NameAccount = "Nothing";
    private Date DateLocal = new Date(Date.Now());


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        System.out.println(DateLocal);
    }

    // ===== MAIN FUNCTION ==============
    public static void main(String[] args) {
        launch(args);
    }
    
}
