import java.util.*;

public class Date{


	public static String Now(){
		return "1/1/70";
	}

	private int day, month, year;								//You know, this is a date

	Date(int day, int month, int year){							//======= CONSTRUCTOR =============
		this.day = day;this.month = month;this.year = year;		//You know the most boring constructor
		FixInput();
	}

	Date(String StrDate){										//======= CONSTRUCTOR =============
		StrDate.replaceAll("\\s+", "");							//Remove spaces
		StrDate.replaceAll("-", "/");							//Please use this!

		for (int i = 0, n, temporal; i < 2; i++) {				//For the day and month
			if (StrDate.charAt(1) == '/') n = 1;				//You say somethign like 1
			else n = 2;											//You say somethign like 01

			temporal=Integer.parseInt(StrDate.substring(0,n));	//Get the temporal
			if (i == 0) day = temporal;							//Choose were to put it!
			else month = temporal;								//Choose were to put it!

			StrDate = StrDate.substring(n+1);					//Remove the used info
		}

		year = Integer.parseInt(StrDate);						//Now all is the year
		FixInput();												//Fix the input
	}

	public void ChangeDate(int day, int month, int year){		//======= SETTER ==================
		this.day = day; this.month = month; this.year = year;	//You know, the most boring setter
		FixInput();
	}

	public String toString(){									//======= TOSTRING ================
		return "("+day+"/"+month+"/"+year+")";					//The most boring to string
	}

	private void FixInput(){									//======= FUN FUNCTION ============
		if (day > 31) day = 31;									//If you stupid put it wrong
		if (month > 12) month = 12;								//If you stupid put it wrong

		if (year > 0 && year < 18) year += 2000;				//If you are refering to the XXI century
		else if (year > 0 && year > 17) year += 1900;			//If you are refering to the XIX century
	}

}