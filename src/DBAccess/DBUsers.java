package DBAccess;

import DBAccess.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUsers {

    public  static boolean checkUser(String username, String password){
        String sql = "SELECT * FROM users WHERE User_Name = '"+ username +"' AND Password = '" + password + "'";
        boolean checker = false;
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //while(rs.next()){
            //    System.out.println("User " + username + " authenticated.");
            //}
            if(rs.next()){
                System.out.println("User " + username + " authenticated.");
                checker = true;
            }
            else{
                System.out.println("Username and Password not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checker;
    }
}
