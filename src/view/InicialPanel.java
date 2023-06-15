package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InicialPanel extends JPanel {
    private AppFrame frame;
    private JButton cadastrotarefasBtn;

    public InicialPanel(AppFrame appFrame) {
        frame = appFrame;

        cadastrotarefasBtn = new JButton("Tarefas");
        cadastrotarefasBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaEstudantes(tableModel.getEstudante(tabela.getSelectedRow()));
            }
        });
        add(cadastrotarefasBtn);
    }

} // fim da class InicialPanel