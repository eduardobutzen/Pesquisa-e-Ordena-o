package view;

import model.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

// Colunas da tabela
public class ProdutoTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final String[] COLUNAS = {"Id", "Nome", "Categoria", "Preço (R$)", "Estoque"};

    private transient List<Produto> dados = List.of();

    public void setProdutos(List<Produto> produtos) {
        dados = produtos == null ? List.of() : produtos;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return COLUNAS.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return COLUNAS[coluna];
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        return switch (coluna) {
            case 0, 4 -> Integer.class;
            case 3 -> Double.class;
            default -> String.class;
        };
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto p = dados.get(linha);
        return switch (coluna) {
            case 0 -> p.getId();
            case 1 -> p.getNome();
            case 2 -> p.getCategoria();
            case 3 -> p.getPreco();
            default -> p.getEstoque();
        };
    }
}
