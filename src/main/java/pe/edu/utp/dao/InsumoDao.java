/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.dto.Insumo;

/**
 *
 * @author mafer
 */
public interface InsumoDao {
    List<Insumo> read(String nombre_rec);
}
    