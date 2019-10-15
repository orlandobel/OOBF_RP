/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores.Herramientas;

import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class MatrizConfucion {
    
    private ArrayList<Patron> patrones;
    private ArrayList<String> clases;
    private int[][] matriz;
    private double[] porsentajes;
    
    public MatrizConfucion() {
        
    }
    
    public MatrizConfucion(ArrayList patrones) {
        this.patrones = patrones;
        obtenerClases();
        int t = clases.size();
        matriz = new int[t][t];
        this.porsentajes = new double[t+1];
        this.llenarMatriz();
    }
    
    private void obtenerClases() {
        this.clases = new ArrayList<String>();
        
        for(Patron p: patrones) {
            if(!this.clases.contains(p.getClase())) {
                this.clases.add(p.getClase());
            }
        }
    }
    
    public void llenarMatriz() {
        
        for(int i=0;i<clases.size();i++) {
            String clase = clases.get(i);
            for(Patron p: this.patrones) {
                if(p.getClase().equals(clase)) {
                    for(int j=0; j<clases.size();j++){ 
                        if(p.getClaseResultante().equals(clases.get(j))) {
                            matriz[i][j]++;
                        }
                    }
                }
            }
        }
    }
    
    public void porsentajeExito() {
        double porsentaje = 0;
        double res = 0;
        double cons = patrones.size();
        
        for(int i=0;i<matriz.length;i++) {
            int total = 0;
            for(int j=0;j<matriz.length;j++) {
                total += matriz[i][j];
            }
            res = this.matriz[i][i];
            this.porsentajes[i] = res/total;
        }
        
        for(int i=0;i<matriz.length;i++) {
            porsentaje += (matriz[i][i]/cons);
        }
        
        porsentajes[matriz.length] = porsentaje;
        
    }

    @Override
    public String toString() {
        this.porsentajeExito();
        
        String aux = "";
        for(int r=0;r<this.matriz.length;r++){
                aux+="|";
            for(int c=0;c<this.matriz.length;c++){
                aux+=" "+this.matriz[r][c]+",";
            }
            aux+="| porsentaje: "+this.porsentajes[r]+"\n";
        }
        aux += "porsentaje total: "+porsentajes[matriz.length]+"\n";
        return aux;
    }
    
    public double getPorcentaje() {
        return this.porsentajes[matriz.length];
    }
}
