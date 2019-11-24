/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clustering.HerramientasCluster;

import Clasificadores.Herramientas.Patron;
import Clasificadores.Herramientas.PatronRepresentativo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class ImageAdapter {
    
    public static ArrayList<Patron> obtenerInstancias(Image io) {
        ArrayList<Patron> instancias = new ArrayList(); // rreglo de instancias de patrones
        BufferedImage bi = ImageManager.toBufferedImage(io); // Se crea un buffer de la imagen original
        
        /*Genera las instancias de PixelPatron*/
        for(int x=0;x<bi.getWidth();x++) {
            for(int y=0;y<bi.getHeight();y++) {
                Color color = new Color(bi.getRGB(x, y)); //Crea un objeto color en base a un pixel
                /*Vector de colores para el patron*/
                double vector[] = {
                    color.getRed(),
                    color.getGreen(),
                    color.getBlue()
                };
                
                PatronPixel aux = new PatronPixel(x,y,vector); // Creamos el PixelPatron
                instancias.add(aux);
            }
        }
        
        return instancias;
    }
    
    public static Image generarImagenClosterizada(PatronRepresentativo[] r, ArrayList<Patron> instancias, Dimension dim) {
        
        BufferedImage bfAux = new BufferedImage((int)dim.getWidth(),(int)dim.getHeight(),BufferedImage.TYPE_INT_RGB);
        //Recorremos las instanicas
        for(Patron aux: instancias) {
            PatronPixel pxp = (PatronPixel)aux;
            String clase = pxp.getClase();
            double vector[] = new double[]{0,0,0};
            representativos:for(PatronRepresentativo pr: r) {
                if(clase.equals(pr.getClase())) {
                    vector = pr.getVector();
                    break representativos;
                }
            }
            bfAux.setRGB(pxp.getX(), pxp.getY(), new Color((int)vector[0],(int)vector[1],(int)vector[2]).getRGB());
        }
        
        return ImageManager.toImage(bfAux);
    }
}
