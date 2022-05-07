/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Apresentacao;

import javax.swing.JFrame;

/**
 *
 * @author thoma
 */
public class TelaUsuarios extends javax.swing.JFrame {
    int idDoUsuario;
    
    public TelaUsuarios(int idDoUsuario) {
        this.idDoUsuario = idDoUsuario;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonPedidos = new javax.swing.JButton();
        ButtonSair = new javax.swing.JButton();
        ButtonConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonPedidos.setText("Pedidos");
        ButtonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPedidosActionPerformed(evt);
            }
        });

        ButtonSair.setText("Sair");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        ButtonConta.setText("Conta");
        ButtonConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ButtonConta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonPedidos)
                    .addComponent(ButtonConta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(ButtonSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
        JFrame login = new TelaLogin();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void ButtonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPedidosActionPerformed
        JFrame realizarPedidos = new TelaRealizarPedidos(idDoUsuario);
        realizarPedidos.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonPedidosActionPerformed

    private void ButtonContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonContaActionPerformed
        JFrame configuracaoConta = new TelaConfigConta(idDoUsuario);
        configuracaoConta.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonContaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuarios(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonConta;
    private javax.swing.JButton ButtonPedidos;
    private javax.swing.JButton ButtonSair;
    // End of variables declaration//GEN-END:variables
}
