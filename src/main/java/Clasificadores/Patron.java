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
    private String claseResultante;
    
    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconosido";
        this.clase = "Desconosido";
    }
    
    public Patron(double[] n, String clase) {
        this.vector = n;
        this.clase = clase;
        this.clase = "Desconosido";
    }
    
    public Patron(Patron p) {
        this.vector = p.getVector().clone();
        this.clase = p.getClase();
        this.clase = "Desconosido";
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

    public String getClaseResultante() {
        return claseResultante;
    }

    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }
    
    
}
