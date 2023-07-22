/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.DAO;

import java.util.List;
import pe.edu.utp.Entidades.CalculadoraInsumos;

/**
 *
 * @author Taily
 */
public interface CalculadoraInsumoDAO {

    int create(CalculadoraInsumos i);

    int update(CalculadoraInsumos i);

    int delete(int id);

    CalculadoraInsumos read(int id);

    List<CalculadoraInsumos> readAll();
}
