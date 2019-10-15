/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores.Herramientas;

/**
 *
 * @author Odi
 */
public class PatronRepresentativo extends Patron {
    
    private int contador;
    
    /*public PatronRepresentativo(int n) {
        super(n);
    }*/
    
    public PatronRepresentativo(Patron a) {
        super(a.getVector().length);
        super.setClase(a.getClase());
        this.contador = 0;
        
        acumular(a);
    }

    public void acumular(Patron a) {
        for(int i=0;i<a.getVector().length;i++) {
            super.getVector()[i]+=a.getVector()[i];
        }
        this.contador++;
    }
    
    public void actualizar() {
        for(int i=0;i<super.getVector().length;i++) {
            super.getVector()[i]/=this.contador;
        }
        
        this.contador = 0;
    }
    
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
