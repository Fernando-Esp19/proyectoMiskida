/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    
    
    private PreparedStatement cst;
    private PreparedStatement cst2;
    private PreparedStatement cst3;
    ResultSet generatedKeys;
    

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
                p.setCantidades(rs.getDouble(2));
                p.setUnidades2(rs.getString(3));
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

    @Override
    public int create(Paso p) {
        int x = 0;
        int y = 0;
        try {
       
                String SQL = "INSERT INTO pasospostre(pasos, cantidad_necesaria, unidad_cantn,duracion) VALUES (?, ?, ?, ?)";
                cx = Conexion.getConexion();
                cst = cx.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
                cst.setString(1, p.getPaso());
                cst.setDouble(2, p.getCantidades());
                String verificaru=p.getUnidades2();
                if (verificaru.equals(p.getUnidades2())) {
                cst.setString(3, "");
            } else {
                    cst.setString(3, p.getUnidades2());
            }
                
                cst.setInt(4, p.getDuracion());
                x = cst.executeUpdate();
                
                
            // Primero, consulta el "id_rec" correspondiente al "nombre_rec" proporcionado
            String nombreReceta = p.getNombre_rec();
            String consultaReceta = "SELECT id_rec FROM receta WHERE nombre_rec = ?";
            cst3 = cx.prepareStatement(consultaReceta);
            cst3.setString(1, nombreReceta);
            rs = cst3.executeQuery();
            System.out.println("estoy en el daoimpl");
            // Si la consulta devuelve un resultado, obtén el "id_rec" correspondiente
            int idReceta = -1; // Valor predeterminado en caso de que no se encuentre el registro
            if (rs.next()) {
                
                idReceta = rs.getInt(1);
                System.out.println(idReceta);
            }
                
                

                 generatedKeys= cst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                System.out.println("ID generado: " + idGenerado);
                String SQL2 = "INSERT INTO detallepasospostre(id_rec,id_pasos) VALUES (?, ?)";

                cst2 = cx.prepareStatement(SQL2);
                cst2.setInt(1,idReceta );
                cst2.setInt(2, idGenerado);
                y = cst2.executeUpdate();
                System.out.println("resultado ultimo insert" +y);
            }
            
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return x;
        
    }
}
