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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sun.rmi.runtime.Log;






public class BankApp extends Application implements Serializable {

    //*********************************************************************
    //**********************   AUXILIAR FUNCTION     **********************
    //*********************************************************************
        public static int getMoneyFromString(String Data){
            Data = Data.replace(",", "");
            Data = Data.replace(" ", "");
            Data = Data.replace("$", "");

            for (char c : Data.toCharArray()) if (!Character.isDigit(c)) return -1;

            return Integer.parseInt(Data);
        }


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

        @FXML
        private AnchorPane PromptSectionInfo;

        @FXML
        private JFXButton GetOutInfoPane;

        @FXML
        private JFXComboBox ComboBoxInfo;

        @FXML
        private Text InformationText;

        @FXML
        private JFXButton InfoAccountButton;

        @FXML
        private JFXButton CloseAndSaveData;

    //*********************************************************************
    //**********************   SET THE LAYOUT   ***************************
    //*********************************************************************

        //*************************************************
        //******   TURN BACK TO ORIGINAL LAYOUT   *********
        //*************************************************
        @FXML
        void setOriginal(ActionEvent event){

            // PAY - ADD- TAKE OUT SECTION 
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



            //SEE INFO - TRANSACTION INFO
            PromptSectionInfo.setVisible(false);
            InformationText.setText("");

            ComboBoxInfo.getItems().clear();

            //SAVE BUTTON
            CloseAndSaveData.setVisible(true);
        }




        //*************************************************
        //******       TURN LAYOUT TO SEE INFO    *********
        //*************************************************
        @FXML
        void setInfoSectionToSeeAccount(ActionEvent event) {
            String TemporalString = "No hay Información que Mostrar";

            PromptSectionInfo.setVisible(true);

            InformationText.setText("Información de la Cuenta");

            ComboBoxInfo.getItems().clear();
            ObservableList<String> TextInfo = ComboBoxInfo.getItems();
            
            if (!("Nothing".equals(NameAccount)))
                TemporalString = TestSubject.getAccount(NameAccount).toString();
            
            TextInfo.add(TemporalString);
            ComboBoxInfo.setItems(TextInfo);
        }

        //*************************************************
        //******    TURN LAYOUT TO SEE MOVEMENTS    *******
        //*************************************************
        @FXML
        void SeeMovements() {
            String TemporalString = "No hay Información que Mostrar";

            PromptSectionInfo.setVisible(true);

            InformationText.setText("Información de la Cuenta");

            ComboBoxInfo.getItems().clear();
            ObservableList<String> TextInfo = ComboBoxInfo.getItems();
            
            if (!("Nothing".equals(NameAccount))){
                ArrayList<Movement> Data = TestSubject.getAccount(NameAccount).getMovements();

                Data = new ArrayList<>(Data);
                Collections.reverse(Data);

                for (Movement m : Data) {
                    TextInfo.add(m.toString());
                }
            }
            else TextInfo.add(TemporalString);

            ComboBoxInfo.setItems(TextInfo);
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

            CloseAndSaveData.setVisible(false);

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


            String Type = TestSubject.getAccount(NameAccount).getType();
            if ("Savings".equals(Type)){
                ActionButton2.setVisible(true);
                ActionButton2.setDisable(false);
                ActionButton2.setText("Pagame Interes");
            }

            Action1ToCall = "TakeOutMoney";
            Action2ToCall = "PayMeInterest";

            CloseAndSaveData.setVisible(false);
        }





    

    //*********************************************************************
    //**********************   ACTION BUTTON    ***************************
    //*********************************************************************

    //********************************************
    //***   WHAT HAPPENS WHEN CLICK BUTTON   *****
    //********************************************

        //*************************************
        //****  ACTION 1 BUTTON  SELECTOR  ****
        //*************************************   
        @FXML
        void Action1FunctionSelector(ActionEvent event) {

            //==== ADD ACCOUNT ====
            if ("AddAccount".equals(Action1ToCall)){
                AddAccount();
                return;
            }

            //==== PAY MONEY ====
            if ("PayMoney".equals(Action1ToCall)){
                PayMoney();
                return;
            }

            //==== TAKE OUT MONEY ====
            if ("TakeOutMoney".equals(Action1ToCall)){
                TakeOutMoney();
                return;
            }
        }

        //*************************************
        //****  ACTION 2 BUTTON  SELECTOR  ****
        //*************************************   
        @FXML
        void Action2FunctionSelector(ActionEvent event) {

            //==== INTEREST  ====
            if ("PayMeInterest".equals(Action2ToCall)){
                PayMeInterest();
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
        try {
            String TemporalType = PromptInfo1.getText();
            int TemporalBalance = getMoneyFromString(PromptInfo2.getText());

            boolean CorrectData = false;
            BankAccount TemporalAccount = null;

            if (TemporalBalance <= 0) {
                TemporalType = "Nothing";
                PromptTextError.setText("No es una Cantidad Valida");
                PromptTextError.setVisible(true);
            }

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

                System.out.println("We created a: "+ TemporalAccount);

                PromptSection.setVisible(false);
                InfoAccountButton.setDisable(false);
                DateLocal.NextDay();
                DateText.setText(DateLocal.toString());

                CloseAndSaveData.setVisible(true);
                CloseAndSaveData.setText("Salva Información");
                SaveOrRetrived = "SaveInfo";
            }
            else {
                PromptTextError.setText("No es un Tipo Valido");
                PromptTextError.setVisible(true);
            }

        }
        catch (Exception e) {
            PromptTextError.setText("No es un Tipo Valido");
            PromptTextError.setVisible(true);
        }

    }


