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
import java.util.List;
import pe.edu.utp.DAO.DetalleRecetaDao;
import pe.edu.utp.Entidades.DetalleReceta;
import pe.edu.utp.config.Conexion;

/**
 *
 * @author Taily
 */
public class DetalleRecetaDaoImpl implements DetalleRecetaDao{
        private PreparedStatement cst;
    private Connection cx;
    private ResultSet rs;
    private ResultSet rs2;

    @Override
    public int create(DetalleReceta dr) {
        int x = 0;
        try {
            // Primero, consulta el "id_rec" correspondiente al "nombre_rec" proporcionado
            String nombreReceta = dr.getNombre_rec();
            String consultaReceta = "SELECT id_rec FROM receta WHERE nombre_rec = ?";
            cx = Conexion.getConexion();
            cst = cx.prepareStatement(consultaReceta);
            cst.setString(1, nombreReceta);
            rs = cst.executeQuery();
            System.out.println("estoy en el daoimpl");
            // Si la consulta devuelve un resultado, obtén el "id_rec" correspondiente
            int idReceta = -1; // Valor predeterminado en caso de que no se encuentre el registro
            if (rs.next()) {
                
                idReceta = rs.getInt(1);
                System.out.println(idReceta);
            }
            
            // Primero, consulta el "id_rec" correspondiente al "nombre_rec" proporcionado
            String nombreInsumo = dr.getNombre_insumo();
            System.out.println(nombreInsumo);
            String consultaInsumo = "SELECT id_insumo FROM insumos WHERE nombre_insumo = ?";
            cx = Conexion.getConexion();
            cst = cx.prepareStatement(consultaInsumo);
            cst.setString(1, nombreInsumo);
            rs2 = cst.executeQuery();

            // Si la consulta devuelve un resultado, obtén el "id_rec" correspondiente
            int idInsumo = -1; // Valor predeterminado en caso de que no se encuentre el registro
            if (rs2.next()) {
                idInsumo = rs2.getInt(1);
                System.out.println("idInsumo");
            }

            // Ahora, con el "id_rec" obtenido, inserta los datos en la tabla "detallereceta"
            if (idReceta != -1 && idInsumo!=-1) {
                String SQL = "INSERT INTO detallereceta(id_rec, id_insumo, cantidad_necesaria, unidad_cantn) VALUES (?, ?, ?, ?)";
                cst = cx.prepareStatement(SQL);
                cst.setInt(1, idReceta);
                cst.setInt(2, idInsumo);
                cst.setDouble(3, dr.getCantidad());
                cst.setString(4, dr.getUnidades());
                x = cst.executeUpdate();
                System.out.println(x);

                // Realiza las acciones necesarias después de la inserción (si es necesario)
                // ...
            } else {
                System.out.println("No se encontró el id_rec correspondiente al nombre_rec proporcionado.");
            }

        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return x;
    
    }

    @Override
    public int update(DetalleReceta dr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleReceta read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleReceta> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
