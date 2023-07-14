/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.config.Conexion;
import pe.edu.utp.dao.InsumoDao;
import pe.edu.utp.dto.Insumo;


/**
 *
 * @author mafer
 */
public class InsumoDaoImpl implements InsumoDao{

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public List<Insumo> read(String nombre_rec) {
        List<Insumo> datos = new ArrayList<>();
        
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(" SELECT i.nombre_insumo, d.cantidad_necesaria, d.unidad_cantn\n"
                    + " FROM insumos i\n"
                    + " INNER JOIN detallereceta d ON i.id_insumo = d.id_insumo\n"
                    + " INNER JOIN receta r ON r.id_rec = d.id_rec\n"
                    + " WHERE r.nombre_rec = ?; ");
            ps.setString(1, nombre_rec);
            rs = ps.executeQuery();

            while (rs.next()) {
                Insumo i = new Insumo();
                i.setNombre_insumo(rs.getString(1));
                i.setCantidad_necesaria(rs.getDouble(2));
                i.setUnidad_cantn(rs.getString(3));
                datos.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return datos;

    }
    
}
