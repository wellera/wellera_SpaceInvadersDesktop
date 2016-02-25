package edu.pitt.is1017.spaceinvaders;

import java.util.Calendar;
import java.util.UUID;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class Tester2 {

	public static void main(String[] args) {	
	UUID uuid = UUID.randomUUID();
	String gameID = uuid.toString();

	int userID = 88;

	String lastName = "Weller";
	String firstName = "Allie";
	String email = "wellera@edc.pitt.edu";
	String password = "test123";
	int point = 1;
	boolean scoreType = false;
	int scoreValue = 1;

	//Date date = new Date();
	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	System.out.println(timeStamp );
	
	//date.getDate();

//	String sql1 = "UPDATE users SET lastName='" + lastName + "', firstName='" + firstName + "', "
//			+ "email='" + email + "', password=MD5('" + password + "') "
//			+ "WHERE userID = " + userID + "; "; 
//	
//	System.out.println(sql1);

	try{
		DbUtilities db = new DbUtilities();
		
		String sql = "INSERT INTO runningscores (gameID, scoreType, scoreValue, fk_userID, dateTimeEntered) VALUES "
				+ "('" + gameID + "', " + scoreType + ", " + scoreValue + ", '" + userID + "', '" + timeStamp + "'); ";
		
		//String sql = "INSERT INTO runningscores (gameID, scoreType, scoreValue, fk_userID, dateTimeEntered) VALUES "
		//		+ "('" + gameID + "', '" + scoreType + "', '" + scoreValue + "', '" + userID + "', '" + timeStamp + "'); ";
		System.out.println(sql);

		db.executeQuery(sql);
		db.closeDbConnection(); // Close connection (each time???)
	}
	
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "There was an error connecting to the database.");
	}
	

	
	
	
	}
}
