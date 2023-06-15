package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Estudante;
import model.EstudanteStorage;

public class CadastroListPanel extends JPanel{
    private AppFrame frame;
    private JButton novaTarefaBtn;
    private JButton editarTarefaBtn;
    private JButton removerTarefaBtn;
    private JTable tabela;
    private CadastroTableModel tableModel;

    public CadastroListPanel(AppFrame appFrame) {
        frame = appFrame;

        setLayout(new BorderLayout(10, 10));

        criarComandosPanel();
        criarTabelaPanel();
    }

    public void recarregar() {
        tableModel.carregar(EstudanteStorage.listar());
    }

    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        novaTarefaBtn = new JButton("Criar Nova");
        novaTarefaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaEstudantes(null);
            }
        });
        panel.add(novaTarefaBtn);

        editarTarefaBtn = new JButton("Alterar");
        editarTarefaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaEstudantes(CadastroTableModel.getEstudante(tabela.getSelectedRow()));
            }
        });
        panel.add(editarTarefaBtn);

        removerTarefaBtn = new JButton("Remover");
        removerTarefaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Estudante estudante = tableModel.getEstudante(tabela.getSelectedRow());
                int resposta = JOptionPane.showConfirmDialog(CadastroListPanel.this, "Deseja realmente remover?",
                        AppFrame.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resposta == JOptionPane.YES_OPTION) {
                    EstudanteStorage.remover(estudante);
                    tableModel.remover(estudante);
                }
            }
        });
        panel.add(removerTarefaBtn);

        add(panel, BorderLayout.NORTH);

        desabilitarBtns();
    }

    private void criarTabelaPanel() {
        JPanel panel = new JPanel();

        tableModel = new CadastroTableModel(EstudanteStorage.listar());
        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (tabela.getSelectedRow() >= 0) {
                        habilitarBtns();
                    } else {
                        desabilitarBtns();
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    private void habilitarBtns() {
        editarTarefaBtn.setEnabled(true);
        removerTarefaBtn.setEnabled(true);
    }

    private void desabilitarBtns() {
        editarTarefaBtn.setEnabled(false);
        removerTarefaBtn.setEnabled(false);
    }
}
