/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import Clasificadores.Herramientas.Patron;
import Clasificadores.Herramientas.PatronRepresentativo;
import Clasificadores.Herramientas.MatrizConfucion;
import Clasificadores.Herramientas.Herramientas;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class MinimaDistancia implements ClasificadorSupervisado {
    
    ArrayList<PatronRepresentativo> representativos;
    MatrizConfucion mc;
    
    public MinimaDistancia() {
        this.representativos = new ArrayList<PatronRepresentativo>();
    }
        
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        //Arregla el primer representativos
        representativos.add(new PatronRepresentativo(instancias.get(0)));
        
        for(int i=1;i<instancias.size();i++) {
            Patron aux = instancias.get(i);
            
            int pos = representativos.indexOf(aux);
            System.out.println();
            if(pos!=-1) {
                representativos.get(pos).acumular(aux); 
                
            } else {
                representativos.add(new PatronRepresentativo(aux));
            }
        }
        
        for(PatronRepresentativo aux: representativos) {
            aux.actualizar();
        }
        
    }

    @Override
    public void clasificar(Patron patron) {
        int iMenor = 0;
        double dMenor = Herramientas.calcularDistanciaEuclidiana
        (patron, this.representativos.get(0));
        
        //en un proceso iterativo calcular las distancias con respecto a los representativos
        for(int i=1;i<this.representativos.size();i++) {
            double dN = Herramientas.calcularDistanciaEuclidiana(patron, this.representativos.get(i));
            
            if(dN < dMenor) {
                dMenor = dN;
                iMenor = i;
            }
        }
        
        patron.setClaseResultante(this.representativos.get(iMenor).getClase());
    }
    
    @Override
    public void clasificar(ArrayList<Patron> patrones) {
        for(Patron p: patrones) {
            clasificar(p);
        }
        this.mc = new MatrizConfucion(patrones);        
    }
    
    public MatrizConfucion getMatriz()  {
        return this.mc;
    }
    
    public double Porcentaje() {
        return this.mc.getPorcentaje();
    }
    
}
