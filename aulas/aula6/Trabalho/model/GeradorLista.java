package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorLista {

    public static List<Integer> gerar(int quantidade) {
        Random gerador = new Random();
        List<Integer> lista = new ArrayList<>(quantidade);
        for (int i = 0; i < quantidade; i++) {
            lista.add(gerador.nextInt(100000));
        }
        return lista;
    }

    public static List<Integer> copiar(List<Integer> lista) {
        return new ArrayList<>(lista);
    }
}
