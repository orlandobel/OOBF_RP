/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clasificadores.Patron;
import Clasificadores.Herramientas;
import Clasificadores.PatronRepresentativo;

/**
 *
 * @author Odi
 */
public class PaternRecognition {
    
    public static void main(String[] args) {
        Patron a = new Patron(new double[]{11.5,5.7,4.8},"");
        Patron b = new Patron(new double[]{1,1,1},"");
        Patron c = new Patron(new double[]{12,113,14},"");
        
        PatronRepresentativo aux = new PatronRepresentativo(a);
        aux.acumular(b);
        aux.acumular(c);
        aux.actualizar();
    }
    
}
