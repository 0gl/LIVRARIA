package model;

public class DevolucaoJavaBeans {

	private String idDevolucao;
	private String idCliente;
	private String idVenda;
	private String itemQuantidade;
	private String statusDevolucao;
	private String motivo;
	private float valorDevolucao;
	private String cupom;

	public DevolucaoJavaBeans() {
		super();
	}

	public DevolucaoJavaBeans(String idDevolucao, String idCliente, String idVenda, String itemQuantidade,
			String statusDevolucao, String motivo, float valorDevolucao, String cupom) {
		super();
		this.idDevolucao = idDevolucao;
		this.idCliente = idCliente;
		this.idVenda = idVenda;
		this.itemQuantidade = itemQuantidade;
		this.statusDevolucao = statusDevolucao;
		this.motivo = motivo;
		this.valorDevolucao = valorDevolucao;
		this.cupom = cupom;
	}

	public String getIdDevolucao() {
		return idDevolucao;
	}

	public void setIdDevolucao(String idDevolucao) {
		this.idDevolucao = idDevolucao;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public String getItemQuantidade() {
		return itemQuantidade;
	}

	public void setItemQuantidade(String itemQuantidade) {
		this.itemQuantidade = itemQuantidade;
	}

	public String getStatusDevolucao() {
		return statusDevolucao;
	}

	public void setStatusDevolucao(String statusDevolucao) {
		this.statusDevolucao = statusDevolucao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public float getValorDevolucao() {
		return valorDevolucao;
	}

	public void setValorDevolucao(float valorDevolucao) {
		this.valorDevolucao = valorDevolucao;
	}

	public String getCupom() {
		return cupom;
	}

	public void setCupom(String cupom) {
		this.cupom = cupom;
	}

}
