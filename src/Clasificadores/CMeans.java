/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import Clasificadores.Herramientas.Patron;
import Clasificadores.Herramientas.PatronRepresentativo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Odi
 */
public class CMeans implements Clasificador{

    private int c;
    private PatronRepresentativo[] centroides;
    
    public CMeans(int c) {
        if(c > 15) 
            this.c = 15;
        else 
            this.c = c;
        
        this.centroides = new PatronRepresentativo[c];
    }
    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        // Genera los centroides aleatorios iniciales no repetidos
        Random ran = new Random();
        int pos = ran.nextInt(instancias.size());
        centroides[0] = new PatronRepresentativo(instancias.get(pos));
        centroides[0].setClase(""+0);
        int con = 1;
        while(con < this.c) {
            pos = ran.nextInt(instancias.size());
            if(!existe(instancias.get(pos),con)) {
                // Agregar el centroide nuevo
                centroides[con] = new PatronRepresentativo(instancias.get(con));
                centroides[con].setClase(""+con);
                con++;
                System.out.println(con);
            }
        }
        System.out.println();
    }

    @Override
    public void clasificar(Patron patron) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clasificar(ArrayList<Patron> patrones) {
        PatronRepresentativo[] nuevos;
        // Se clasifica
        do {
            clasificamos(patrones);
            // Volvemos a calcular los centroides
            nuevos = reAjustarCentroides(patrones);
            
        } while(sonDiferentes(nuevos));
    }
    
    private Boolean existe(Patron get, int i) {
        for(int x=0;x<i;x++) { 
            if(this.centroides[x].equals(get)) {
                return true;
            }
        }
        return false;
    }
    
    public void clasificamos(ArrayList<Patron> patrones) {
        
    }
    
    public PatronRepresentativo[] reAjustarCentroides(ArrayList<Patron> patrones) {
        PatronRepresentativo[] nuevos = new PatronRepresentativo[centroides.length];
        // Si se determina que son diferentes sustituimos los actuales
        for(Patron aux : patrones) {
            int i = Integer.parseInt(aux.getClaseResultante());
            if(nuevos[i] == null) {
                nuevos[i] = new PatronRepresentativo(aux);
            } else {
                nuevos[i].acumular(aux);
            }
        }
        
        for(int x=0;x<nuevos.length;x++)
            nuevos[x].actualizar();
        return nuevos;
    }
    
    private boolean sonDiferentes(PatronRepresentativo[] nuevos) {
        // Si se determina que son diferentes sustituimos a los actuales
        for(int x=0;x<nuevos.length;x++) {
            if(!nuevos[x].equals(centroides[x])) {
                centroides = nuevos.clone();
                return true;
            }
        }
        
        return false;
    }
    
    
}
