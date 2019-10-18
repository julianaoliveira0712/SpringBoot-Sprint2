package br.com.bandtec.agendadeobjetivos.seguranca;

import javax.persistence.Embeddable;


public class Credenciais {
	
	private String login;
	private String senha;
	
	protected Credenciais() {}
	
	public Credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public String getLogin() {
		return login;
	}

}
