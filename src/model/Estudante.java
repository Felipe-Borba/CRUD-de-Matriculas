package model;

import javax.swing.*;

//inicio da classe pessoa :)
public class Estudante {
	private int id;
	private String nome;
    private int idade;
	private String email;
	private String endereco;
	private String cep;
	private String telefone;
	private String usuario;
	private String senha;
	private String curso;
	private String textolivre;
    private JComboBox<String> ativoComboBox;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail( ) {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEndereco() {
    	return endereco;
    }
    
    public void setEndereco(String endereco) {
    	this.endereco = endereco;
    }
    
    public String getCep() {
    	return cep;
    }
    
    public void setCep(String cep) {
    	this.cep = cep;
    	
    }
    
    public String getTelefone() {
    	return telefone;
    }
    
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }
    
    public String getUsuario() {
    	return usuario;
    }
    
    public void setUsuario(String usuario) {
    	this.usuario = usuario;
    }
    
    public String getSenha() {
    	return senha;
    	
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
    public String getCurso() {
    	return curso;
    }
    
    public void setCurso(String curso) {
    	this.curso = curso;
    }
    
    public String getTextolivre() {
    	return textolivre;
    	
    }
    
    public void setTextolivre(String textolivre) {
    	this.textolivre = textolivre;
    }


    public JComboBox<String> getAtivoComboBox() {
        return ativoComboBox;
    }

    public boolean isAtivo() {
        return ativoComboBox.getSelectedItem().equals("Sim");
    }

    public void setAtivo(boolean ativo) {
        if (ativo) {
            ativoComboBox.setSelectedItem("Sim");
        } else {
            ativoComboBox.setSelectedItem("Não");
        }
    }

    @Override
    public String toString() {
        return String.format("%d: %s, %s\n", id, nome, idade, email, cep, telefone, usuario, senha, curso, textolivre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Estudante tarefa = (Estudante) obj;
        return id == tarefa.id;
    }
}

// fim da classe pessoa