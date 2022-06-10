/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Ferdy Septiawan
 */
public class koneksi {
    Connection cn;
    public static Connection BukaKoneksi(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/rekos","root","");
                return cn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Terkoneksi"+ e.getMessage());
            return null;
        } 
    } 
}
