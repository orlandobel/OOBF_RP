/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

/**
 *
 * @author Odi
 */
public class Herramientas {
    
    public static double calcularDistanciaEuclidiana(Patron a, Patron b) {
        double aux  = 0;
        for(int i=0;i<a.getVector().length;i++) {
            aux += Math.pow((a.getVector()[i]-b.getVector()[i]), 2);
        }
        
        return Math.pow(aux, 0.5);
    }
    
}
