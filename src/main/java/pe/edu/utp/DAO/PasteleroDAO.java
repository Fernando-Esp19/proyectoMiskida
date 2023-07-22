/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.utp.DAO;

import java.util.List;
import pe.edu.utp.Entidades.Pastelero;

/**
 *
 * @author Taily
 */
public interface PasteleroDAO {

    int create(Pastelero c);

    int update(Pastelero c);

    int delete(String id);
    Pastelero read(String id);

    List<Pastelero> readAll();

    public int validar(Pastelero c);
}
