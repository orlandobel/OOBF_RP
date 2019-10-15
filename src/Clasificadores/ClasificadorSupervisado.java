/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import Clasificadores.Herramientas.Patron;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public interface ClasificadorSupervisado {
    
    void entrenar(ArrayList<Patron> instancias);
    
    void clasificar(Patron patron);
    void clasificar(ArrayList<Patron> patrones);
    
}
