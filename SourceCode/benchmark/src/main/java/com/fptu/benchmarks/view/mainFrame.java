/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fptu.benchmarks.view;

import com.fptu.benchmarks.beans.Profile;
import com.fptu.benchmarks.business.PdfUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fptu.benchmarks.beans.Audit;
import com.fptu.benchmarks.beans.ProfileDetails;
import com.fptu.benchmarks.business.ProfileHandler;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.extern.log4j.Log4j2;

import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.context.Context;

/**
 *
 * @author vansa
 */
@Log4j2
public class mainFrame extends javax.swing.JFrame {

    private ProfileDetails profileDetails = new ProfileDetails();

    /**
     * Creates new form NewJFrame
     */
    public mainFrame() {
        log.info(System.getProperties());
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

        lblOS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cardContent = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        cbbBenchmark = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        card2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jsonPrint = new javax.swing.JTextPane();
        cbbLevel = new javax.swing.JComboBox<>();
        btnNext1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblOS.setText("platform");
        lblOS.setText("Platform: " + System.getProperty("os.name"));

        jLabel1.setText("osver");
        jLabel1.setText("version: " + System.getProperty("os.version"));

        jLabel2.setText("runtimejv");
        jLabel2.setText("JRE : " + System.getProperty("java.runtime.version"));

        cardContent.setLayout(new java.awt.CardLayout());

        cbbBenchmark.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "please select" }));
        File[] files = new File("profiles").listFiles();
        for(File f : files) {
            cbbBenchmark.addItem(f.getName());
        }
        cbbBenchmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbBenchmarkActionPerformed(evt);
            }
        });

        jLabel3.setText("Benchmark Profiles");

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cbbBenchmark, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbBenchmark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );

        cardContent.add(card1, "card1");
        card1.getAccessibleContext().setAccessibleName("");

        jLabel4.setText("Profile(s):");

        jScrollPane1.setViewportView(jsonPrint);

        cbbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select..." }));
        cbbLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(cbbLevel, 0, 663, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardContent.add(card2, "card 2");
        card2.getAccessibleContext().setAccessibleName("");

        btnNext1.setText("Next");
        btnNext1.setEnabled(false);
        btnNext1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNext1MouseClicked(evt);
            }
        });
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblOS)
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addGap(191, 191, 191)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext1)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOS)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(63, 63, 63)
                .addComponent(cardContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnNext1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNext1MouseClicked
        if (btnNext1.isEnabled()) {
            log.info("btnNext1 clicked");
            CardLayout cardLayout = (CardLayout) cardContent.getLayout();
            if (cbbBenchmark.isShowing()) {//card 1
                String path = "profiles/" + cbbBenchmark.getSelectedItem().toString();
                Profile p = new Profile();
                String jsonString = "";
                try {
                    jsonString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
                    p = new ObjectMapper().readValue(jsonString,
                            new TypeReference<Profile>() {
                    });
                } catch (JsonProcessingException e1) {
                    log.error("loi json :: {}", e1);
                } catch (IOException ex) {
                    log.error("loi doc file :: {}", ex);
                }
                if (null != p) {
                    profileDetails.setName(cbbBenchmark.getSelectedItem().toString());
                    profileDetails.setProfile(p);
                    for (Audit a : profileDetails.getProfile().getAudits()) {
                        cbbLevel.addItem(a.getLevel());
                    }
                }
                cardLayout.show(cardContent, "card 2");
                btnNext1.setEnabled(false);
                return;
            }
            if (cbbLevel.isShowing()) {// card 2
                String level = cbbLevel.getSelectedItem().toString();
                Audit audit = profileDetails.getProfile().getAudits().stream()
                    .filter(a -> StringUtils.equalsIgnoreCase(a.getLevel(), level))//set lever
                    .findAny()
                    .orElse(null);
                ProfileHandler ph = new ProfileHandler();
                ph.proccessProfile(audit);
                String jsonText = "";
                try {
                    ObjectMapper obm = new ObjectMapper();
                    jsonText = obm.writerWithDefaultPrettyPrinter().writeValueAsString(profileDetails.getProfile());
                } catch (JsonProcessingException ex) {
                    log.error("error json {}", ex);
                }
                Context context = new Context();
                context.setVariable("chapters", audit.getChapters());
                context.setVariable("htmlReport", true);
                context.setVariable("pdfReport", false);
                File f = PdfUtils.generatePdfFromHtml(context, profileDetails.getProfile().getTemplateReport(), "reports/test.pdf");
                jsonPrint.setText("file report được lưu tại " + (null != f ? f.getAbsolutePath() : "null") + "\n" + jsonText);
            }
        }

        log.info("btnNext1 done");
    }//GEN-LAST:event_btnNext1MouseClicked

    private void cbbBenchmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbBenchmarkActionPerformed
        if (cbbBenchmark.getSelectedIndex() == 0) {
            btnNext1.setEnabled(false);
        } else {
            btnNext1.setEnabled(true);
        }
    }//GEN-LAST:event_cbbBenchmarkActionPerformed

    private void cbbLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLevelActionPerformed
        if (cbbLevel.getSelectedIndex() == 0) {
            btnNext1.setEnabled(false);
        } else {
            btnNext1.setEnabled(true);
        }
    }//GEN-LAST:event_cbbLevelActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext1;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel cardContent;
    private javax.swing.JComboBox<String> cbbBenchmark;
    private javax.swing.JComboBox<String> cbbLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jsonPrint;
    private javax.swing.JLabel lblOS;
    // End of variables declaration//GEN-END:variables
}
