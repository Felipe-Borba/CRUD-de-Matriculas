package view;

import model.EstudanteStorage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListPanel extends JPanel {
    private final AppFrame appFrame;
    private final JButton novaMatriculaBtn = new JButton("Criar Matrícula");
    private final JButton editarMatriculaBtn = new JButton("Editar Matrícula");
    private final JButton removerMatriculaBtn = new JButton("Remover Matrícula");
    private TableModel tableModel;
    private JTable tabela;

    public ListPanel(AppFrame appFrame) {
        setLayout(new BorderLayout(10, 10));
        this.appFrame = appFrame;

        criarComandosPanel();
        criarTabelaPanel();
    }

    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.CENTER);

        panel.add(this.novaMatriculaBtn);
        //todo add change page listener

        panel.add(this.editarMatriculaBtn);
        // todo add edit user listener

        panel.add(this.removerMatriculaBtn);
        //todo add remove matricula lister

        add(panel, BorderLayout.NORTH);
    }

    private void criarTabelaPanel() {
        JPanel panel = new JPanel();

        this.tableModel = new TableModel(EstudanteStorage.listar());
        this.tabela = new JTable(tableModel);

        this.setTabelaSelectionMode();

        JScrollPane scrollPane = new JScrollPane(this.tabela);
        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    private void setTabelaSelectionMode() {
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
    }

    public void recarregar() {
        tableModel.carregar(EstudanteStorage.listar());
    }

    private void habilitarBtns() {
        editarMatriculaBtn.setEnabled(true);
        removerMatriculaBtn.setEnabled(true);
    }

    private void desabilitarBtns() {
        editarMatriculaBtn.setEnabled(false);
        removerMatriculaBtn.setEnabled(false);
    }
}
