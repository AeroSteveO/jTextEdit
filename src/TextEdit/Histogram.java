/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEdit;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author Stephen
 */
public class Histogram extends javax.swing.JPanel {
private int[] count;
    /**
     * Creates new form Histogram
     */
    public Histogram() {
//        initComponents();
    }
    public void showHistogram(int[] count) {
        this.count = count;
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /** Paint the histogram */
    protected void paintComponent(Graphics g) {
        if (count == null) return; // No display if count is null
//        System.out.println("Attempting repaint");
        super.paintComponent(g);
        
        // Find the panel size and bar width and interval dynamically
        int width = getWidth();
        int height = getHeight();
        int interval = (width - 40) / count.length;
        int individualWidth = (int)(((width - 40) / 24) * 0.60);
        
        // Find the maximum count. The maximum count has the highest bar
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (maxCount < count[i])
                maxCount = count[i];
        }
        
        // x is the start position for the first bar in the histogram
        int x = 30;
        
        // Draw a horizontal base line
        g.drawLine(10, height - 45, width - 10, height - 45);
        for (int i = 0; i < count.length; i++) {
            // Find the bar height
            int barHeight =
                    (int)(((double)count[i] / (double)maxCount) * (height - 55));
            
            // Display a bar (i.e. rectangle)
            g.drawRect(x, height - 45 - barHeight, individualWidth,
                    barHeight);
            
            // Display a letter under the base line
            g.drawString((char)(65 + i) + "", x, height - 30);
            
            // Move x for displaying the next character
            x += interval;
        }
    }
    
    /** Override getPreferredSize */
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
