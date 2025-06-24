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

    public static User validasiLogin(String UserEmail, String Password){
        Connector Conn = new Connector();
        Statement Data = Conn.getStatement();
        
        try {
        String lquery = (
                "SELECT * FROM user WHERE (Username = '" + UserEmail + "' OR Email = '" + UserEmail + "') AND Password = '"+ Password + "'");
        
        ResultSet rSet = Data.executeQuery(lquery);
            if(rSet.next()){
                int Uid = rSet.getInt("Idu");
                String Username = rSet.getString("Username");
                String Name = rSet.getString("Nama");
                String Email = rSet.getString("Email");

                return new User(Uid, UserEmail, Password, Username, Name, Email);
            }
            
        } catch (SQLException ex) {
            System.out.println("sqlexep"+ex);
        }
            return null;
        
    }
    
    public static boolean register(String Nama, String User, String Email, String Password){
        Connector Conn = new Connector();
        Statement Data = Conn.getStatement();
        
        try{
            if(!checkUserEmail(User, Email)){
                String query = (
                        "INSERT INTO user(Nama, Username, Email, Password) "
                        + "VALUES ('" + Nama + "','" + User + "','" + Email + "','" + Password + "')"
                );
                
                Data.executeUpdate(query);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("sqlexep"+ex);
        }
        return false;
    }



    public static boolean checkUserEmail(String User, String Email){
        Connector Conn = new Connector();
        Statement Data = Conn.getStatement();
        
        try {
        String rquery = (
                "SELECT * FROM user WHERE Username = '" + User + "' OR Email = '" + Email + "'"
                );
        
        ResultSet rSet = Data.executeQuery(rquery);
            if(!rSet.next()){
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("sqlexep"+ex);
        }
        
        return true;  
    }
}