    //*************************************************
    //******       PAY MONEY TO AN ACCOUNT    *********
    //*************************************************
    void PayMoney(){

        try {
            // === GET THE DATA ===
            BankAccount ActualAccount = TestSubject.getAccount(NameAccount);

            int TemporalMoney = getMoneyFromString(PromptInfo1.getText());

            if (TemporalMoney <= 0) {
                PromptTextError.setText("No es una Cantidad Valida");
                PromptTextError.setVisible(true);
                return;
            }

            ActualAccount.AddToBankAccount(TemporalMoney, DateLocal.toString());
            DateLocal.NextDay();
            DateText.setText(DateLocal.toString());

            PromptSection.setVisible(false);
            PayButton.setDisable(false);
            TakeOutMoneyButton.setDisable(false);

            SeeMovements();
        }
        catch (Exception e) {
            PromptTextError.setText("No es un Tipo Valido");
            PromptTextError.setVisible(true);
        }
    }



    //*************************************************
    //******         TAKE OUT MY MONEY        *********
    //*************************************************
    void TakeOutMoney(){
        try {
            // === GET THE DATA ===
            BankAccount ActualAccount = TestSubject.getAccount(NameAccount);

            int TemporalMoney = getMoneyFromString(PromptInfo1.getText());

            if (TemporalMoney <= 0) {
                PromptTextError.setText("No es una Cantidad Valida");
                PromptTextError.setVisible(true);
                return;
            }

            if (ActualAccount.TakeOutMoney(TemporalMoney, DateLocal.toString())){
                DateLocal.NextDay();
                DateText.setText(DateLocal.toString());

                PromptSection.setVisible(false);
                PayButton.setDisable(false);
                TakeOutMoneyButton.setDisable(false);

                SeeMovements();
            }
            else {
                PromptTextError.setText("No es posible sacar esa Cantidad");
                PromptTextError.setVisible(true);
                return;
            }
        }
        catch (Exception e) {
            PromptTextError.setText("No es un Tipo Valido");
            PromptTextError.setVisible(true);
        }        
    }







    //*************************************************
    //******            INTEREST              *********
    //*************************************************
    void PayMeInterest(){

        // === GET THE DATA ===
        BankAccount ActualAccount = TestSubject.getAccount(NameAccount);

        ActualAccount.PayMontlyInterest();
        DateLocal.NextDay();
        DateText.setText(DateLocal.toString());

        PromptSection.setVisible(false);
        PayButton.setDisable(false);
        TakeOutMoneyButton.setDisable(false);

        SeeMovements();
    }




    //*************************************
    //****         SAVE THE INFO       ****
    //*************************************   



    /*
        De inicio regresa info de un archivo
        Sino has un boton que te permita guardar la informacion
    */
    @FXML
    void CloseAndSave(ActionEvent event) {

        if ("Retrived".equals(SaveOrRetrived)){

            try {
                FileInputStream FileStream = new FileInputStream("Client.ser");
                ObjectInputStream OutputStream = new ObjectInputStream(FileStream);
                TestSubject = (Client) OutputStream.readObject(); 
                OutputStream.close();

                FileStream = new FileInputStream("Date.ser");
                OutputStream = new ObjectInputStream(FileStream);
                DateLocal = (Date) OutputStream.readObject(); 
                OutputStream.close();

                System.out.println("Pude sacar datos");
                System.out.println(TestSubject);

                ObservableList<String> Options = ComboBoxAccount.getItems();
                BankAccount TemporalAccount = null;

                for (Map.Entry<String, BankAccount> entry: TestSubject.getAccounts().entrySet() ) {

                    System.out.println(entry.getKey()+" : "+entry.getValue());
                    TemporalAccount = entry.getValue();
                    Options.add(TemporalAccount.Type+" - "+TemporalAccount.getID());
                }
                
                ComboBoxAccount.setItems(Options);
            }
            catch (Exception e) {
                System.out.println("No pude sacar datos");
            }
        }
        else {
            try {
                //Escribe la Info
                FileOutputStream FileStream = new FileOutputStream("Client.ser");
                ObjectOutputStream OutputStream = new ObjectOutputStream(FileStream);
                OutputStream.writeObject(TestSubject);
                OutputStream.close();

                //Escribe la Info
                FileStream = new FileOutputStream("Date.ser");
                OutputStream = new ObjectOutputStream(FileStream);
                OutputStream.writeObject(DateLocal);
                OutputStream.close();
                System.out.println("Todo bien");
            } 
            catch (Exception e) {
                System.out.println("No pude guardar datos");

                System.out.println("Error when saving to file."+ e); 
            }
        }

    }












    









    /* =======================================================
     * =======                   MAIN                  =======
     * =====================================================*/
    private Client TestSubject = new Client("Willy");
    private String Action1ToCall = "Nothing";
    private String Action2ToCall = "Nothing";
    private String SaveOrRetrived = "Retrived";
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
