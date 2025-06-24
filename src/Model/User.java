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

    public static String getNama;
    private int Uid;
    private String UserEmail, Password, Username, Name, Email;

    public User(int Uid, String UserEmail, String Password, String Username, String Name, String Email) {
        this.Uid = Uid;
        this.UserEmail = UserEmail;
        this.Password = Password;
        this.Username = Username;
        this.Name = Name;
        this.Email = Email;
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
    
    public String getUsername(){
        return Username;
    }
    
    public String getName(){
        return Name;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setUsername(String Username){
        this.Username = Username;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
    
}
