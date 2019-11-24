/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clustering;

import Clasificadores.CMeans;
import Clasificadores.Herramientas.Patron;
import Clustering.HerramientasCluster.ImageManager;
import java.awt.Image;
import Clustering.HerramientasCluster.*;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class ClusteringMain {

    public static void main(String args[]) {
        
        Image io = ImageManager.openImage();
        JFrameImage jframe = new JFrameImage(io);
        ArrayList<Patron> instancias = ImageAdapter.obtenerInstancias(io);
        CMeans cm = new CMeans(10);
        cm.entrenar(instancias);
        cm.clasificar(instancias);
        
        Image imc = ImageAdapter.generarImagenClosterizada(cm.getCentroides(), instancias, new Dimension(io.getWidth(null),io.getHeight(null)));
        JFrameImage JframeC = new JFrameImage(imc);
        
    }
}
