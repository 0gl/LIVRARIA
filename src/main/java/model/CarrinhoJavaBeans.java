package model;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoJavaBeans {

	private String idCarrinho;
	private String idCliente;
	private String itemQuantidadeProduto;

	public CarrinhoJavaBeans() {
		super();

	}

	public CarrinhoJavaBeans(String idCarrinho, String idCliente, String itemQuantidadeProduto) {
		super();
		this.idCarrinho = idCarrinho;
		this.idCliente = idCliente;
		this.itemQuantidadeProduto = itemQuantidadeProduto;
	}

	public String getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(String idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getItemQuantidadeProduto() {
		return itemQuantidadeProduto;
	}

	public void setItemQuantidadeProduto(String itemQuantidadeProduto) {
		this.itemQuantidadeProduto = itemQuantidadeProduto;
	}

	public String encodeItemQuantidadeProduto(Map<String, Integer> produtoQuantidade) {
		StringBuilder encodedString = new StringBuilder();

		for (Map.Entry<String, Integer> entry : produtoQuantidade.entrySet()) {
			String codigoProduto = entry.getKey();
			int quantidade = entry.getValue();

			encodedString.append(codigoProduto).append("x").append(quantidade).append(";");
		}

		if (encodedString.length() > 0) {
			encodedString.deleteCharAt(encodedString.length() - 1);
		}

		this.itemQuantidadeProduto = encodedString.toString();
		return itemQuantidadeProduto;
	}

	public Map<String, Integer> decodeItemQuantidadeProduto() {
		Map<String, Integer> produtoQuantidade = new HashMap<>();

		if (itemQuantidadeProduto != null && !itemQuantidadeProduto.isEmpty()) {
			String[] pairs = itemQuantidadeProduto.split(";");
			for (String pair : pairs) {
				String[] parts = pair.split("x");
				if (parts.length == 2) {
					String codigoProduto = parts[0];
					int quantidade = Integer.parseInt(parts[1]);
					produtoQuantidade.put(codigoProduto, quantidade);
				}
			}
		}

		return produtoQuantidade;
	}

}
