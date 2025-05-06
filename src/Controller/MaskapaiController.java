/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
    
    public DefaultTableModel createtable() {
        dtm.addColumn("No. Maskapai");
        dtm.addColumn("Nama Maskapai");
        dtm.addColumn("Tujuan");
        dtm.addColumn("Tgl Berangkat");
        dtm.addColumn("Jam Berangkat");
        dtm.addColumn("Harga");
        dtm.addColumn("No. Penerbangan");     
        
        return this.dtm;
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
                Object[] obj = new Object[7];
                //getString harus sesuai dengan kolom di db
                obj[0] = rSet.getString("Idm");
                obj[1] = rSet.getString("Maskapai");
                obj[2] = rSet.getString("Tujuan");
                obj[3] = rSet.getString("Tgl_Keberangkatan");
                obj[4] = rSet.getString("Jam_Keberangkatan");
                obj[5] = "Rp. "+rSet.getString("Harga");
                obj[6] = rSet.getString("Nopen");
                
                dtm.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Query Gagal");
        }
    }
}
