/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.Entidades;

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

public class Insumo {

    private String nombre_insumo;
    private double cantidad_necesaria;
    private String unidad_cantn;
}
