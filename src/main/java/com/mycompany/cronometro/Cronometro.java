package com.mycompany.cronometro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Cronometro extends javax.swing.JFrame {
    Timer tiempo;
    int m = 0, s = 0, cs = 0;
    boolean iniciar = false;
    
    public Cronometro() {
        initComponents();
        tiempo = new Timer(10, conteo);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public ActionListener conteo = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            cs++;
            if(cs == 100){
                cs = 0;
                s++;
            }
            
            if(s == 60){
                s = 0;
                m++;
                
            }
            actualizar();
        }
};
    
    private void actualizar() {
        String minuto, segundo, csegundo;
        
        minuto = m > 9 ? "" +m : "0" +m;
        segundo = s > 9 ? "" +s : "0" +s;
        csegundo = cs > 9 ? "" +cs : "0" +cs;
        
        lblCrono.setText(minuto +":"+ segundo +":"+ csegundo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCrono = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCrono.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblCrono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCrono.setText("00:00:00");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnDetener.setText("Detener");
        btnDetener.setEnabled(false);
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCrono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnDetener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if(!iniciar){
            tiempo.start();
            btnIniciar.setText("Parar");
            btnDetener.setEnabled(true);
            iniciar = true;
        }
        else{
            tiempo.stop();
            btnIniciar.setText("Reanudar");
            btnDetener.setEnabled(false);
            iniciar = false;
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed
        m = 0; s = 0; cs = 0;
        actualizar();
        
        tiempo.stop();
        btnIniciar.setText("Iniciar");
        btnDetener.setEnabled(false);
    }//GEN-LAST:event_btnDetenerActionPerformed

    public static void main(String args[]) {
        Cronometro crono = new Cronometro();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCrono;
    // End of variables declaration//GEN-END:variables
}
