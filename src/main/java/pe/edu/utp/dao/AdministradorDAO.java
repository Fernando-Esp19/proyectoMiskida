/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.dao;


import java.util.List;
import pe.edu.utp.dto.Administrador;

/**
 *
 * @author Taily
 */
public interface AdministradorDAO {

    int create(Administrador a);

    int update(Administrador a);

    int delete(int id);

    Administrador read(int id);

    List<Administrador> readAll();

    public int validarA(Administrador a);
}
