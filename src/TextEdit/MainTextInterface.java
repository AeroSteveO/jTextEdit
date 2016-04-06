/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEdit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Stephen
 */
public class MainTextInterface extends javax.swing.JFrame {
    String filename = null;
    File file = null;
    LoggerFrame log = null;
    private Histogram display = new Histogram();
    int[] counts = new int[26];
    JFrame histoFrame;
    /**
     * Creates new form MainTextInterface
     * @param log
     */
    public MainTextInterface(LoggerFrame log) {
        initComponents();
        initHistogram();
        this.log = log;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initHistogram() {
        histoFrame = new JFrame();
        histoFrame.setSize(500, 300);
        histoFrame.setTitle("Histogram");
        histoFrame.setLocationRelativeTo(this); // Center the frame
        display.setBorder(new LineBorder(Color.red, 1));
        histoFrame.setLayout(new BorderLayout());
        histoFrame.add(display, BorderLayout.CENTER);
        histoFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        histoFrame.addWindowListener(new WindowAdapter() {
            //I skipped unused callbacks for readability
            @Override
            public void windowClosing(WindowEvent e) {
                log.getTextArea().append("Hide Histogram via window buttonn");
                histoFrame.setVisible(false);
            }
        });
    }
    public void updateHistogram() {
        // Reset counts
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
        }
        log.getTextArea().append("Update Histogram data\n");
        String line = jTextArea1.getText();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                counts[Character.toUpperCase(line.charAt(i)) - 'A']++;
            }
        }
        display.showHistogram(counts);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Input Filename Here");
        jPanel1.add(jLabel1);

        jTextField1.setText("filename");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);

        jButton1.setText("Open File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Save File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Save");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem4.setText("Hide/Show Log");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Hide/Show Histogram");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        filename = evt.getActionCommand();
        file = new File(filename);
        log.getTextArea().append("File " + filename + " input via JTextField\n");
        fileLoad();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        filename = jTextField1.getText();
        log.getTextArea().append("File " + filename + " input via Load File Button\n");
        file = new File(filename);
        fileLoad();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChoice = new JFileChooser();
        int returnVal = fileChoice.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChoice.getSelectedFile();
            filename = file.getName();
            jTextField1.setText(filename);
            log.getTextArea().append("File " + filename + " chosen via JFileChooser\n");
            fileLoad();
        }
        else {
            log.getTextArea().append("NO FILE SELECTED\n");
        }
//        filename = fileChoice.getName();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        log.getTextArea().append("File - Exit Selected\n");
        int out = JOptionPane.showConfirmDialog(null, "Would you like to save before closing?", "Save and Close", JOptionPane.YES_NO_OPTION);
        if (out == JOptionPane.YES_OPTION) {
            saveFile(jTextArea1.getText());
            System.exit(0);
        }
        else if (out == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        log.getTextArea().append("Closed out of file save/close dialog\n");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        saveFile(jTextArea1.getText());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        saveFile(jTextArea1.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (log.isShowing()) {
            log.getTextArea().append("Hide Log\n");
            log.setVisible(false);
        }
        else {
            log.getTextArea().append("Show Log\n");
            log.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if (histoFrame.isShowing()) {
            log.getTextArea().append("Show histogram\n");
            histoFrame.setVisible(false);
        }
        else {
            updateHistogram();
            log.getTextArea().append("Hide histogram\n");
            histoFrame.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainTextInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTextInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTextInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTextInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                LoggerFrame log = new LoggerFrame();
//                log.setVisible(true);
                new MainTextInterface(new LoggerFrame()).setVisible(true);
            }
        });
    }
    void saveFile(String save) {
        try {
            FileWriter fileWriter = new FileWriter(file.getName(),false);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(save);
            bufferWriter.close();
            log.getTextArea().append("File Saved\n");
        }
        catch (Exception ex){
           // ex.printStackTrace();
           log.getTextArea().append("Error: File NOT Saved\n");
        }
}

    void fileLoad() {
        jTextArea1.setText(null);
        if(!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e) {
//                e.printStackTrace();
                log.getTextArea().append("IO EXCEPTION OCCURED\n");
            }
            // display nothing
        }
        else {
            try{
                Scanner wordfile = new Scanner(file);
                String wordls = "";
                while (wordfile.hasNext()){
                    String line = (wordfile.nextLine());
                    wordls= wordls+ line;
                    jTextArea1.append(line + "\n");
                }
                wordfile.close();
                log.getTextArea().append("Success in loading file\n");
            } catch (FileNotFoundException ex) {
                log.getTextArea().append("Error in reading text\n");
//                ex.printStackTrace();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
