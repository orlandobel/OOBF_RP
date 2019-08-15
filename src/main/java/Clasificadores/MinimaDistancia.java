/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class MinimaDistancia implements ClasificadorSupervisado {

    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        ArrayList<PatronRepresentativo> representativos = new ArrayList();
        //Arregla el primer representativos
        representativos.add(new PatronRepresentativo(instancias.get(0)));
    }

    @Override
    public void clasificar() {
        
    }
    
}
