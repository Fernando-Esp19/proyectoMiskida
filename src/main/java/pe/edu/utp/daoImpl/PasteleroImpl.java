/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.config.Conexion;
import pe.edu.utp.dao.PasteleroDAO;
import pe.edu.utp.dto.Pastelero;

/**
 *
 * @author Taily
 */
public class PasteleroImpl implements PasteleroDAO {

    private PreparedStatement cst;//ejecuta la consulta
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Pastelero c) {
        int x = 0;
        String SQL = "INSERT INTO pastelero(nombre_pastelero,dnip,telf_pastelero,contra) VALUES(?,?,?,?)";
        try {

            cx = Conexion.getConexion();
            cst = cx.prepareStatement(SQL);
            cst.setString(1, c.getNombre_pastelero());
            cst.setString(2, c.getDnip());
            cst.setString(3, c.getTel_pastelero());

            cst.setString(4, c.getContra());

            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return x;
    }

    @Override
    public int update(Pastelero c) {
       
        int x = 0;
        System.out.println(c);
        String sql = "UPDATE pastelero SET nombre_pastelero = ?, dnip = ?, telf_pastelero = ?, contra = ? WHERE id = ?;";
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareStatement(sql);
            cst.setString(1, c.getNombre_pastelero());
            cst.setString(2, c.getDnip());
            cst.setString(3, c.getTel_pastelero());
             cst.setString(4, c.getContra());
            cst.setInt(5, c.getId());
            x = cst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public List<Pastelero> readAll() {

        List<Pastelero> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareStatement("select id,nombre_pastelero,dnip,telf_pastelero from pastelero;");
            rs = cst.executeQuery();
            while(rs.next()){
                Pastelero p  = new Pastelero();
                p.setId(rs.getInt(1));
                p.setNombre_pastelero(rs.getString(2));
                p.setDnip(rs.getString(3));
                p.setTel_pastelero(rs.getString(4));
            
                datos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }

    @Override

    public int validar(Pastelero c) {
        int r = 0;
        String SQL = "select * from pastelero where dnip=? and contra=?";
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareStatement(SQL);
            cst.setString(1, c.getDnip());
            cst.setString(2, c.getContra());
            rs = cst.executeQuery();
            while (rs.next()) {
                r = r + 1;
                c.setDnip(rs.getString("dnip"));
                c.setContra(rs.getString("contra"));

            }
            rs.close();
            if (r == 1) {
                return 1;

            } else {

                return 0;
            }

        } catch (Exception e) {
            return 2;
        }
    }

    @Override
    public int delete(String id) {
         int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareStatement("DELETE FROM pastelero\n" +
" WHERE id = ?;");
            cst.setString(1,id );
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public Pastelero read(String id) {
        Pastelero p = new Pastelero();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareStatement("SELECT * FROM pastelero WHERE id = ?;");
            cst.setString(1, id);
            rs = cst.executeQuery();

            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombre_pastelero(rs.getString(2));
                p.setDnip(rs.getString(3));
                p.setTel_pastelero(rs.getString(4));
                p.setContra(rs.getString(5));

            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return p;
    }

    

}
