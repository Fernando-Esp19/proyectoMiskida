/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.daoImpl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.config.Conexion;
import pe.edu.utp.dao.RecetaDao;
import pe.edu.utp.dto.Receta;

/**
 *
 * @author mafer
 */
public class RecetaDaoImpl implements RecetaDao{

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public List<Receta> readAll() {
        List<Receta> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement("SELECT nombre_rec,imagen FROM receta ");
            rs = ps.executeQuery();
            while(rs.next()){
                Receta r= new Receta();
                r.setNombre_rec(rs.getString(1));
                r.setImagen(rs.getBlob(2));
                datos.add(r);
            } 
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }

    @Override
    public Receta read(String nombre_rec) {
        Receta r = new Receta();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement("SELECT nombre_rec,imagen FROM receta WHERE nombre_rec = ?");
            ps.setString(1, nombre_rec);
            rs = ps.executeQuery();
           
            while(rs.next()){
                r.setNombre_rec(rs.getString(1));
                r.setImagen(rs.getBlob(2));

                 
             }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        } catch (Exception e) {
    System.out.println("Error: " + e);
}
        return r; 
        
    }
    
   
    
}
