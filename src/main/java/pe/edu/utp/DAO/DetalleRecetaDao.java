/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.DAO;

import java.util.List;
import pe.edu.utp.Entidades.DetalleReceta;

/**
 *
 * @author Taily
 */
public interface DetalleRecetaDao {
        int create(DetalleReceta dr);
    int update(DetalleReceta dr);
    int delete(int id);
    DetalleReceta read(int id);
    List<DetalleReceta> readAll();
}
