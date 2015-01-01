package br.com.west.interfaces.login;

import br.com.west.comum.dominio.login.AutenticacaoVO;
import br.com.west.interfaces.AbstractModel;

public class LoginModel extends AbstractModel {

	private static final long serialVersionUID = -7664792189262347948L;

	private String usuario;
	private String senha;

	public LoginModel() {
		super();
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

	public void limpar() {
		setUsuario(null);
		setSenha(null);
	}

	public AutenticacaoVO getAutenticacaoVO() {
		return new AutenticacaoVO(usuario, senha);
	}
}
