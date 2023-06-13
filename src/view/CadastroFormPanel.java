package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CadastroFormPanel {

    private JTextField idTxt;
    private JTextField nomeTxt;
    private JTextField emailTxt;
    private JTextField CEPTxt;

    private JTextArea descricaoTxt;
    private JButton salvarBtn;
    private JButton cancelarBtn;
}
