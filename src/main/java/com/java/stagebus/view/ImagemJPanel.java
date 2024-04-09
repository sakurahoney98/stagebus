/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.stagebus.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
@SuppressWarnings("serial")
class ImagemJPanel extends JPanel {
  
	
	private Image imagemDeFundo;

    public ImagemJPanel(String url) {
        ImageIcon imagemIcon = new ImageIcon(url);
        imagemDeFundo = imagemIcon.getImage();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        // Preenche o retângulo com a cor de fundo
        g.fillRect(0, 0, getWidth(), getHeight());
        if (imagemDeFundo != null) {
            // Estica a imagem para preencher o JPanel
            g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);
          
        }
    }
}



