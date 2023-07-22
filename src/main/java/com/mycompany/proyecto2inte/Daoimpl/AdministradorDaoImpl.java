/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2inte.Daoimpl;

import com.mycompany.proyecto2inte.DAO.AdministradorDAO;
import com.mycompany.proyecto2inte.Entidades.Administrador;
import com.mycompany.proyecto2inte.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author JOEL
 */
public class AdministradorDaoImpl implements AdministradorDAO{
            private PreparedStatement cst;//ejecuta la consulta
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Administrador a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Administrador a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrador read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Administrador> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int validarA(Administrador a) {
         int ar = 0;

        String SQL = "select * from administrador where dnia=? and contraa=?";
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareStatement(SQL);
            cst.setString(1,a.getDnia());
            cst.setString(2, a.getContraa());
            rs = cst.executeQuery();
            while (rs.next()) {
                ar = ar + 1;
                a.setDnia(rs.getString("dnia"));
                a.setContraa(rs.getString("contraa"));

            }
            
                                System.out.println("Estoy aquiii tambien admi");

            rs.close();
            if (ar == 1) {
                return 1;

            } else {

                return 0;
            }

        } catch (Exception e) {
            return 2;
        }
    }
    
}
