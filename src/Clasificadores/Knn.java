/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import Clasificadores.Herramientas.Patron;
import Clasificadores.Herramientas.Herramientas;
import Clasificadores.Herramientas.MatrizConfucion;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class Knn implements ClasificadorSupervisado {

    private MatrizConfucion mc;
    private ArrayList<String> clases;
    private ArrayList<Patron> instancias;
    private int k;
    
    public Knn(int k) {
        this.mc = null;
        this. clases = new ArrayList<>();
        this.k = k;
    }
    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        this.instancias = (ArrayList<Patron>)instancias.clone();
        
        for(Patron p: instancias) {
            if(!this.clases.contains(p.getClase())) {
                this.clases.add(p.getClase());
            }
        }
    }

    @Override
    public void clasificar(Patron patron) {
        instancias.sort(
                (a, b) -> new Double(Herramientas.calcularDistanciaEuclidiana(a, patron))
                        .compareTo(new Double(Herramientas.calcularDistanciaEuclidiana(b, patron)))
  
        );
        
        int contador[] = new int[this.clases.size()];
        
        for(Patron aux: this.instancias) {
            int i = this.clases.indexOf(aux.getClase());
            contador[i]++;
            if(contador[i]==this.k) {
                patron.setClaseResultante(this.clases.get(i));
                break;
            }
        }
    }

    @Override
    public void clasificar(ArrayList<Patron> patrones) {
        for(Patron p: patrones) {
            clasificar(p);
        }
        
        this.mc = new MatrizConfucion(patrones);
    }
    
    public MatrizConfucion getMatriz() {
        return this.mc;
    }
    
    public double Porcentaje() {
        return this.mc.getPorcentaje();
    }
    
}
