package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Estudante;

public class AppFrame extends JFrame {
    public static final String titulo = "Cadastro de Estudantes";

    private CardLayout layout;
    private JPanel cardsPane;

    private InicialPanel inicialPanel;
    private TarefaListPanel tarefaListPanel;
    private CadastroFormPanel cadastroFormPanel;

    public AppFrame() {
        super(titulo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();

        cardsPane = new JPanel();
        cardsPane.setLayout(layout);
        add(cardsPane);

        criarCards();
    }

    public void mostrar() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mostrarListaEstudantes() {
        tarefaListPanel.recarregar();
        layout.show(cardsPane, TarefaListPanel.class.getName());
    }

    public void mostrarFormCadastro(Estudante estudante) {
        CadastroFormPanel.setEstudante(estudante);
        layout.show(cardsPane, CadastroFormPanel.class.getName());
    }

    private void criarCards() {
        inicialPanel = new InicialPanel(this);
        cardsPane.add(inicialPanel, InicialPanel.class.getName());

        tarefaListPanel = new TarefaListPanel(this);
        cardsPane.add(tarefaListPanel, TarefaListPanel.class.getName());

        CadastroFormPanel = new CadastroFormPanel(this);
        cardsPane.add(cadastroFormPanel, CadastroFormPanel.class.getName());
    }
}