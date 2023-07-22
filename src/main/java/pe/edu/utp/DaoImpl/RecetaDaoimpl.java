/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.utp.DAO.RecetaDao;
import pe.edu.utp.Entidades.Receta;
import pe.edu.utp.config.Conexion;

/**
 *
 * @author Taily
 */
public class RecetaDaoimpl implements RecetaDao{
    private PreparedStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Receta r) {
          int x =0;
        try {
            String SQL = "INSERT INTO receta(nombre_rec, imagen) VALUES(?,?)";
            cx = Conexion.getConexion();
            cst = cx.prepareStatement(SQL);
            cst.setString(1, r.getNombre_rec());
            cst.setBlob(2, r.getImagen());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int update(Receta r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
