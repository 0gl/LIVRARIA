package model;

public class ProdutoJavaBeans {

	private String idProduto;
	private String tituloProduto;
	private String autorProduto;
	private String editoraProduto;
	private String descricaoProduto;
	private float precoProduto;

	public ProdutoJavaBeans() {
		super();
	}

	public ProdutoJavaBeans(String idProduto, String tituloProduto, String autorProduto, String editoraProduto,
			String descricaoProduto, float precoProduto) {
		super();
		this.idProduto = idProduto;
		this.tituloProduto = tituloProduto;
		this.autorProduto = autorProduto;
		this.editoraProduto = editoraProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getTituloProduto() {
		return tituloProduto;
	}

	public void setTituloProduto(String tituloProduto) {
		this.tituloProduto = tituloProduto;
	}

	public String getAutorProduto() {
		return autorProduto;
	}

	public void setAutorProduto(String autorProduto) {
		this.autorProduto = autorProduto;
	}

	public String getEditoraProduto() {
		return editoraProduto;
	}

	public void setEditoraProduto(String editoraProduto) {
		this.editoraProduto = editoraProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(float precoProduto) {
		this.precoProduto = precoProduto;
	}

}
