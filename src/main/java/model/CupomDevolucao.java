package model;

public class CupomDevolucao extends CupomJavaBeans {

	private String idCliente;
	private String idDevolucao;
	private float valor;
	private boolean utilizado;

	public CupomDevolucao() {
		super();
	}

	public CupomDevolucao(String idCupom, String codigoCupom) {
		super(idCupom, codigoCupom);
	}

	public CupomDevolucao(String idCliente, String idDevolucao, float valor, boolean utilizado) {
		super();
		this.idCliente = idCliente;
		this.idDevolucao = idDevolucao;
		this.valor = valor;
		this.utilizado = utilizado;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdDevolucao() {
		return idDevolucao;
	}

	public void setIdDevolucao(String idDevolucao) {
		this.idDevolucao = idDevolucao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isUtilizado() {
		return utilizado;
	}

	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}

}
