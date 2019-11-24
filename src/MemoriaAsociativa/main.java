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
public class main {
    public static void main(String args[]) {
        ArrayList<Patron> patrones = new ArrayList();
        
        Patron p1 = new Patron(new double[]{2,3,6},""+0);
        Patron p2 = new Patron(new double[]{6,8,10},""+1);
        
        patrones.add(p1);
        patrones.add(p2);
        
        CAP cap = new CAP();
        cap.aprendizaje(patrones);
        cap.recuperacion(p1);
        
    }
    
}
