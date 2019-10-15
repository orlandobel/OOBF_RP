/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clasificadores.Knn;
import Clasificadores.Herramientas.Herramientas;
import Clasificadores.Herramientas.MergeSort;
import Clasificadores.MinimaDistancia;
import Clasificadores.Herramientas.Patron;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class PaternRecognition {
    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        
        /*int nBits = 13;
        String dato = "";
        for(int i=0; i<nBits; i++) {
            dato += 1;
        }
        
        int x = Integer.parseInt(dato, 2);
        
        double[][] Porcentajes = new double[2][x];
        String[][] binario = new String[2][x];
        
        for(int i= 1; i<= x; i++) {
            int[] matriz = new int[nBits];
            String aux = Integer.toBinaryString(i);
            
            binario[0][i - 1] = aux;
            binario[1][i - 1] = aux;
            
            for(int j=0;i<aux.length();j++) {
                matriz[nBits - aux.length() + j] = Integer.parseInt(Character.toString(aux.charAt(j)));
            }
            
            for(int j=0; j<nBits; j++) {
                System.out.print(matriz[j]);
            }
            System.out.print("\n");
            
            Herramientas.leerDatos(matriz, "/home/Odi/Escritorio/IPN/Semestre 5/Reconcimiento de Patrones");
            
            MinimaDistancia md = new MinimaDistancia();
            md.entrenar(Herramientas.instancias);
            md.clasificar(Herramientas.instancias);
            Porcentajes[0][i-1] = md.Porcentaje();
            
            Knn knn = new Knn(3);
            knn.entrenar(Herramientas.instancias);
            knn.clasificar(Herramientas.instancias);
            Porcentajes[1][i-1] = knn.Porcentaje();
        }
        
        MergeSort msmd = new MergeSort();
        msmd.definirDatos(Porcentajes[0],binario[0]);
        
        MergeSort msk = new MergeSort();
        msk.definirDatos(Porcentajes[1],binario[1]);
        
        msmd.run();
        msk.run();
        
        System.out.print("En minima distancia: ");
        System.out.println(msmd.toString());
        
        System.out.print("En knn con k=3: ");
        System.out.println(msk.toString());*/
        int[] config = {1,0,1,1};
        Herramientas.leerDatos(config);
        
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(Herramientas.instancias);
        md.clasificar(Herramientas.instancias);
        System.out.println(md.getMatriz().toString());
        
        Knn knn = new Knn(5);
        knn.entrenar(Herramientas.instancias);
        knn.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
        System.out.println(knn.getMatriz().toString());
        
        System.out.println();
    }
    
}
