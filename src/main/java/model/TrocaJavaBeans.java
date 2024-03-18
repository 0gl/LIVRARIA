package model;

public class TrocaJavaBeans {

	private String idTroca;
	private String idCliente;
	private String idVenda;
	private String itemQuantidade;
	private String statusTroca;
	private String motivo;
	private float valorTroca;
	private String cupom;

	public TrocaJavaBeans() {
		super();
	}

	public TrocaJavaBeans(String idTroca, String idCliente, String idVenda, String itemQuantidade, String statusTroca,
			String motivo, float valorTroca, String cupom) {
		super();
		this.idTroca = idTroca;
		this.idCliente = idCliente;
		this.idVenda = idVenda;
		this.itemQuantidade = itemQuantidade;
		this.statusTroca = statusTroca;
		this.motivo = motivo;
		this.valorTroca = valorTroca;
		this.cupom = cupom;
	}

	public String getIdTroca() {
		return idTroca;
	}

	public void setIdTroca(String idTroca) {
		this.idTroca = idTroca;
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

	public String getStatusTroca() {
		return statusTroca;
	}

	public void setStatusTroca(String statusTroca) {
		this.statusTroca = statusTroca;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public float getValorTroca() {
		return valorTroca;
	}

	public void setValorTroca(float valorTroca) {
		this.valorTroca = valorTroca;
	}

	public String getCupom() {
		return cupom;
	}

	public void setCupom(String cupom) {
		this.cupom = cupom;
	}

}
