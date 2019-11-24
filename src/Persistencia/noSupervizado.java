

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clasificadores.CMeans;
import Clasificadores.Herramientas.Herramientas;
import Clasificadores.Herramientas.Patron;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class noSupervizado {
    public static void main(String[] args) {
        //int[] config = {1,1,1,1};
        Herramientas.leerDatos();
        
        CMeans cm = new CMeans(3);
        cm.entrenar(Herramientas.instancias,new int[]{0,99,149});
        ArrayList<Patron> aux = (ArrayList<Patron>)Herramientas.instancias.clone();
        cm.clasificar(aux);
    }
}
