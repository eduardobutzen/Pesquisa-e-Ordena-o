package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

// Testes dos arquivos
class GerenciadorArquivosTest {

    @Test
    void leOArquivoSemOCabecalho() throws Exception {
        assertEquals(1000, GerenciadorArquivos.ler("produtos_1000.txt").size());
    }

    // Salvar e ler deve dar o mesmo resultado
    @Test
    void salvarELerDeNovoDaOMesmoResultado(@TempDir Path pasta) throws Exception {
        ArrayList<Produto> original = GerenciadorArquivos.ler("produtos_1000.txt");
        String copia = pasta.resolve("copia.txt").toString();

        GerenciadorArquivos.salvar(original, copia);
        List<Produto> lida = GerenciadorArquivos.ler(copia);

        assertEquals(original.size(), lida.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).toLinha(), lida.get(i).toLinha());
        }
    }
}
