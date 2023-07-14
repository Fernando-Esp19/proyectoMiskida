/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.dto.trabajador;


public interface trabajadordao<trabajador> {
    int create(trabajador t);
    int update(trabajador t);
    int delete(String id_trab);
    trabajador read(String id_trab);
    List<trabajador> readAll();
     public int validar (trabajador t);
}
