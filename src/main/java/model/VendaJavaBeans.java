package model;

public class VendaJavaBeans {

	private String idVenda;
	private String idCliente;
	private String idCarrinho;
	private String formaPagamento;
	private String cupons;
	private String descricaoFrete;
	private String enderecoEntrega;
	private float valorBase;
	private float valorDesconto;
	private float valorFrete;
	private float valorTotal;
	private String statusPedido;

	public VendaJavaBeans() {
		super();
	}

	public VendaJavaBeans(String idVenda, String idCliente, String idCarrinho, String formaPagamento, String cupons,
			String descricaoFrete, String enderecoEntrega, float valorBase, float valorDesconto, float valorFrete,
			float valorTotal, String statusPedido) {
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.idCarrinho = idCarrinho;
		this.formaPagamento = formaPagamento;
		this.cupons = cupons;
		this.descricaoFrete = descricaoFrete;
		this.enderecoEntrega = enderecoEntrega;
		this.valorBase = valorBase;
		this.valorDesconto = valorDesconto;
		this.valorFrete = valorFrete;
		this.valorTotal = valorTotal;
		this.statusPedido = statusPedido;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(String idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCupons() {
		return cupons;
	}

	public void setCupons(String cupons) {
		this.cupons = cupons;
	}

	public String getDescricaoFrete() {
		return descricaoFrete;
	}

	public void setDescricaoFrete(String descricaoFrete) {
		this.descricaoFrete = descricaoFrete;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public float getValorBase() {
		return valorBase;
	}

	public void setValorBase(float valorBase) {
		this.valorBase = valorBase;
	}

	public float getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	// Adicao de cupons
	public void adicionarCupom(String codigoCupom) {
		if (cupons == null || cupons.isEmpty()) {
			cupons = codigoCupom;
		} else {
			cupons += ";" + codigoCupom;
		}
	}
}
