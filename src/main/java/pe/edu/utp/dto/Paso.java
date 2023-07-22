/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mafer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paso {
    private String nombre_rec;
    private String paso;
    private double cantidad;
    private String unidad;
    private int duracion;
}
