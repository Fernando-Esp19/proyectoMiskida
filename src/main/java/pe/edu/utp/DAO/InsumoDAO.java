/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.DAO;

import java.util.List;
import pe.edu.utp.Entidades.Insumo;

/**
 *
 * @author Taily
 */
public interface InsumoDAO {
    int create(Insumo i);
    int update(Insumo i);
    int delete(int id);
    Insumo read(int id);
    List<Insumo> readAll();
    
}
