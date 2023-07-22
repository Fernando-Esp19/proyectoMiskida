/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2inte.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author JOEL
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pastelero {
    private int Id;
    private String nombre_pastelero;
    private String dnip;
    private String tel_pastelero;
    private String contra;
}
