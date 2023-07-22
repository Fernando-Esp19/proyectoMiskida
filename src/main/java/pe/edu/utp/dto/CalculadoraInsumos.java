/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Taily
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculadoraInsumos {
    String nombre;
    int cantidadN;
    int cantidadA;
    int cantidadF;
}
