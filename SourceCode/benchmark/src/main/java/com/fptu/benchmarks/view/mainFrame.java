/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fptu.benchmarks.view;

import com.fptu.benchmarks.beans.Profile;
import com.fptu.benchmarks.business.CommonUtils;
import com.fptu.benchmarks.business.Constants;
import com.fptu.benchmarks.business.PdfUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fptu.benchmarks.beans.Audit;
import com.fptu.benchmarks.beans.Chapter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.thymeleaf.context.Context;

/**
 *
 * @author vansa
 */
@Log4j2
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public mainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsonField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jsonPrint = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jsonField.setText("profiles/test.json");
        jsonField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsonFieldActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jsonPrint);

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jsonField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsonField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsonFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsonFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsonFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        log.info("mouse click");
        String path = jsonField.getText();
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            Profile p = new ObjectMapper().readValue(jsonString
                    , new TypeReference<Profile>() {});
            p.getAudits().forEach(audit -> {
                if(audit.getLevel() == 1) {
                    audit.getChapters().forEach(chap -> {
                        chap.getCategories().forEach(cat -> {
                            cat.getReports().forEach(report -> {
                                String pathToCheck = report.getPath();
                                log.debug("file path: " + pathToCheck);
                                if(report.getType() == 1) {//check file exists
                                    File tempFile = new File(pathToCheck);
                                    report.setStatus(tempFile.exists());
                                }
                                if(report.getType() == 2) {//check file pattern
                                    String filePattern = report.getPattern();
                                    try {
                                        String fileString = new String(Files.readAllBytes(Paths.get(pathToCheck)), StandardCharsets.UTF_8);
                                        if(CommonUtils.ismatchPattern(fileString, filePattern)) {
                                            report.setStatus(Constants.TRUE);
                                        } else {
                                            report.setStatus(Constants.FALSE);
                                        }
                                    } catch (IOException ex) {
                                        report.setStatus(Constants.FALSE);
                                    }
                                }
                            });
                        });
                    });
                }
            });
            ObjectMapper obm = new ObjectMapper();
            String jsonText = obm.writeValueAsString(p);
            
            XmlMapper xmlMapper = new XmlMapper();
            String xmlText = xmlMapper.writeValueAsString(p);
            Audit audit = p.getAudits().stream()
                        .filter(a -> a.getLevel() == 1)//set lever
                        .findAny()
                        .orElse(null);
            Context context = new Context();
            context.setVariable("chapters", audit.getChapters());
            File f = PdfUtils.generatePdfFromHtml(context, "CIS_Ubuntu_Linux_18.04_LTS_Benchmark_v2.0.1-xccdf", CommonUtils.getConfigValue("templateFolder") + "test.pdf");
            jsonPrint.setText("file report được lưu tại " + f.getAbsolutePath() + "\n" + jsonText);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

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
               java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }
           //</editor-fold>
           //</editor-fold>

           /* Create and display the form */
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jsonField;
    private javax.swing.JTextPane jsonPrint;
    // End of variables declaration//GEN-END:variables
}
