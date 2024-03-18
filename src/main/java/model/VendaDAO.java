package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VendaDAO {

    /** Modulo de conexao **/

	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/db_principal?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "admin";

	// Metodo de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = java.sql.DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** Venda CRUD CREATE **/
	public void inserirVenda(VendaJavaBeans venda) {
		String create = "insert into tbl_venda (id_cliente,id_carrinho,forma_pagamento,cupons,descricao_frete,endereco_entrega,valor_base,valor_desconto,valor_frete,valor_total,status_pedido) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, venda.getIdCliente());
			pst.setString(2, venda.getIdCarrinho());
			pst.setString(3, venda.getFormaPagamento());
			pst.setString(4, venda.getCupons());
			pst.setString(5, venda.getDescricaoFrete());
            pst.setString(6, venda.getEnderecoEntrega());
            pst.setFloat(7, venda.getValorBase());
            pst.setFloat(8, venda.getValorDesconto());
            pst.setFloat(9, venda.getValorFrete());
            pst.setFloat(10, venda.getValorTotal());
            pst.setString(11, venda.getStatusPedido());

			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public void atualizarStatusVenda(VendaJavaBeans venda) {
        String update = "update tbl_venda set status=? where id=?";
        try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, venda.getStatusPedido());
			pst.setString(2, venda.getIdVenda());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
