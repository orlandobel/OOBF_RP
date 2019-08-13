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
public class Patron {
    
    private double vector[];
    private String clase;
    
    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconosido";
    }
    
    public Patron(int n, String clase) {
        this.vector = new double[n];
        this.clase = clase;
    }
    
    public Patron(Patron p) {
        this.vector = p.getVector().clone();
        this.clase = p.getClase();
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    
}
