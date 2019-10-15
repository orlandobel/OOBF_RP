/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clustering;

import java.awt.Image;

/**
 *
 * @author Odi
 */
public class ClusteringMain {
    public static void main(String args[]) {
        Image io = ImageManager.openImage();
        JFrameImage jframe = new JFrameImage(io);
    }
}
