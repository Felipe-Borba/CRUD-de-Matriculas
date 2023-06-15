package view;

import model.Estudante;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<Estudante> estudantes = new ArrayList<Estudante>();
    private String[] colunas = new String[]{"Id", "Nome", "idade"};

    public TableModel(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    @Override
    public int getRowCount() {
        return estudantes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName = null;

        if (columnIndex >= 0 && columnIndex < colunas.length) {
            columnName = colunas[columnIndex];
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String value = null;

        if (rowIndex >= 0 && rowIndex < estudantes.size()) {
            Estudante estudante = estudantes.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    value = Integer.toString(estudante.getId());
                    break;
                case 1:
                    value = estudante.getNome();
                    break;
                case 2:
                    value = Integer.toString(estudante.getIdade());
                    break;
                default:
                    System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
            }
        }

        return value;
    }

    public Estudante getTarefa(int rowIndex) {
        Estudante estudante = null;

        if (rowIndex >= 0 && rowIndex < estudantes.size()) {
            estudante = estudantes.get(rowIndex);
        }

        return estudante;
    }

    public void carregar(List<Estudante> estudantes) {
        this.estudantes = estudantes;
        fireTableDataChanged();
    }

    public void remover(Estudante estudante) {
        estudantes.remove(estudante);
        fireTableDataChanged();
    }

}
