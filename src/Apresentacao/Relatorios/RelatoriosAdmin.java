package Apresentacao.Relatorios;

import Apresentacao.TelaAdmin;
import Persistencia.ConexaoPostgres;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class RelatoriosAdmin extends javax.swing.JFrame {

    public RelatoriosAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonUsuarios = new javax.swing.JButton();
        ButtonVoltar = new javax.swing.JButton();
        ButtonProdutos = new javax.swing.JButton();
        ButtonVendas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextoValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonUsuarios.setText("Usuários cadastrados");
        ButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUsuariosActionPerformed(evt);
            }
        });

        ButtonVoltar.setText("Voltar");
        ButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVoltarActionPerformed(evt);
            }
        });

        ButtonProdutos.setText("Produtos cadastrados");
        ButtonProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonProdutosActionPerformed(evt);
            }
        });

        ButtonVendas.setText("Pedidos por usuário");
        ButtonVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVendasActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor mínimo:");

        TextoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####0"))));
        TextoValor.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonVoltar)
                    .addComponent(ButtonProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoValor, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonUsuarios)
                .addGap(18, 18, 18)
                .addComponent(ButtonProdutos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonVendas)
                    .addComponent(jLabel1)
                    .addComponent(TextoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(ButtonVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUsuariosActionPerformed
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Relatorios\\usuarios.jrxml");
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, ConexaoPostgres.RetornaConexao());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonUsuariosActionPerformed

    private void ButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVoltarActionPerformed
        JFrame telaAdmin = new TelaAdmin();
        telaAdmin.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonVoltarActionPerformed

    private void ButtonProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonProdutosActionPerformed
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Relatorios\\produtos.jrxml");
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, ConexaoPostgres.RetornaConexao());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonProdutosActionPerformed

    private void ButtonVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVendasActionPerformed
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Relatorios\\vendas.jrxml");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("valor", Integer.parseInt(TextoValor.getText()));
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, ConexaoPostgres.RetornaConexao());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonVendasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonProdutos;
    private javax.swing.JButton ButtonUsuarios;
    private javax.swing.JButton ButtonVendas;
    private javax.swing.JButton ButtonVoltar;
    private javax.swing.JFormattedTextField TextoValor;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
