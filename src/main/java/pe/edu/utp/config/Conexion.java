/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Taily
 */
public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/proy1integrador?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String USER="root";
    private static final String PASS="";
    static Connection cx= null;
    
    public static Connection getConexion(){
        try{
            Class.forName(DRIVER);
            if(cx==null){
                cx= DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error:" +e);
        }
        
        return cx;
    }
}
