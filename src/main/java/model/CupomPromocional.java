package model;

public class CupomPromocional extends CupomJavaBeans {

	private float valor;
	private float percentual;
	private int disponiveis;

	public CupomPromocional() {
		super();
	}

	public CupomPromocional(String idCupom, String codigoCupom) {
		super(idCupom, codigoCupom);
	}

	public CupomPromocional(float valor, float percentual, int disponiveis) {
		super();
		this.valor = valor;
		this.percentual = percentual;
		this.disponiveis = disponiveis;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getPercentual() {
		return percentual;
	}

	public void setPercentual(float percentual) {
		this.percentual = percentual;
	}

	public int getDisponiveis() {
		return disponiveis;
	}

	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}

}
