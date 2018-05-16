package bankapp;

import java.io.Serializable;
import java.util.*;

public class Movement implements Serializable{
	private String Concept;
	private String Author;
	private String HowMuch;
	private String DateOfAction;
	private String Balance;
	private String SpecialRow;
	private int Mode; 					


	//Constructor 
	public Movement(Map<String, String> Info){
            Concept = Author = HowMuch = DateOfAction = "No Data";
            Balance = SpecialRow = "No Data";
            Mode = 0; 

            if (Info.containsKey("Concept")) Concept = Info.get("Concept");
            if (Info.containsKey("Author")) Author = Info.get("Author");
            if (Info.containsKey("HowMuch")) HowMuch = Info.get("HowMuch");
            if (Info.containsKey("DateOfAction")) DateOfAction = Info.get("DateOfAction");
            if (Info.containsKey("Balance")) Balance = Info.get("Balance");
            if (Info.containsKey("SpecialRow")) SpecialRow = Info.get("SpecialRow");
            if (Info.containsKey("Mode")) Mode = Integer.parseInt(Info.get("Mode"));
	}


	//The only method
	public void ChangeData(Map<String, String> Info){
            if (Info.containsKey("Concept")) Concept = Info.get("Concept");
            if (Info.containsKey("Author")) Author = Info.get("Author");
            if (Info.containsKey("HowMuch")) HowMuch = Info.get("HowMuch");
            if (Info.containsKey("DateOfAction")) DateOfAction = Info.get("DateOfAction");
            if (Info.containsKey("Balance")) Balance = Info.get("Balance");
            if (Info.containsKey("SpecialRow")) SpecialRow = Info.get("SpecialRow");
            if (Info.containsKey("Mode")) Mode = Integer.parseInt(Info.get("Mode"));
	}

      int getDateComparable(){
            Date Temporal = new Date(DateOfAction);
            return Temporal.toInt();
      }

      String getDate(){
            return DateOfAction;
      }

      public String toString(){
            String Data = "";

            Data += "Concepto: "+Concept+" Autor: "+Author;
            Data += ("\nCantidad: "+HowMuch+" Actual Balance: "+Balance);
            
            return Data;
      }
}	