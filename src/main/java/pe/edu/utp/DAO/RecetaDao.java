/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.DAO;

import pe.edu.utp.Entidades.Receta;

/**
 *
 * @author mafer
 */
public interface RecetaDao {
    int create(Receta r);
    int update(Receta r);
}
