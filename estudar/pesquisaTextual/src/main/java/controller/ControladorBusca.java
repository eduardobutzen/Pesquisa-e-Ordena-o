package controller;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import model.BuscaKMP;
import model.Ocorrencia;
import view.TelaBusca;

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
    private String ultimoTermo = "";
    private String ultimoTexto = "";

    public ControladorBusca(TelaBusca tela, BuscaKMP buscador) {
        this.tela = tela;
        this.buscador = buscador;
        tela.setControlador(this);
        refazerBusca(false);
    }

    // Chamados pela tela
    public void termoDigitado() {
        if (!tela.getTxtBusca().getText().equals(ultimoTermo)) {
            refazerBusca(true);
        }
    }

    public void textoEditado() {
        if (!tela.getTxaTexto().getText().equals(ultimoTexto)) {
            refazerBusca(false);
        }
    }

    public void maiusculasAlterado() {
        refazerBusca(true);
    }

    public void proxima() {
        irPara(selecionada + 1);
    }

    public void anterior() {
        irPara(selecionada - 1);
    }

    private void refazerBusca(boolean termoMudou) {
        String texto = tela.getTxaTexto().getText();
        String termo = tela.getTxtBusca().getText();
        int anterior = selecionada;
        ultimoTexto = texto;
        ultimoTermo = termo;

        ocorrencias = buscador.procurar(texto, termo, tela.getChkMaiusculas().isSelected());

        // Escolhe qual ocorrência fica selecionada
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
        // Depois da última volta para a primeira
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
}
