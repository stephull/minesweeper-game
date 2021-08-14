/*
    Database.java
    Test code for SQL queries for keeping track of user's data and all scores.
*/

import java.sql.*;

public class Database extends DataHelp {
    
    protected static final String LINK = "jdbc:mysql://localhost/MineSQL";
    protected static final String USER = "guest";
    protected static final String PASS = "guest123";
    protected static final String QUERY = "SELECT Score, User, Difficulty, Mode, Total Wins, ID FROM usersscores.score";

    Database() {
        try (
            Connection co = DriverManager.getConnection(LINK, USER, PASS);
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(QUERY);
        ) {
            while (rs.next()) {
                System.out.println("Score: " + rs.getInt("Score"));
                System.out.println("User: " + rs.getString("User"));
                System.out.println("Difficulty: " + rs.getString("Difficulty"));
                System.out.println("Mode: " + rs.getString("Mode"));
                System.out.println("Total Wins: " + rs.getInt("Total Wins"));
                System.out.println("ID: " + rs.getInt("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
}

// SOURCE:  https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm 
