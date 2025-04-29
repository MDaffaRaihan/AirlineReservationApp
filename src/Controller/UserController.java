/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import java.sql.*;

/**
 *
 * @author Reistein
 */
public class UserController {


    public static User validateLogin(String UserEmail, String Password){
        Connector Conn = new Connector();
        Statement Data = Conn.getStatement();
        
        try {
        String query = (
                "SELECT * FROM user WHERE Username = '" + UserEmail + "' OR Email = '" + UserEmail + "' AND Password = '"+ Password + "'");
        
        ResultSet rSet = Data.executeQuery(query);
            if(rSet.next()){
                int Uid = rSet.getInt("Idu");

                return new User(Uid, UserEmail, Password);
            }
        } catch (SQLException ex) {
            System.out.println("sqlexep"+ex);
        }
        
        return null;  
    }

}
