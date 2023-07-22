/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;


import java.util.List;
import pe.edu.utp.dto.DetalleReceta;

/**
 *
 * @author mafer
 */
public interface DetalleRecetaDao {
    int create(DetalleReceta dr);
    int update(DetalleReceta dr);
    int delete(int id);
    DetalleReceta read(int id);
    List<DetalleReceta> readAll();
}
