package view;

import model.Estudante;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

import model.Estudante;
import model.EstudanteStorage;

public class CadastroFormPanel extends JPanel {

    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private Estudante estudante;

    private AppFrame frame;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField idTxt;
    private JTextField nomeTxt;
    private JTextField idadeTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
    private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField usuarioTxt;
    private JPasswordField senhaPss;
    private JTextField cursoTxt;
    private JTextArea textolivreTxt;
    private JCheckBox ativoComboBox;
    private JButton salvarBtn;
    private JButton cancelarBtn;


    public CadastroFormPanel(AppFrame appFrame) {
        frame = appFrame;

        estudante = null;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (estudante == null) {
                    idTxt.setText("");
                    nomeTxt.setText("");
                    idadeTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
                    cepTxt.setText("");
                    telefoneTxt.setText("");
                    usuarioTxt.setText("");
                    senhaPss.setText("");
                    cursoTxt.setText("");
                    textolivreTxt.setText("");
                    ativoComboBox.setSelectedItem("Sim");
                } else {
                    idTxt.setText(Integer.toString(estudante.getId()));
                    nomeTxt.setText(estudante.getNome());
                    idadeTxt.setText(Integer.toString(estudante.getIdade()));
                    emailTxt.setText(estudante.getEmail());
                    enderecoTxt.setText(estudante.getEndereco());
                    cepTxt.setText(estudante.getCep());
                    telefoneTxt.setText(estudante.getTelefone());
                    usuarioTxt.setText(estudante.getUsuario());
                    senhaPss.setText(estudante.getSenha());
                    cursoTxt.setText(estudante.getCurso());
                    textolivreTxt.setText(estudante.getTelefone());
                    ativoComboBox.setSelectedItem(estudante.isAtivo() ? "Sim" : "Não");
                }
            }
        });

        criarForm();
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    private void criarForm() {
        JLabel rotulo;

        rotulo = new JLabel("Id");
        adicionarComponente(rotulo, 0, 0);
        idTxt = new JTextField(5);
        idTxt.setEditable(false);
        adicionarComponente(idTxt, 0, 1);

        rotulo = new JLabel("Nome");
        adicionarComponente(rotulo, 1, 0);
        nomeTxt = new JTextField(30);
        adicionarComponente(nomeTxt, 1, 1);

        rotulo = new JLabel("Idade");
        adicionarComponente(rotulo, 2, 0);
        idadeTxt = new JTextField(30);
        adicionarComponente(idadeTxt, 2, 1);

        rotulo = new JLabel("Email");
        adicionarComponente(rotulo, 3, 0);
        emailTxt = new JTextField(30);
        adicionarComponente(emailTxt, 3, 1);

        rotulo = new JLabel("Endereço");
        adicionarComponente(rotulo, 4, 0);
        enderecoTxt = new JTextField(30);
        adicionarComponente(enderecoTxt, 4, 1);


        rotulo = new JLabel("CEP");
        adicionarComponente(rotulo, 5, 0);
        cepTxt = new JTextField(30);
        adicionarComponente(cepTxt, 5, 1);

        rotulo = new JLabel("Telefone");
        adicionarComponente(rotulo, 6, 0);
        telefoneTxt = new JTextField(30);
        adicionarComponente(telefoneTxt, 6, 1);

        rotulo = new JLabel("Usuario");
        adicionarComponente(rotulo, 7, 0);
        usuarioTxt = new JTextField(30);
        adicionarComponente(usuarioTxt, 7, 1);

        rotulo = new JLabel("Senha");
        adicionarComponente(rotulo, 8, 0);
        senhaPss = new JPasswordField(30);
        adicionarComponente(senhaPss, 8, 1);

        rotulo = new JLabel("Curso");
        adicionarComponente(rotulo, 9, 0);
        cursoTxt = new JTextField(30);
        adicionarComponente(cursoTxt, 9, 1);

        rotulo = new JLabel("Texto Livre");
        adicionarComponente(rotulo, 10, 0);
        textolivreTxt = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(textolivreTxt);
        adicionarComponente(scrollPane, 10, 1, 1, 5);

        rotulo = new JLabel("Ativo");
        adicionarComponente(rotulo, 11, 0);
        ativoComboBox = new JComboBox<>(new String[]{"Sim", "Não"});
        adicionarComponente(ativoComboBox, 11, 1);

        criarBotoes();
    }

    private void criarBotoes() {
        JPanel btnPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        criarSalvarBtn(btnPanel);
        criarCancelarBtn(btnPanel);

        adicionarComponente(btnPanel, 7, 1, 2, 1);
    }

    private void criarSalvarBtn(JPanel panel) {
        salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estudante == null) {
                    estudante = new Estudante();
                    estudante.setNome(nomeTxt.getText());
                    estudante.setIdade(Integer.parseInt(idadeTxt.getText()));
                    estudante.setEmail(emailTxt.getText());
                    estudante.setCep(cepTxt.getText());
                    estudante.setTelefone(telefoneTxt.getText());
                    estudante.setUsuario(usuarioTxt.getText());
                    estudante.setSenha(senhaPss.getText());
                    estudante.setCurso(cursoTxt.getText());
                    estudante.setTextolivre(textolivreTxt.getText());
                    EstudanteStorage.inserir(estudante);
                } else {
                    estudante.setId(Integer.parseInt(idTxt.getText()));
                    estudante.setNome(nomeTxt.getText());
                    estudante.setIdade(Integer.parseInt(idadeTxt.getText()));
                    estudante.setEmail(emailTxt.getText());
                    estudante.setCep(cepTxt.getText());
                    estudante.setTelefone(telefoneTxt.getText());
                    estudante.setUsuario(usuarioTxt.getText());
                    estudante.setSenha(senhaPss.getText());
                    estudante.setCurso(cursoTxt.getText());
                    estudante.setTextolivre(textolivreTxt.getText());
                    EstudanteStorage.atualizar(estudante);
                }

                JOptionPane.showMessageDialog(CadastroFormPanel.this, "Informações do estudante foram salvas com sucesso!", AppFrame.titulo,
                        JOptionPane.INFORMATION_MESSAGE);

                frame.mostrarListaEstudantes(tableModel.getEstudante(tabela.getSelectedRow()));
            }
        });
        panel.add(salvarBtn);
    }

    private void criarCancelarBtn(JPanel panel) {
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaEstudantes(tableModel.getEstudante(tabela.getSelectedRow()));
            }
        });
        panel.add(cancelarBtn);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.gridwidth = largura;
        constraints.gridheight = altura;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(componente, constraints);
        add(componente);
    }
}
