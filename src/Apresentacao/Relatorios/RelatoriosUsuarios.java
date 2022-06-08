package Apresentacao.Relatorios;

import Apresentacao.TelaAdmin;
import Apresentacao.TelaUsuarios;
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

public class RelatoriosUsuarios extends javax.swing.JFrame {

    int idDoUsuario;

    public RelatoriosUsuarios(int idDoUsuario) {
        initComponents();
        this.idDoUsuario = idDoUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonPedidos = new javax.swing.JButton();
        ButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextoValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonPedidos.setText("Pedidos realizados");
        ButtonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPedidosActionPerformed(evt);
            }
        });

        ButtonVoltar.setText("Voltar");
        ButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Acima de qual valor:");

        TextoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#######0"))));
        TextoValor.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonPedidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextoValor, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonVoltar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonPedidos)
                    .addComponent(jLabel1)
                    .addComponent(TextoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(ButtonVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPedidosActionPerformed
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("src\\Relatorios\\pedidos.jrxml");
            Map parameters = new HashMap();
            parameters.put("id_usuario_parametro", idDoUsuario);
            parameters.put("valor", Integer.parseInt(TextoValor.getText()));
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, ConexaoPostgres.RetornaConexao());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonPedidosActionPerformed

    private void ButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVoltarActionPerformed
        JFrame telaUsuarios = new TelaUsuarios(idDoUsuario);
        telaUsuarios.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonVoltarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosUsuarios(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPedidos;
    private javax.swing.JButton ButtonVoltar;
    private javax.swing.JFormattedTextField TextoValor;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
