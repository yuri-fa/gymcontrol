package br.com.gym.gymcontrol.model.dto;

public class TokenDto {

    private String token;
    private String tipo;

    public TokenDto(String token, String tipo) {
	super();
	this.token = token;
	this.tipo = tipo;
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

}
