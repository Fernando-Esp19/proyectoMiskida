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
import pe.edu.utp.DAO.CalculadoraInsumoDAO;
import pe.edu.utp.Entidades.CalculadoraInsumos;
import pe.edu.utp.config.Conexion;

/**
 *
 * @author Taily
 */
public class CalculadoraInsumosDaoImpl implements CalculadoraInsumoDAO{
 private PreparedStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(CalculadoraInsumos i) {
        int x = 0;
        String SQL = "INSERT INTO reporte(insumo,cantidadn,cantidada,cantidadf) VALUES (?,?,?,?)";
        //INSERT INTO `insumo` (`idinsumo`, `cantidad`, `unidad`, `nombreinsumo`) VALUES (NULL, '10', 'kg', 'harina');

        try {

            cx = Conexion.getConexion();
            cst = cx.prepareStatement(SQL);

            cst.setString(1, i.getNombre());
            cst.setInt(2, i.getCantidadN());
            cst.setInt(3, i.getCantidadA());
            cst.setInt(4, i.getCantidadF());
            x = cst.executeUpdate();
 
                    System.out.println("Entreeeeeeeeeeeeeeeeee conchaless");
        } catch (SQLException e) {
            System.out.println("Error:ESTOY AQUIIII" + e);
        }
        return x; 
     
    }

    @Override
    public int update(CalculadoraInsumos i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CalculadoraInsumos read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CalculadoraInsumos> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
