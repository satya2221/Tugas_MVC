/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_mvc;

import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Satya
 */
public class Model_mine {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/praktikumsatya";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public Model_mine() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    public void masukkanData(String nama, String nim, String alamat){
        try {
            String querynya = "INSERT INTO `mhs`(`nim`, `nama`, `address`) VALUES ('"+nim+"','"+nama+"','"+alamat+"')";
            koneksi =  (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            statement = (Statement)koneksi.createStatement();
            statement.executeUpdate(querynya);
            JOptionPane.showMessageDialog(null,"Data disimpan","Hasil",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception errorInput) {
            JOptionPane.showMessageDialog(null, errorInput.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int banyaknyaData(){
        int jmlData=0;
        try {
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM `mhs`";
            ResultSet hasilnya = statement.executeQuery(query);
                while (hasilnya.next()){
                    jmlData++;
                }
            return jmlData;
        } catch (Exception countData) {
            JOptionPane.showMessageDialog(null, countData.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    
    public String[][] tampilkanData(){
        try {
            int jmlData=0;
            String data[][] = new String[banyaknyaData()][3];
            String query = "Select * from `mhs`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nim");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("address"); 
                jmlData++;
            }
            return data;
        } catch (Exception errorTampil) {
            JOptionPane.showMessageDialog(null, errorTampil.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void hapusData(String nim){
        try{
            
            String query = "DELETE FROM `mhs` WHERE `nim` = '"+nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus","Hasil",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sql){
            JOptionPane.showMessageDialog(null, sql.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
     public void updateData(String nama, String nim, String alamat){
        try{
            
            statement = koneksi.createStatement();
            
            String querynya = "UPDATE `mhs` SET `nim`='"+nim+"',`nama`='"+nama+"',`address`='"+alamat+"' WHERE `nim` = '"+nim+"'";
            statement.executeUpdate(querynya);
            
            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");
            
        }catch(Exception errorUpdate){
            JOptionPane.showMessageDialog(null, errorUpdate.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
