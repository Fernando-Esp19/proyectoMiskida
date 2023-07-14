/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.dto.producto;

/**
 *
 * @author mafer
 */
public interface productodao {
    int create(producto p);
    int update(producto p);
    int delete(String cod);
    producto read(String cod);
    List<producto> readAll();
}
