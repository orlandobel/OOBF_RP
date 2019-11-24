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
public class CAP implements Memoria {
    private double[][] memoria;
    private ArrayList<String> clases;
    private Patron centro;
    
    public CAP() {
        this.clases = new ArrayList();
    }
    
    private void getClases(ArrayList<Patron> patrones) {
        for(Patron p: patrones) {
            if(!this.clases.contains(p.getClase())) {
                this.clases.add(p.getClase());
            }
        }
    }
    
    private Patron getTraslacion(ArrayList<Patron> patrones) {
        double[] aux = new double[patrones.get(0).getVector().length];
        
        for(Patron p: patrones) {
            for(int i=0;i<p.getVector().length;i++) {
                aux[i] += p.getVector()[i];
            }
        }
        
        for(int i=0;i<aux.length;i++) {
            aux[i] /= patrones.size();
        }
        Patron paux = new Patron(aux);
        return paux;
    }
    
    private double[] traslacion(Patron p) {
        double[] vt = new double[p.getVector().length]; // Vector trasladado
        
        for(int i=0;i<vt.length;i++) {
            vt[i] = p.getVector()[i] - centro.getVector()[i];
        }
        
        return vt;
    }

    @Override
    public void aprendizaje(ArrayList<Patron> patrones) {
        this.getClases(patrones);
        this.memoria = new double[this.clases.size()]
                                 [patrones.get(0).getVector().length];
        this.centro = this.getTraslacion(patrones);
        
        for(Patron p: patrones) {
            this.aprendizaje(p);
        }
    }

    @Override
    public void aprendizaje(Patron patron) {
        double[] vt = this.traslacion(patron);
        int c = clases.indexOf(patron.getClase());
        
        for(int i=0;i<vt.length;i++) {
            memoria[c][i] += vt[i];
        }
    }

    @Override
    public void recuperacion(Patron patron) {
        double max = 0;
        int clase = -1;
        double[] vtp = this.traslacion(patron);
        
        for(int i=0;i<memoria.length;i++) {
            double aux = 0;
            for(int j=0; j<vtp.length;j++) {
                aux += memoria[i][j]*vtp[j];
            }
            
            if(aux > max) {
                max = aux;
                clase = i;
            }
        }
        
        patron.setClase(clases.get(clase));
    }
}
