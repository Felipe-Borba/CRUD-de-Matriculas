package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Estudante;

public class CadastroTableModel extends AbstractTableModel {
    private List<Estudante> estudantes = new ArrayList<Estudante>();
    private String[] colunas = new String[] { "Id", "Nome", "Idade", "Email", "Endereço", "CEP", "Telefone", "Usuario", "Senha", "Curso", "Texto Livre", "Ativo" };

    public CadastroTableModel(List<Estudante> estudantes) {
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
                case 3:
                    value = estudante.getEmail();
                    break;
                case 4:
                    value = estudante.getEndereco();
                    break;
                case 5:
                    value = estudante.getCep();
                    break;
                case 6:
                    value = estudante.getTelefone();
                    break;
                case 7:
                    value = estudante.getUsuario();
                    break;
                case 8:
                    value = estudante.getSenha();
                    break;
                case 9:
                    value = estudante.getCurso();
                    break;
                case 10:
                    value = estudante.getTextolivre();
                    break;
                case 11:
                    value = String.valueOf(estudante.getAtivo());
                    break;
                default:
                    System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
            }
        }

        return value;
    }

    public Estudante getEstudante(int rowIndex) {
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
