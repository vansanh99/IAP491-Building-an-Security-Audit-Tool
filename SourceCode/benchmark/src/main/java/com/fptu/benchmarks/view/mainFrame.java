/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fptu.benchmarks.view;

import com.fptu.benchmarks.beans.Profile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fptu.benchmarks.beans.Audit;
import com.fptu.benchmarks.beans.Level;
import com.fptu.benchmarks.beans.OSCheck;
import com.fptu.benchmarks.business.CommonUtils;
import com.fptu.benchmarks.business.LevelListCellRenderer;
import com.fptu.benchmarks.business.ReportUtils;
import com.fptu.benchmarks.business.ProfileHandler;
import com.fptu.benchmarks.business.TableUtilities;
import com.fptu.benchmarks.constant.Constants;
import com.fptu.benchmarks.model.ProfileDetails;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

        cardContent = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        cbbBenchmark = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescpCard1 = new javax.swing.JEditorPane();
        card2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbbLevel = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        epProfile = new javax.swing.JEditorPane();
        card3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        chkbHtmlReport = new javax.swing.JCheckBox();
        chkbPdfReport = new javax.swing.JCheckBox();
        lblSaveReport = new javax.swing.JLabel();
        chkbDocxReport = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        btnNext1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblOS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cardContent.setLayout(new java.awt.CardLayout());

        card1.setName("card1"); // NOI18N

        cbbBenchmark.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "please select" }));
        File[] files = new File("profiles").listFiles();
        for(File f : files) {
            cbbBenchmark.addItem(f.getName());
        }
        cbbBenchmark.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbBenchmarkItemStateChanged(evt);
            }
        });

        jLabel3.setText("Benchmark Profiles");

        jLabel6.setText("Selection Description");

        txtDescpCard1.setContentType("text/html"); // NOI18N
        jScrollPane4.setViewportView(txtDescpCard1);

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbbBenchmark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbBenchmark, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardContent.add(card1, "card1");
        card1.getAccessibleContext().setAccessibleName("");

        card2.setName("card2"); // NOI18N

        jLabel4.setText("Profile(s):");

        cbbLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLevelItemStateChanged(evt);
            }
        });

        jLabel7.setText("Profile Description");

        epProfile.setEditable(false);
        epProfile.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(epProfile);

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(69, 69, 69)
                        .addComponent(cbbLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardContent.add(card2, "card2");
        card2.getAccessibleContext().setAccessibleName("");

        card3.setName("card3"); // NOI18N

        jLabel5.setText("Report Out Options:");

        chkbHtmlReport.setSelected(true);
        chkbHtmlReport.setText("HTML Report");
        chkbHtmlReport.setName("reportType"); // NOI18N
        chkbHtmlReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkbHtmlReportMouseClicked(evt);
            }
        });

        chkbPdfReport.setText("PDF Report");
        chkbPdfReport.setName("reportType"); // NOI18N
        chkbPdfReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkbPdfReportMouseClicked(evt);
            }
        });

        lblSaveReport.setText("saving file to");

        chkbDocxReport.setText("DOCX Report");
        chkbDocxReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkbDocxReportMouseClicked(evt);
            }
        });

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Title", "Time", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableResult);
        if (tableResult.getColumnModel().getColumnCount() > 0) {
            tableResult.getColumnModel().getColumn(2).setResizable(false);
            tableResult.getColumnModel().getColumn(3).setResizable(false);
        }
        TableModelListener l = new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (TableUtilities.isInsert(e)) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            int viewRow = tableResult.convertRowIndexToView(e.getFirstRow());
                            tableResult.scrollRectToVisible(tableResult.getCellRect(viewRow, 0, true));
                        }
                    });
                }
            }
        };
        tableResult.getModel().addTableModelListener(l);

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaveReport)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addComponent(chkbHtmlReport)
                        .addGap(18, 18, 18)
                        .addComponent(chkbPdfReport)
                        .addGap(18, 18, 18)
                        .addComponent(chkbDocxReport))
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbHtmlReport)
                    .addComponent(chkbPdfReport)
                    .addComponent(chkbDocxReport))
                .addGap(28, 28, 28)
                .addComponent(lblSaveReport)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardContent.add(card3, "card3");

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

        btnBack.setText("Go Back");
        btnBack.setEnabled(false);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        lblOS.setText("platform");
        lblOS.setText("Platform: " + System.getProperty("os.name"));

        jLabel1.setText("osver");
        jLabel1.setText("version: " + System.getProperty("os.version"));

        jLabel2.setText("runtimejv");
        jLabel2.setText("JRE : " + System.getProperty("java.specification.vendor") + " " + System.getProperty("java.runtime.version"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardContent, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOS)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)
                        .addGap(203, 203, 203)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblOS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardContent, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnNext1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
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
            ProfileHandler ph = new ProfileHandler();
            if (cbbBenchmark.isShowing()) {
                DefaultComboBoxModel<Level> dcbbm = new DefaultComboBoxModel<>();
                Audit audit = ProfileDetails.getProfile().getAudit();
                if (null != audit) {
                    List<Level> levelList = audit.getLevelList();
                    if (CollectionUtils.isNotEmpty(levelList)) {
                        levelList.forEach(l -> {
                            dcbbm.addElement(l);
                        }
                        );
                    } else {
                        dcbbm.addElement(Level.builder().name("No profile...").build());
                    }
                    cbbLevel.setModel(dcbbm);
                    cbbLevel.setRenderer(new LevelListCellRenderer());
                    cardLayout.show(cardContent, card2.getName());
                    //enableBtnNext(card2.getName());
                    btnBack.setEnabled(true);
                    btnNext1.setEnabled(true);
                    epProfile.setText(levelList.get(0).getDescription());
                } else {
                    log.error("there is no audit set in this benchmark");
                    Fragment.errMsgUI(cardContent, "No audit selected", "Error");
                }
            } else if (cbbLevel.isShowing()) {
                Level level = (Level) cbbLevel.getSelectedItem();
                ProfileDetails.setProfileLevel(level);
                Audit audit = ProfileDetails.getProfile().getAudit();
                ph.LevelFilter(audit, level);
                /*ProfileDetails.getProfile().setAudit(Lists.newArrayList(ProfileDetails.getProfile().getAudit().stream()
                        .filter(a -> a.getLevel().equalsIgnoreCase(level))//set lever
                        .findAny()
                        .orElse(null)
                ));*/
                File file = new File("reports");
                lblSaveReport.setText("Saving to " + file.getAbsolutePath());
                cardLayout.show(cardContent, card3.getName());
                enableBtnNext(card3.getName());
                btnBack.setEnabled(true);
            } else if (lblSaveReport.isShowing()) {
                DefaultTableModel dtm = (DefaultTableModel) tableResult.getModel();
                dtm.setRowCount(0);
                Context context = new Context();
                context.setVariable("audit", ProfileDetails.getProfile().getAudit());
                context.setVariable("level", ProfileDetails.getProfileLevel());
                context.setVariable("htmlReport", chkbHtmlReport.isSelected());
                context.setVariable("pdfReport", chkbPdfReport.isSelected());
                context.setVariable("docxReport", chkbDocxReport.isSelected());
                ProfileDetails.setContext(context);
                ObjectMapper obm = new ObjectMapper();
                Thread t = new Thread(() -> {
                    ph.proccessProfile(ProfileDetails.getProfile().getAudit(), tableResult);
                    ReportUtils.generateReportFromHtml(context, ProfileDetails.getProfile().getTemplateReport(), "reports", tableResult);
                });
                t.start();
                String jsonText = "";
                try {
                    jsonText = obm.writerWithDefaultPrettyPrinter().writeValueAsString(ProfileDetails.getProfile());
                } catch (JsonProcessingException ex) {
                    log.error("error json {}", ex);
                }

                //ReportUtils repUtil = new ReportUtils(context, ProfileDetails.getProfile().getTemplateReport(), "reports");
                //Thread t = new Thread(repUtil);
                //t.start();
                //ReportUtils.generateReportFromHtml(context, ProfileDetails.getProfile().getTemplateReport(), "reports");
                //jsonPrint.setText(jsonText);
            }
            log.info("btnNext1 done");
        }
    }//GEN-LAST:event_btnNext1MouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        enableBtnNext(card2.getName());
        enableBtnNext(card1.getName());
        if (btnBack.isEnabled()) {
            log.info("btnBack clicked");
            CardLayout cardLayout = (CardLayout) cardContent.getLayout();
            if (cbbBenchmark.isShowing()) {
                enableBtnNext(card1.getName());
                btnBack.setEnabled(true);
            } else if (cbbLevel.isShowing()) {
                cardLayout.show(cardContent, card1.getName());
                btnBack.setEnabled(false);
            } else if (lblSaveReport.isShowing()) {
                cardLayout.show(cardContent, card2.getName());
                btnBack.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnBackMouseClicked

    private void chkbHtmlReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkbHtmlReportMouseClicked
        enableBtnNext(card3.getName());
    }//GEN-LAST:event_chkbHtmlReportMouseClicked

    private void chkbPdfReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkbPdfReportMouseClicked
        enableBtnNext(card3.getName());
    }//GEN-LAST:event_chkbPdfReportMouseClicked

    private void cbbBenchmarkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbBenchmarkItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {
                String path = "profiles/" + cbbBenchmark.getSelectedItem().toString();
                String jsonString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
                Profile p = new ObjectMapper().readValue(jsonString,
                        new TypeReference<Profile>() {
                });
                if (null != p) {
                    log.info("checking OS...");
                    OSCheck osc = p.getOSCheck();
                    osc.getCommandList().stream().forEach(cmd -> {
                        log.debug("command: {}, type: {}, expect: {}", cmd.getCommand(), "run command", cmd.getExpectationPattern());
                        String result = CommonUtils.runPipeCommand(cmd.getCommand());
                        if (result != null) {
                            if (CommonUtils.ismatchPattern(result, cmd.getExpectationPattern())) {
                                if (osc.getCommandList().size() > 1) {
                                    osc.setOperator(StringUtils.replace(osc.getOperator(), cmd.getId(), "true"));
                                } else {
                                    osc.setStatus(Constants.TRUE);
                                }
                            } else {
                                if (osc.getCommandList().size() > 1) {
                                    osc.setOperator(StringUtils.replace(osc.getOperator(), cmd.getId(), "false"));
                                } else {
                                    osc.setStatus(Constants.FALSE);
                                }
                            }
                        }
                    });
                    if (osc.getCommandList().size() > 1) {
                        if (StringUtils.isNoneEmpty(osc.getOperator())) {
                            String languageName = "ECMAScript";
                            String languageVersion = "ECMAScript 262 Edition 11";
                            ScriptEngineManager manager = new ScriptEngineManager();
                            List<ScriptEngineFactory> factories = manager.getEngineFactories();

                            ScriptEngine engine = null;
                            for (ScriptEngineFactory factory : factories) {
                                String language = factory.getLanguageName();
                                String version = factory.getLanguageVersion();

                                if (language.equals(languageName)
                                        && version.equals(languageVersion)) {
                                    engine = factory.getScriptEngine();
                                    break;
                                }
                            }

                            if (engine != null) {
                                try {
                                    osc.setStatus(((Boolean) engine.eval(osc.getOperator())));
                                } catch (ScriptException e) {
                                    log.error("Scripte err {}", e);
                                }
                            }
                            log.info("operator after: {}, status {}", osc.getOperator(), osc.isStatus());
                        } else {
                            log.error("operator can not be empty");
                        }
                    }
                    if (osc.isStatus()) {
                        ProfileDetails.setName(cbbBenchmark.getSelectedItem().toString());
                        ProfileDetails.setProfile(p);
                        log.info("profile loaded!!!");
                        txtDescpCard1.setText(p.getDescription());
                        enableBtnNext(card1.getName());
                    } else {
                        txtDescpCard1.setText("Wrong OS version!!!");
                    }
                }
            } catch (JsonProcessingException e1) {
                if (cbbBenchmark.getSelectedIndex() != 0) {
                    log.error("loi json :: {}", e1);
                    Fragment.errMsgUI(cardContent, "Error in parsing profile", "Notification");
                }
            } catch (IOException ex) {
                if (cbbBenchmark.getSelectedIndex() != 0) {
                    log.error("loi doc file :: {}", ex);
                    Fragment.errMsgUI(cardContent, "Profile not found", "Notification");
                } else {
                    txtDescpCard1.setText(StringUtils.EMPTY);
                }
            } finally {
                if (cbbBenchmark.getSelectedIndex() == 0) {
                    ProfileDetails.clearProfileDetails();
                    enableBtnNext(card1.getName());
                }
            }
        }
    }//GEN-LAST:event_cbbBenchmarkItemStateChanged

    private void cbbLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLevelItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Level lvl = (Level) cbbLevel.getSelectedItem();
            epProfile.setText(lvl.getDescription());
        }
    }//GEN-LAST:event_cbbLevelItemStateChanged

    private void chkbDocxReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkbDocxReportMouseClicked
        enableBtnNext(card3.getName());
    }//GEN-LAST:event_chkbDocxReportMouseClicked
    private void enableBtnNext(String card) {
        if (card1.isShowing() && cbbBenchmark.getSelectedIndex() == 0 && StringUtils.equals(card, card1.getName())
                || card3.isShowing() && !isReportTypeSelect() && StringUtils.equals(card, card3.getName())
                || card2.isShowing() && cbbLevel.getSelectedIndex() == 0 && StringUtils.equals(card, card2.getName())) {
            btnNext1.setEnabled(false);
        } else {
            btnNext1.setEnabled(true);
        }
    }

    private boolean isReportTypeSelect() {
        return chkbHtmlReport.isSelected() || chkbPdfReport.isSelected();
    }

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            log.error("loi class :: {}", ex);
        } catch (InstantiationException ex) {
            log.error("loi InstantiationException :: {}", ex);
        } catch (IllegalAccessException ex) {
            log.error("loi IllegalAccessException :: {}", ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            log.error("loi UnsupportedLookAndFeelException :: {}", ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext1;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel cardContent;
    private javax.swing.JComboBox<String> cbbBenchmark;
    private javax.swing.JComboBox<Level> cbbLevel;
    private javax.swing.JCheckBox chkbDocxReport;
    private javax.swing.JCheckBox chkbHtmlReport;
    private javax.swing.JCheckBox chkbPdfReport;
    private javax.swing.JEditorPane epProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblOS;
    private javax.swing.JLabel lblSaveReport;
    private javax.swing.JTable tableResult;
    private javax.swing.JEditorPane txtDescpCard1;
    // End of variables declaration//GEN-END:variables
}
