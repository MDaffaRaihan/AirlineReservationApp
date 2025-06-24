/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Reistein
 */
public class Filter {
    private String TPenerbangan, MPenerbangan, TglPenerbangan;
       
    public void setTPenerbangan(String TPenerbangan) {
        this.TPenerbangan = TPenerbangan;
    }
    
    public void setMPenerbangan(String MPenerbangan) {
        this.MPenerbangan = MPenerbangan;
    }
    
    public void setTglPenerbangan(String TglPenerbangan) {
        this.TglPenerbangan = TglPenerbangan;
    }
    
    public String getTPenerbangan(){
        return TPenerbangan;
    }
    
    public String getMPenerbangan(){
        return MPenerbangan;
    }
    
    public String getTglPenerbangan(){
        return TglPenerbangan;
    }
}
