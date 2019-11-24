/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemoriaAsociativa;

import Clasificadores.Herramientas.Patron;
import java.util.ArrayList;


/**
 *
 * @author Odi
 */
public interface Memoria {
    final int epsilon = 1;
    
    void aprendizaje(ArrayList<Patron> patrones);
    void aprendizaje(Patron patron);
    
    void recuperacion(Patron patron);
}
