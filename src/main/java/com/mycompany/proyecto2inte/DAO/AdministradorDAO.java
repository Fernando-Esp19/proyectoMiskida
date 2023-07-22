/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2inte.DAO;

import com.mycompany.proyecto2inte.Entidades.Administrador;
import com.mycompany.proyecto2inte.Entidades.Pastelero;
import java.util.List;
/**
 *
 * @author JOEL
 */
public interface AdministradorDAO {

    int create(Administrador a);

    int update(Administrador a);

    int delete(int id);

    Administrador read(int id);

    List<Administrador> readAll();

    public int validarA(Administrador a);
}
