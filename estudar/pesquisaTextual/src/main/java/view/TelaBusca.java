package view;

import controller.ControladorBusca;

// View (MVC): tela criada no editor visual do NetBeans
public class TelaBusca extends javax.swing.JFrame {

    private ControladorBusca controlador;

    public TelaBusca() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscar = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        chkMaiusculas = new javax.swing.JCheckBox();
        btnAnterior = new javax.swing.JButton();
        btnProxima = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaTexto = new javax.swing.JTextArea();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisa Textual");

        lblBuscar.setText("Buscar:");

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        chkMaiusculas.setText("Diferenciar maiúsculas");
        chkMaiusculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMaiusculasActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProxima.setText("Próxima");
        btnProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaActionPerformed(evt);
            }
        });

        txaTexto.setColumns(20);
        txaTexto.setLineWrap(true);
        txaTexto.setRows(5);
        txaTexto.setWrapStyleWord(true);
        txaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaTextoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txaTexto);

        lblStatus.setText("Digite algo no campo de busca.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMaiusculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMaiusculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Eventos dos componentes: cada um só avisa o controlador
    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        controlador.termoDigitado();
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        controlador.proxima();
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txaTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaTextoKeyReleased
        controlador.textoEditado();
    }//GEN-LAST:event_txaTextoKeyReleased

    private void chkMaiusculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMaiusculasActionPerformed
        controlador.maiusculasAlterado();
    }//GEN-LAST:event_chkMaiusculasActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        controlador.anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaActionPerformed
        controlador.proxima();
    }//GEN-LAST:event_btnProximaActionPerformed

    public void setControlador(ControladorBusca controlador) {
        this.controlador = controlador;
    }

    // Getters usados pelo controlador
    public javax.swing.JTextField getTxtBusca() {
        return txtBusca;
    }

    public javax.swing.JCheckBox getChkMaiusculas() {
        return chkMaiusculas;
    }

    public javax.swing.JButton getBtnAnterior() {
        return btnAnterior;
    }

    public javax.swing.JButton getBtnProxima() {
        return btnProxima;
    }

    public javax.swing.JTextArea getTxaTexto() {
        return txaTexto;
    }

    public javax.swing.JLabel getLblStatus() {
        return lblStatus;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnProxima;
    private javax.swing.JCheckBox chkMaiusculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextArea txaTexto;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
