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
public class Lernmatrix implements Memoria {
    
    private int[][] memoria;
    
    public Lernmatrix(int nClases, int tamVector) {
        this.memoria = new int[nClases][tamVector];
    }

    @Override
    public void aprendizaje(ArrayList<Patron> patrones) {
        for(Patron p: patrones) {
            aprendizaje(p);
        }
    }

    @Override
    public void aprendizaje(Patron patron) {
        int c = Integer.parseInt(patron.getClase());
        for(int i=0;i<patron.getVector().length;i++) {
            if(patron.getVector()[i] == 1) {
                memoria[c][i] += this.epsilon;
            } else {
                memoria[c][i] -= this.epsilon;
            }
        }
    }

    @Override
    public void recuperacion(Patron patron) {
        String claseRes = "";
        String prodP = "";
        int aux = 0;
        int[] res = new int[memoria.length];
        
        for(int i=0;i<this.memoria.length;i++) {
            int prodPunt = 0;
            for(int j=0;j<patron.getVector().length;j++) {
                prodPunt += memoria[i][j]*patron.getVector()[j];
            }
            res[i] = prodPunt;
        }
        
        for(int i=0;i<res.length;i++) {
            if(res[i] > aux) {
                aux = res[i];
                claseRes = "clase: "+i;
            } else if(res[i] == aux) {
                claseRes = "ERROR";
            }
        }
        
        for(int i=0;i<res.length;i++) {
            prodP += String.format("%3s", res[i])+"\n";
        }
        System.out.println(prodP);
        System.out.println(claseRes);
    }

    @Override
    public String toString() {
        String M = "";
        
        for(int i=0;i<memoria.length;i++) {
            M += "|";
            for(int j=0;j<memoria[0].length;j++) {
                M += String.format("%2s", memoria[i][j]) + "|";
            }
            M += "\n";
        }
        return M;
    }
    
}
