/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.dto.cliente;

/**
 *
 * @author mafer
 */
public interface clientedao {
    int create(cliente c);
    int update(cliente c);
    int delete(String dni);
    cliente read(String dni);
    List<cliente> readAll();
}
