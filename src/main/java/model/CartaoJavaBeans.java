package model;

public class CartaoJavaBeans {

	private String idCartao;
	private String idCliente;
	private String numeroCartao;
	private String validadeCartao;
	private String cvcCartao;

	public CartaoJavaBeans() {
		super();
	}

	public CartaoJavaBeans(String idCartao, String idCliente, String numeroCartao, String validadeCartao,
			String cvcCartao) {
		super();
		this.idCartao = idCartao;
		this.idCliente = idCliente;
		this.numeroCartao = numeroCartao;
		this.validadeCartao = validadeCartao;
		this.cvcCartao = cvcCartao;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(String validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public String getCvcCartao() {
		return cvcCartao;
	}

	public void setCvcCartao(String cvcCartao) {
		this.cvcCartao = cvcCartao;
	}

}
