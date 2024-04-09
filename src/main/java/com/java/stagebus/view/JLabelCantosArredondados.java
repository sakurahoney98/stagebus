package com.java.stagebus.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class JLabelCantosArredondados extends JLabel {

    private int raioCantos = 10;

    public JLabelCantosArredondados() {
        
    }

    public void setRaioCantos(int raioCantos) {
        this.raioCantos = raioCantos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Desenha a borda arredondada
        Dimension arcs = new Dimension(raioCantos, raioCantos);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Preenche o fundo com a cor de fundo da JLabel
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        // Desenha o texto na JLabel
        super.paintComponent(g);
    }
    
}