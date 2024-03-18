package model;

public class CupomTroca extends CupomJavaBeans {

	private String idCliente;
	private String idTroca;
	private float valor;
	private boolean utilizado;

	public CupomTroca() {
		super();
	}

	public CupomTroca(String idCupom, String codigoCupom) {
		super(idCupom, codigoCupom);
	}

	public CupomTroca(String idCliente, String idTroca, float valor, boolean utilizado) {
		super();
		this.idCliente = idCliente;
		this.idTroca = idTroca;
		this.valor = valor;
		this.utilizado = utilizado;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdTroca() {
		return idTroca;
	}

	public void setIdTroca(String idTroca) {
		this.idTroca = idTroca;
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
