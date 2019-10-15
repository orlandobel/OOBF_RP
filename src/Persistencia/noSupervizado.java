/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clasificadores.CMeans;
import Clasificadores.Herramientas.Herramientas;

/**
 *
 * @author Odi
 */
public class noSupervizado {
    public static void main(String[] args) {
        int[] config = {1,1,1,1};
        Herramientas.leerDatos(config);
        
        CMeans cm = new CMeans(5);
        cm.entrenar(Herramientas.instancias);
    }
}
