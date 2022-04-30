package Apresentacao;

import DTOs.PedidosDTO;
import DTOs.ProdutosDTO;
import Negocio.PedidosUsuario;
import Negocio.Produto;
import Persistencia.Pedidos;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class TelaRealizarPedidos extends javax.swing.JFrame {

    private int idDoUsuario;

    public TelaRealizarPedidos(int idDoUsuario) {
        initComponents();
        this.idDoUsuario = idDoUsuario;
        ArrayList<ProdutosDTO> produtos = new ArrayList();
        produtos = Produto.RetornaProdutos();
        for (ProdutosDTO produto : produtos) {
            ComboBoxComida.addItem(produto);
        }
        CarregarPedidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboBoxComida = new javax.swing.JComboBox<>();
        ButtonFazerPedido = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextoQuantidade = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaPedidos = new javax.swing.JTable();
        ButtonCancelarPedido = new javax.swing.JButton();
        ButtonAlterarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);

        ComboBoxComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxComidaActionPerformed(evt);
            }
        });

        ButtonFazerPedido.setText("Realizar pedido");
        ButtonFazerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFazerPedidoActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Comida:");

        jLabel2.setText("Quantidade:");

        TabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Quantidade", "Preço total", "Data do pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaPedidos);

        ButtonCancelarPedido.setText("Cancelar pedido");
        ButtonCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarPedidoActionPerformed(evt);
            }
        });

        ButtonAlterarPedido.setText("Alterar pedido");
        ButtonAlterarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAlterarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxComida, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ButtonCancelar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonFazerPedido)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonAlterarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonCancelarPedido))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBoxComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonFazerPedido)
                    .addComponent(ButtonCancelarPedido)
                    .addComponent(ButtonAlterarPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(ButtonCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonFazerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFazerPedidoActionPerformed
        PedidosUsuario.FazerPedido((ProdutosDTO) ComboBoxComida.getSelectedItem(), (int) TextoQuantidade.getValue(), idDoUsuario);
        CarregarPedidos();
    }//GEN-LAST:event_ButtonFazerPedidoActionPerformed

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        JFrame login = new TelaLogin();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    private void ComboBoxComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxComidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxComidaActionPerformed

    private void ButtonCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarPedidoActionPerformed
        PedidosUsuario.Excluir(Integer.parseInt(TabelaPedidos.getModel().getValueAt(TabelaPedidos.getSelectedRow(), 0).toString()));
        CarregarPedidos();
    }//GEN-LAST:event_ButtonCancelarPedidoActionPerformed

    private void ButtonAlterarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAlterarPedidoActionPerformed
        PedidosUsuario.Alterar(Integer.parseInt(TabelaPedidos.getModel().getValueAt(TabelaPedidos.getSelectedRow(), 0).toString()),(ProdutosDTO) ComboBoxComida.getSelectedItem(), (int) TextoQuantidade.getValue());
        CarregarPedidos();
    }//GEN-LAST:event_ButtonAlterarPedidoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRealizarPedidos(0).setVisible(true);
            }
        });
    }

    public void CarregarPedidos() {
        ((DefaultTableModel) TabelaPedidos.getModel()).setRowCount(0);
        ArrayList<PedidosDTO> pedidos = Pedidos.PedidosDoUsuario(idDoUsuario);
        DefaultTableModel dadosDaTabela = (DefaultTableModel) TabelaPedidos.getModel();

        for (PedidosDTO pedido : pedidos) {
            String dados[] = {pedido.id.toString(), pedido.descricao, pedido.quantidade.toString(), pedido.preco.toString(), pedido.data_do_pedido.toString()};
            dadosDaTabela.addRow(dados);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAlterarPedido;
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonCancelarPedido;
    private javax.swing.JButton ButtonFazerPedido;
    private javax.swing.JComboBox<ProdutosDTO> ComboBoxComida;
    private javax.swing.JTable TabelaPedidos;
    private javax.swing.JSpinner TextoQuantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
