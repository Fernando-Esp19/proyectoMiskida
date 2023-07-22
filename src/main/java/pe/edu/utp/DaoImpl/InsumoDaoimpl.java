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
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.DAO.InsumoDAO;
import pe.edu.utp.Entidades.Insumo;
import pe.edu.utp.config.Conexion;

/**
 *
 * @author Taily
 */
public class InsumoDaoimpl implements InsumoDAO{
        private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;


    @Override
    public int create(Insumo i) {
        int x = 0;
        //String SQL = "INSERT INTO receta (nombre_rec, imagen) VALUES (?,?)";
        String insertRecetaQuery = "INSERT INTO receta (nombre_rec, imagen) VALUES (?, ?)";
        String insertInsumoQuery = "INSERT INTO insumo (nombre_insumo) VALUES (?)";
        String insertDetalleRecetaQuery = "INSERT INTO detallereceta (id_rec, id_insumo, cantidad_necesaria, unidad_cantn) VALUES (?, ?, ?, ?)";
        try {
            cx.setAutoCommit(false); 
// Paso 1: Insertar datos en la tabla "receta"
            cx = Conexion.getConexion();/*
            cst = cx.prepareStatement(insertRecetaQuery);
            cst.setString(1, i.getNombreReceta());
            cst.setBlob(2, i.getImagen());
            x = cst.executeUpdate();
            // Obtener el ID de la receta recién insertada
            int idReceta = 0;
            ResultSet generatedKeys = cst.getGeneratedKeys();
            if (generatedKeys.next()) {
                idReceta = generatedKeys.getInt(1);
            } else {
                // Manejar el caso de error si no se pudo obtener el ID de la receta
                cx.rollback();
                return 0;
            }
            // Paso 2: Insertar datos en la tabla "insumo"
            cst = cx.prepareStatement(insertInsumoQuery);
            for (String nombreInsumo : i.getNombresInsumos()) {
                cst.setString(1, nombreInsumo);
                cst.addBatch();
            }
            cst.executeBatch();

            // Paso 3: Obtener los IDs de los insumos recién insertados
            int[] idInsumos = new int[i.getNombresInsumos().length];
            int index = 0;
            cst = cx.prepareStatement("SELECT LAST_INSERT_ID() AS id_insumo FROM insumo");
            rs = cst.executeQuery();
            while (rs.next()) {
                idInsumos[index++] = rs.getInt("id_insumo");
            }

            // Paso 4: Insertar datos en la tabla "detallereceta"
            cst = cx.prepareStatement(insertDetalleRecetaQuery);
            for (int j = 0; j < i.getNombresInsumos().length; j++) {
                cst.setInt(1, idReceta);
                cst.setInt(2, idInsumos[j]);
                cst.setDouble(3, i.getCantidades()[j]);
                cst.setString(4, i.getUnidades()[j]);
                cst.addBatch();
            }
            cst.executeBatch();

            cx.commit(); // Confirmar la transacción

            System.out.println("Los datos se insertaron correctamente.");*/
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                cx.rollback(); // Revertir la transacción en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                cx.setAutoCommit(true); // Habilitar autocommit
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return x;
        }
    }

    @Override
    public int update(Insumo i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Insumo read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Insumo> readAll() {
              List<Insumo> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement("SELECT nombre_insumo from insumos");
            rs = ps.executeQuery();
            while(rs.next()){
                Insumo i= new Insumo();
                i.setNombre_insumo(rs.getString(1));
                datos.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
        
    }
    
}
