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
import pe.edu.utp.dao.PasoDao;
import pe.edu.utp.dto.Paso;

/**
 *
 * @author mafer
 */
public class PasoDaoImpl implements PasoDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public List<Paso> read(String nombre_rec) {
       List<Paso> datos = new ArrayList<>();
       
       try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(" SELECT pp.pasos, pp.cantidad_necesaria, pp.unidad_cantn, pp.duracion\n"
                   + " FROM receta r\n"
                   + " JOIN detallepasospostre dp ON r.id_rec = dp.id_rec\n"
                   + " JOIN pasospostre pp ON dp.id_pasos = pp.id_pasos\n"
                   + " WHERE r.nombre_rec = ? ; ");
            ps.setString(1, nombre_rec);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paso p = new Paso();
                p.setPaso(rs.getString(1));
                p.setCantidad(rs.getDouble(2));
                p.setUnidad(rs.getString(3));
                p.setDuracion(rs.getInt(4));
                datos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return datos;

    }
}
