package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.swing.JOptionPane;

public class tester3 {
	public static void main(String[] args) {	
		
		User user = new User(88);
		int currentScore= 43;
		UUID uuid = UUID.randomUUID();
		String gameID = uuid.toString();
		boolean scoreType = false;
		int point=1;
		String sql;
		
		try{
			DbUtilities db = new DbUtilities();
			
			//retrieve your high score from the database and report
			sql = "SELECT MAX(scoreValue) as scoreValue FROM finalscores WHERE fk_userID = " + user.getUserID() + "; ";
			String myHighScore = db.getResultSet(sql).toString();
			
			//retrieve highest score of any player from the database and report
			//sql = "SELECT lastName, firstName, MAX(scoreValue) as scoreValue FROM finalscores JOIN users ON fk_userID = userID GROUP BY lastName, firstName; ";
			sql = "SELECT firstName, lastName, MAX(scoreValue) as scoreValue FROM finalscores JOIN users ON fk_userID = userID ORDER BY firstName, lastName, scoreValue; ";
			System.out.println(sql);
			ResultSet rs = db.getResultSet(sql);
			String first, last, highScore;
			//if the result set successfully returns information, create a message dialogue
			if(rs.next()){
				first = rs.getString("firstName");
				last = rs.getString("lastName");
				highScore = rs.getString("scoreValue");
				String highScores = "Your current score: " + currentScore + " \n Your high score: " + myHighScore + "\n" +
						 "All-time high score: " + first + " " + last + ": " + highScore;
				JOptionPane.showMessageDialog(null, highScores);
			}
			
			db.closeDbConnection(); // Close connection
		}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was an error connecting to the database(recording final score).");
		}
		
		
	}
}
