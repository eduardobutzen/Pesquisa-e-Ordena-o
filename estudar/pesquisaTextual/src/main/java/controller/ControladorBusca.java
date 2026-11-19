package controller;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import model.BuscaKMP;
import model.Ocorrencia;
import view.TelaBusca;

// Controller (MVC): recebe os eventos da tela e chama a busca KMP
public class ControladorBusca {

    private static final Color COR_OCORRENCIA = new Color(255, 236, 130);
    private static final Color COR_SELECIONADA = new Color(255, 160, 60);

    private final TelaBusca tela;
    private final BuscaKMP buscador;
    private final Highlighter.HighlightPainter pintorOcorrencia =
            new DefaultHighlighter.DefaultHighlightPainter(COR_OCORRENCIA);
    private final Highlighter.HighlightPainter pintorSelecionada =
            new DefaultHighlighter.DefaultHighlightPainter(COR_SELECIONADA);

    private List<Ocorrencia> ocorrencias = new ArrayList<>();
    private int selecionada = -1;

    public ControladorBusca(TelaBusca tela, BuscaKMP buscador) {
        this.tela = tela;
        this.buscador = buscador;
        ligarEventos();
        refazerBusca(false);
    }

    private void ligarEventos() {
        tela.getTxtBusca().getDocument().addDocumentListener(new AoMudarDocumento(true));
        tela.getTxaTexto().getDocument().addDocumentListener(new AoMudarDocumento(false));

        tela.getChkMaiusculas().addActionListener(e -> refazerBusca(true));
        tela.getBtnProxima().addActionListener(e -> irPara(selecionada + 1));
        tela.getBtnAnterior().addActionListener(e -> irPara(selecionada - 1));
        tela.getTxtBusca().addActionListener(e -> irPara(selecionada + 1));
    }

    private void refazerBusca(boolean termoMudou) {
        String texto = tela.getTxaTexto().getText();
        String termo = tela.getTxtBusca().getText();
        int anterior = selecionada;

        ocorrencias = buscador.procurar(texto, termo, tela.getChkMaiusculas().isSelected());

        // Termo novo: vai para a 1ª ocorrência. Texto editado: tenta manter a mesma
        if (ocorrencias.isEmpty()) {
            selecionada = -1;
        } else if (termoMudou || anterior < 0) {
            selecionada = 0;
        } else {
            selecionada = Math.min(anterior, ocorrencias.size() - 1);
        }

        destacar();
        if (termoMudou && selecionada >= 0) {
            rolarAte(ocorrencias.get(selecionada));
        }
        atualizarStatus(termo);
    }

    private void irPara(int indice) {
        if (ocorrencias.isEmpty()) {
            return;
        }
        int total = ocorrencias.size();
        // Depois da última volta para a primeira (e vice-versa)
        selecionada = ((indice % total) + total) % total;
        destacar();
        rolarAte(ocorrencias.get(selecionada));
        atualizarStatus(tela.getTxtBusca().getText());
    }

    private void destacar() {
        Highlighter marcador = tela.getTxaTexto().getHighlighter();
        marcador.removeAllHighlights();
        for (int i = 0; i < ocorrencias.size(); i++) {
            Ocorrencia o = ocorrencias.get(i);
            Highlighter.HighlightPainter pintor = (i == selecionada) ? pintorSelecionada : pintorOcorrencia;
            try {
                marcador.addHighlight(o.inicio(), o.fim(), pintor);
            } catch (BadLocationException ignorada) {
            }
        }
    }

    private void rolarAte(Ocorrencia o) {
        JTextArea area = tela.getTxaTexto();
        try {
            Rectangle2D inicio = area.modelToView2D(o.inicio());
            Rectangle2D fim = area.modelToView2D(o.fim());
            if (inicio != null && fim != null) {
                area.scrollRectToVisible(inicio.createUnion(fim).getBounds());
            }
        } catch (BadLocationException ignorada) {
        }
    }

    private void atualizarStatus(String termo) {
        String mensagem;
        if (termo.isEmpty()) {
            mensagem = "Digite algo no campo de busca.";
        } else if (ocorrencias.isEmpty()) {
            mensagem = "Nenhuma ocorrência de \"" + termo + "\".";
        } else {
            mensagem = "Ocorrência " + (selecionada + 1) + " de " + ocorrencias.size();
        }
        tela.getLblStatus().setText(mensagem);

        boolean temResultado = !ocorrencias.isEmpty();
        tela.getBtnAnterior().setEnabled(temResultado);
        tela.getBtnProxima().setEnabled(temResultado);
    }

    // Refaz a busca sempre que o termo ou o texto muda
    private class AoMudarDocumento implements DocumentListener {

        private final boolean ehOTermo;

        AoMudarDocumento(boolean ehOTermo) {
            this.ehOTermo = ehOTermo;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            SwingUtilities.invokeLater(() -> refazerBusca(ehOTermo));
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            SwingUtilities.invokeLater(() -> refazerBusca(ehOTermo));
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }
}
