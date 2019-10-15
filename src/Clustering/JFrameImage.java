/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clustering;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Odi
 */
public class JFrameImage extends JFrame {
    
    public JFrameImage (Image imagenOriginal) {
        JLabel label = new JLabel(new ImageIcon(imagenOriginal));
        this.add(label);
        this.setSize(imagenOriginal.getWidth(this),
                     imagenOriginal.getHeight(this));
        this.setVisible(true);
    }
}
