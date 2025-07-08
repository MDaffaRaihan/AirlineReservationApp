/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Filter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reistein
 */


public class MaskapaiController {
    Connector Conn = new Connector();
    Statement Data = Conn.getStatement();
    DefaultTableModel dtm = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
    };
    DefaultTableModel udtm = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
    };
    
    public DefaultTableModel maincreatetable() {
        dtm.addColumn("No. Maskapai");
        dtm.addColumn("Nama Maskapai");
        dtm.addColumn("Tujuan");
        dtm.addColumn("Tgl Berangkat");
        dtm.addColumn("Jam Berangkat");
        dtm.addColumn("Harga");
        //dtm.addColumn("No. Penerbangan");     
        
        return this.dtm;
    }
    public DefaultTableModel usercreatetable() {
        //udtm.addColumn("No. Maskapai");
        udtm.addColumn("No. Penerbangan");     
        udtm.addColumn("Nama Maskapai");
        udtm.addColumn("Tujuan");
        udtm.addColumn("Tgl Berangkat");
        udtm.addColumn("Jam Berangkat");
        udtm.addColumn("Nama");
        udtm.addColumn("Waktu Pembelian");
        
        return this.udtm;
    }
    
    public void tampilkanPenerbangan() {
        try {
            //Clear dtm/tabel sementaranya
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            
            //SQL Query
            String query = "SELECT * FROM maskapai";
            
            //eksekusi
            //untuk SELECT --> executeQuery
            ResultSet rSet = Data.executeQuery(query);
            
            //hasil query ditampilkan di dtm
            while(rSet.next()) {
                Object[] obj = new Object[6];
                //getString harus sesuai dengan kolom di db
                obj[0] = rSet.getString("Idm");
                obj[1] = rSet.getString("Maskapai");
                obj[2] = rSet.getString("Tujuan");
                obj[3] = rSet.getString("Tgl_Keberangkatan");
                obj[4] = rSet.getString("Jam_Keberangkatan");
                obj[5] = "Rp. "+rSet.getString("Harga");
                //obj[6] = rSet.getString("Nopen");
                
                dtm.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Query Gagal");
        }
    }
    
    public void cariTiket(String TPenerbangan, String MPenerbangan, String TglPenerbangan) {
        try {
            Filter filt = new Filter();
            
            filt.setTPenerbangan(TPenerbangan);
            filt.setMPenerbangan(MPenerbangan);
            filt.setTglPenerbangan(TglPenerbangan);
            
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            
            String query = "SELECT * FROM maskapai WHERE ('" + TPenerbangan + "' = '' OR Tujuan = '" + TPenerbangan + 
                    "') AND ('" + MPenerbangan + "' = '' OR Maskapai = '" + MPenerbangan + "') AND Tgl_Keberangkatan >= '" + TglPenerbangan + "'";
            ResultSet rSet = Data.executeQuery(query);
            
            while(rSet.next()) {
                Object[] obj = new Object[6];
                //getString harus sesuai dengan kolom di db
                obj[0] = rSet.getString("Idm");
                obj[1] = rSet.getString("Maskapai");
                obj[2] = rSet.getString("Tujuan");
                obj[3] = rSet.getString("Tgl_Keberangkatan");
                obj[4] = rSet.getString("Jam_Keberangkatan");
                obj[5] = "Rp. "+rSet.getString("Harga");
                //obj[6] = rSet.getString("Nopen");
                
                dtm.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void pesanTiket(String Idm, String Maskapai, String Tujuan, String Tgl_Penerbangan, String Jam_Penerbangan, String Nopen, String User, String Namapen) {
        Connector Conn = new Connector();
        Statement Data = Conn.getStatement();
        
        try {
            String query = (
                    "INSERT INTO tiket (Idm, Maskapai, Tujuan, Tgl_Keberangkatan, Jam_Keberangkatan, Nopen, User, Nama_Penumpang) "
                    + "VALUES ('" + Idm + "','" + Maskapai + "','" + Tujuan + "','" + Tgl_Penerbangan + "','" + Jam_Penerbangan + "','" + Nopen + "','"
                    + User + "','" + Namapen + "')"
            );
            
            //eksekusi
            //untuk SELECT --> executeQuery
            Data.executeUpdate(query);
            
        } catch (Exception e) {
            System.out.println("Query Pesan Tiket Gagal!\n" + e);
        }
        
    }
    
    public void tampilkanTiket(String User) {
        try {
            //Clear dtm/tabel sementaranya
            udtm.getDataVector().removeAllElements();
            udtm.fireTableDataChanged();
            
            //SQL Query
            String query = "SELECT * FROM tiket WHERE User = '" + User + "'"
                    + "ORDER BY Waktu_Pemesanan DESC";
            
            //eksekusi
            //untuk SELECT --> executeQuery
            ResultSet rSet = Data.executeQuery(query);
            
            //hasil query ditampilkan di dtm
            while(rSet.next()) {
                Object[] objt = new Object[7];
                //getString harus sesuai dengan kolom di db
                //objt[0] = rSet.getString("Idm");
                objt[0] = rSet.getString("Nopen");
                objt[1] = rSet.getString("Maskapai");
                objt[2] = rSet.getString("Tujuan");
                objt[3] = rSet.getString("Tgl_Keberangkatan");
                objt[4] = rSet.getString("Jam_Keberangkatan");
                objt[5] = rSet.getString("Nama_Penumpang");
                objt[6] = rSet.getString("Waktu_Pemesanan");
                
                udtm.addRow(objt);
            }
        } catch (Exception e) {
            System.out.println("Query Gagal" +e);
        }
    }
}
