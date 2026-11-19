package avaliaçãofinal.view;

import avaliaçãofinal.control.Controlador;
import javax.swing.JOptionPane;

public class View extends javax.swing.JFrame {

    private final Controlador controlador = new Controlador();
    private final ProdutoTableModel modelo = new ProdutoTableModel();

    public View() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void mostrar(String mensagem) {
        lblTempo.setText(mensagem);
        modelo.setProdutos(controlador.getResultado());
    }

    private void erro(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbArquivo = new javax.swing.JComboBox<>();
        btnCarregar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCampo = new javax.swing.JComboBox<>();
        cbAlgoritimo = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbTecnica = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnRelatório = new javax.swing.JButton();
        lblTempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catálogo de Produtos");

        cbArquivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "produtos_1000.txt", "produtos_10000.txt", "produtos_50000.txt" }));

        btnCarregar.setText("Carregar");
        btnCarregar.addActionListener(this::btnCarregarActionPerformed);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(this::btnExportarActionPerformed);

        jLabel1.setText("Campo:");

        jLabel2.setText("Algoritmo:");

        cbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Preço", "Id" }));

        cbAlgoritimo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insertion Sort", "Merge Sort" }));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(this::btnOrdenarActionPerformed);

        jLabel3.setText("Busca:");

        cbTecnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linear", "Binária", "HashMap", "Categoria" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblProdutos.setModel(modelo);
        jScrollPane1.setViewportView(tblProdutos);

        btnRelatório.setText("Gerar relatório");
        btnRelatório.addActionListener(this::btnRelatórioActionPerformed);

        lblTempo.setText("Tempo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCarregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExportar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbAlgoritimo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbTecnica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnOrdenar, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(txtBusca))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelatório)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarregar)
                    .addComponent(btnExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlgoritimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRelatório)
                    .addComponent(lblTempo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
        try {
            mostrar(controlador.carregar((String) cbArquivo.getSelectedItem()));
        } catch (Exception e) {
            erro(e);
        }
    }//GEN-LAST:event_btnCarregarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            mostrar(controlador.exportar("produtos_exportados.txt"));
        } catch (Exception e) {
            erro(e);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        try {
            mostrar(controlador.ordenar((String) cbCampo.getSelectedItem(), (String) cbAlgoritimo.getSelectedItem()));
        } catch (Exception e) {
            erro(e);
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            mostrar(controlador.buscar((String) cbTecnica.getSelectedItem(), txtBusca.getText()));
        } catch (Exception e) {
            erro(e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRelatórioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatórioActionPerformed
        try {
            mostrar(controlador.gerarRelatorio());
        } catch (Exception e) {
            erro(e);
        }
    }//GEN-LAST:event_btnRelatórioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCarregar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRelatório;
    private javax.swing.JComboBox<String> cbAlgoritimo;
    private javax.swing.JComboBox<String> cbArquivo;
    private javax.swing.JComboBox<String> cbCampo;
    private javax.swing.JComboBox<String> cbTecnica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
