package model;

public class CupomJavaBeans {

	private String idCupom;
	private String codigoCupom;

	public CupomJavaBeans() {
		super();
	}

	public CupomJavaBeans(String idCupom, String codigoCupom) {
		super();
		this.idCupom = idCupom;
		this.codigoCupom = codigoCupom;
	}

	public String getIdCupom() {
		return idCupom;
	}

	public void setIdCupom(String idCupom) {
		this.idCupom = idCupom;
	}

	public String getCodigoCupom() {
		return codigoCupom;
	}

	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}

}
