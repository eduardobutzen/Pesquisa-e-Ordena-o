package model;

public class Resultado {

    private final String algoritmo;
    private final long qtdComparacoes;
    private final long qtdTrocas;
    private final long tempoNano;

    public Resultado(String algoritmo, long qtdComparacoes, long qtdTrocas, long tempoNano) {
        this.algoritmo = algoritmo;
        this.qtdComparacoes = qtdComparacoes;
        this.qtdTrocas = qtdTrocas;
        this.tempoNano = tempoNano;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public long getQtdComparacoes() {
        return qtdComparacoes;
    }

    public long getQtdTrocas() {
        return qtdTrocas;
    }

    public double getTempoMilissegundos() {
        return tempoNano / 1_000_000.0;
    }
}
