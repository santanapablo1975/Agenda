/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC54
 */
public class Conexion {
    protected Connection cnn;

    protected void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
          
               cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
  
          
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void desconectar() {
        try {
            cnn.close();
            cnn=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
