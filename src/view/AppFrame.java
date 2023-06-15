package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Estudante;

public class AppFrame extends JFrame {
    public static final String titulo = "Cadastro de Estudantes";

    private CardLayout layout;
    private JPanel cardsPane;

    private CadastroListPanel cadastroListPanel;
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
        cadastroListPanel.recarregar();
        layout.show(cardsPane, CadastroListPanel.class.getName());
    }

    public void mostrarFormCadastro(Estudante estudante) {
        cadastroFormPanel.setEstudante(estudante);
        layout.show(cardsPane, CadastroFormPanel.class.getName());
    }

    private void criarCards() {
        cadastroListPanel = new CadastroListPanel(this);
        cardsPane.add(cadastroListPanel, CadastroListPanel.class.getName());

        cadastroFormPanel = new CadastroFormPanel(this);
        cardsPane.add(cadastroFormPanel, CadastroFormPanel.class.getName());
    }
}