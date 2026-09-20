/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.p2oyun;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author excalibur
 */
public class OyunEkranı extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OyunEkranı.class.getName());

    /**
     * Creates new form OyunEkranı
     */
    String[] kelimeler;
    String kelime;
    int yanlisSayisi = 0;
    int sayac = 0;
    javax.swing.Timer timer;
    static final String resim_dosya = "C:/P2OYUN/Resimler/";
    static final String metin_dosya = "C:/P2OYUN/TXTdosyalar/";
    public OyunEkranı() {
        initComponents();
        RastgeleKelimeSec();
        
        int harfSayisi= kelime.length();
        
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        for(int i=0;i<harfSayisi;i++){
            
            JLabel lbl = new JLabel("*");
            lbl.setName("lbl"+i);
            jPanel2.add(lbl);
        }
        
        jPanel2.revalidate();
        jPanel2.repaint();
        timerBaslat();
        
        jTabbedPane1.addChangeListener(e -> {
            if (jTabbedPane1.getSelectedIndex() == 1) {
                skorlariYukle();
            }
            else if (jTabbedPane1.getSelectedIndex() == 2) {
                loglariYukle();
    }
});
        
        
    }
    private void bastanBasla() {
        yanlisSayisi = 0;
        jLabel1.setIcon(null);
        jPanel2.removeAll();
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        for (int i = 0; i < kelime.length(); i++) {
            JLabel lbl = new JLabel("*");
            lbl.setName("lbl" + i);
            jPanel2.add(lbl);
        }
        jPanel2.revalidate();
        jPanel2.repaint();
        timerBaslat();
    }
    
    private void yeniOyun() {
        RastgeleKelimeSec();
        bastanBasla();
        timerBaslat();
    }
    
    private void timerBaslat() {
        if (timer != null) timer.stop();
        sayac = 0;
        jLabel4.setText("Süre: 0");
        timer = new javax.swing.Timer(1000, e -> {
        sayac++;
        jLabel4.setText("Süre: " + sayac);
        });
        timer.start();
    }
    
    private void oyunKaydet(String sonuc) {
        try {
            FileWriter fw = new FileWriter(metin_dosya + "oyunlar.txt", true);
            
            java.util.Date simdi = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String zaman = sdf.format(simdi);
            
            fw.write(zaman + "," + sayac + "," + sonuc + "\n");
            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
        }
    }
    
    private void skorlariYukle() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
           
        
            BufferedReader br = new BufferedReader(new FileReader(metin_dosya + "oyunlar.txt"));
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length == 3) {
                    model.addRow(parcalar);
                }
            }
            br.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
            }
    }
    
    private void loglariYukle() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
        
            BufferedReader br = new BufferedReader(new FileReader(metin_dosya + "log.txt"));
            String satir;
            while ((satir = br.readLine()) != null) {
                if (satir.contains("] ") && satir.contains(" - ")) {
                    String etiket = satir.substring(1, satir.indexOf("]"));
                    String zaman = satir.substring(satir.indexOf("] ") + 2, satir.indexOf(" - "));
                    String girisDurumu = satir.substring(satir.indexOf(" - ") + 3);
                    model.addRow(new String[]{etiket, zaman, girisDurumu});
                }
            }
            br.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        jLabel2.setText("harf tahmini");

        jLabel3.setText("kelime tahmini");

        jButton1.setText("Tahmin et");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Tahmin et");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(113, 113, 113)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))))
                        .addContainerGap(130, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("oyun", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tarih", "süre(saniye)", "sonuç"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Temizle");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton3)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton3)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("skorlar", jPanel4);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Etiket", "Tarih", "Giriş durumu"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton4.setText("Temizle");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jButton4)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("loglar", jPanel5);

        jMenu1.setText("menü");
        jMenu1.addActionListener(this::jMenu1ActionPerformed);

        jMenuItem1.setText("Yeni Oyun");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Baştan Başla");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String harfTahmin =jTextField1.getText().toUpperCase();
        boolean harf_bulundu = false;
    
        for (int i = 0; i < jPanel2.getComponentCount(); i++) {
            JLabel siradakilabel = (JLabel) jPanel2.getComponent(i);
            if (harfTahmin.equals(String.valueOf(kelime.charAt(i)))) {
                siradakilabel.setText(harfTahmin);
                harf_bulundu = true;
            }
        }
    
        if (!harf_bulundu) {
            yanlisSayisi++;
            
            ImageIcon resim = new ImageIcon(resim_dosya + yanlisSayisi + ".jpg");
            jLabel1.setIcon(new ImageIcon(resim.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH)));

            JOptionPane.showMessageDialog(this, "Harf bulunamadı! Yanlış: " + yanlisSayisi);
            
            if (yanlisSayisi >= 11) {
                JOptionPane.showMessageDialog(this, "Adam asıldı! Doğru kelime: " + kelime);
                timer.stop();
                oyunKaydet("KAYBETTİ");
            }
            
            
        }
        boolean basarı = true;
        for (int i = 0; i < jPanel2.getComponentCount(); i++) {
            JLabel lbl = (JLabel) jPanel2.getComponent(i);
            if (lbl.getText().equals("*")) {
                basarı = false;
                break;
            }
        }

        if (basarı) {
            JOptionPane.showMessageDialog(this, "Tebrikler! Kelimeyi buldunuz: " + kelime);
            timer.stop();
            oyunKaydet("KAZANDI");
        }
    
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String kelimeTahmin = jTextField2.getText().toUpperCase();
        
        if (kelimeTahmin.equals(kelime)) {
            
            for (int i = 0; i < jPanel2.getComponentCount(); i++) {
                JLabel lbl = (JLabel) jPanel2.getComponent(i);
                lbl.setText(String.valueOf(kelime.charAt(i)));
            }
            JOptionPane.showMessageDialog(this, "Tebrikler! Kelimeyi buldunuz: " + kelime);
            timer.stop();
            oyunKaydet("KAZANDI");
        } 
        else {
            yanlisSayisi++;
            
            ImageIcon resim = new ImageIcon(resim_dosya + yanlisSayisi + ".jpg");
            jLabel1.setIcon(new ImageIcon(resim.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
            
            JOptionPane.showMessageDialog(this, "Yanlış kelime! Yanlış: " + yanlisSayisi);
            if (yanlisSayisi >= 11) {
                JOptionPane.showMessageDialog(this, "Adam asıldı! Doğru kelime: " + kelime);
                timer.stop();
                oyunKaydet("KAYBETTİ");
            }
        }
    
        jTextField2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        yeniOyun();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        bastanBasla();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        int secilenSatir = jTable1.getSelectedRow();
    
        JPasswordField pf = new JPasswordField();
        int sonuc = JOptionPane.showConfirmDialog(this, pf, "Şifrenizi girin:", JOptionPane.OK_CANCEL_OPTION);
    
        if (sonuc != JOptionPane.OK_OPTION)
            return;
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(metin_dosya + "sifre.txt"));
            String sifre = br.readLine().trim();
            br.close();
        
            String girilenSifre = new String(pf.getPassword()).trim();
        
            if (girilenSifre.equals(sifre)) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(secilenSatir);
                
                FileWriter fw = new FileWriter(metin_dosya + "oyunlar.txt");
                for (int i = 0; i < model.getRowCount(); i++) {
                    fw.write(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2) + "\n");
                }
                fw.close();
                JOptionPane.showMessageDialog(this, "Satır silindi!");

            } 
            else {
                JOptionPane.showMessageDialog(this, "Yanlış şifre!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int secilenSatir = jTable2.getSelectedRow();
    
        JPasswordField pf = new JPasswordField();
        int sonuc = JOptionPane.showConfirmDialog(this, pf, "Şifrenizi girin:", JOptionPane.OK_CANCEL_OPTION);
    
        if (sonuc != JOptionPane.OK_OPTION)
            return;
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(metin_dosya + "sifre.txt"));
            String sifre = br.readLine().trim();
            br.close();
        
            String girilenSifre = new String(pf.getPassword()).trim();
        
            if (girilenSifre.equals(sifre)) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.removeRow(secilenSatir);
                
                FileWriter fw = new FileWriter(metin_dosya + "log.txt");
                for (int i = 0; i < model.getRowCount(); i++) {
                    fw.write("[" + model.getValueAt(i, 0) + "] " + model.getValueAt(i, 1) + " - " + model.getValueAt(i, 2) + "\n");
                }
                fw.close();
                
                JOptionPane.showMessageDialog(this, "Satır silindi!");
            } 
            else {
                JOptionPane.showMessageDialog(this, "Yanlış şifre!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OyunEkranı().setVisible(true));
    }
    
    private void RastgeleKelimeSec(){
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(metin_dosya + "kelimeler.txt"));
            java.util.List<String> liste = new java.util.ArrayList<>();
            String satir;
            while ((satir = br.readLine()) != null) {
                if (satir.trim().length() >= 6) {
                liste.add(satir.trim().toUpperCase());
                }
            }
            br.close();
            
            kelimeler = liste.toArray(new String[0]);
            java.util.Random r = new java.util.Random();
            kelime = kelimeler[r.nextInt(kelimeler.length)];
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
        }

        
        
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
