//inicio da classe pessoa :)
public class Pessoa {
	private int id;
	private String nome;
	private String email;
	private String endereço;
	private String CEP;
	private String telefone;
	private String usuario;
	private String senha;
	private String curso;
	private String textolivre;
	private Boolean ativo;
	
	public Pessoa(int id, String nome, String email, String CEP, String telefone, String usuario, String senha, String curso, String textolivre, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.CEP = CEP;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
        this.curso = curso;
        this.textolivre = textolivre;
        this.ativo = ativo;
        
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail( ) {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEndereço() {
    	return endereço;
    }
    
    public void setEndereço(String endereço) {
    	this.endereço = endereço;
    }
    
    public String getCEP() {
    	return CEP;
    }
    
    public void setCEP(String CEP ) {
    	this.CEP = CEP;
    	
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
    
    public Boolean getAtivo() {
    	return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
    	this.ativo = ativo;
    }
}

// fim da classe pessoa