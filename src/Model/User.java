/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Reistein
 */
public class User {
    private final int Uid;
    private final String UserEmail, Password;

    public User(int Uid, String UserEmail, String Password) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.Password = Password;
    }
    
    public int getUid(){
        return Uid;
    }
    
    public String getUserEmail(){
        return UserEmail;
    }
    
    public String getUserPassword(){
        return Password;
    }
    
}
