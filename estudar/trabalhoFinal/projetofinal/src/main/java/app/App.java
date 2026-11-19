/*
 * Autor(es): Eduardo Butzen
 * Turma:     Pesquisa e Ordenação
 */
package app;

import controller.ControladorProdutos;
import javax.swing.SwingUtilities;
import view.TelaPrincipal;

// Inicia o programa
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();

            new ControladorProdutos(tela);

            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });
    }
}
