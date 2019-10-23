/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clustering.HerramientasCluster;

import Clasificadores.Herramientas.Patron;

/**
 *
 * @author Odi
 */
public class PatronPixel extends Patron {
    private int x;
    private int y;
    
    public PatronPixel(int x, int y, double[] vector) {
        super(vector, "");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
