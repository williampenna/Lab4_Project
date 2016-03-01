package br.com.fatec.projeto.api.entity;

public class Usuario {
	
	public static final String TABLE = "PROJETO_TESTE_USUARIO";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_LOGIN = "LOGIN";
	public static final String COL_SENHA = "SENHA";
	
	private Long id;
	private String nome;
	public String login;
	private String senha;
	
	public Usuario (Long i, String no, String lo, String se){
		id = i;
		nome = no;
		login = lo;
		senha = se;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}