/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;

/**
 *
 * @author Reistein
 */
public class Connector {
    private Connection Conn;
    private Statement Data;

    private String db = "jdbc:mysql://localhost/airlinereserveapp";
    private String db_user = "root";
    private String db_pass = "root";
    
    public Connector(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conn = DriverManager.getConnection(db,db_user,db_pass);
            Data = this.Conn.createStatement();
            System.out.println("Pesan: Koneksi Berhasil!");
            
        } catch (Exception e) {
            System.out.println("Pesan: Koneksi Gagal!" + e);
            
        }
    }
    
    public Connection getConnection(){
        return Conn;
    }
    
    public Statement getStatement(){
        return Data;
    }

}
