package app;

import controller.ControladorBusca;
import javax.swing.SwingUtilities;
import model.BuscaKMP;
import view.TelaBusca;

// Ponto de entrada: cria a View e o Model e liga os dois pelo Controller (MVC)
public class App {

    private static final String TEXTO_EXEMPLO =
            "Cole ou digite aqui o texto onde você quer pesquisar.\n\n"
            + "A arara do zoológico gritava \"ararara\" toda manhã. "
            + "Procure por \"arara\" e veja que ela aparece duas vezes dentro de "
            + "\"ararara\": o algoritmo KMP também encontra ocorrências que se sobrepõem.\n\n"
            + "Marque \"Diferenciar maiúsculas\" para que Arara e arara deixem de ser iguais.";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaBusca tela = new TelaBusca();
            tela.getTxaTexto().setText(TEXTO_EXEMPLO);

            new ControladorBusca(tela, new BuscaKMP());

            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });
    }
}
