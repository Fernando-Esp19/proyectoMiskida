/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.dto.venta;

/**
 *
 * @author mafer
 */
public interface ventadao {
    int create(venta v);
    int update(venta v);
    int delete(int id_dv);
    venta read(int id_dv);
    List<venta> readAll();
}
