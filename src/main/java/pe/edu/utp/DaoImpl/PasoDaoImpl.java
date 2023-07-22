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
import java.sql.Statement;
import pe.edu.utp.DAO.PasoDao;
import pe.edu.utp.Entidades.Paso;
import pe.edu.utp.config.Conexion;

/**
 *
 * @author Taily
 */
public class PasoDaoImpl implements PasoDao{
    private PreparedStatement cst;
    private PreparedStatement cst2;
    private PreparedStatement cst3;
    private Connection cx;
    private ResultSet rs;
    ResultSet generatedKeys;
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
