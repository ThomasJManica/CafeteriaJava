package Apresentacao;

public class TelaAlerta extends javax.swing.JPanel {
    public TelaAlerta(String texto) {
        initComponents();
        TextoAlerta.setText(texto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonOk = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoAlerta = new javax.swing.JTextArea();

        ButtonOk.setText("Ok");
        ButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOkActionPerformed(evt);
            }
        });

        TextoAlerta.setColumns(20);
        TextoAlerta.setRows(5);
        jScrollPane1.setViewportView(TextoAlerta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(ButtonOk)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOkActionPerformed
        setVisible(false);
    }//GEN-LAST:event_ButtonOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtonOk;
    private javax.swing.JTextArea TextoAlerta;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
