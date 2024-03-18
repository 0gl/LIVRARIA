package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DevolucaoDAO {

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

	/** Devolucao CRUD CREATE **/
	public void inserirDevolucao(DevolucaoJavaBeans devolucao) {
		String create = "insert into tbl_devolucao (id_cliente,id_carrinho,forma_pagamento,cupons,descricao_frete,endereco_entrega,valor_base,valor_desconto,valor_frete,valor_total,status_pedido) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, devolucao.getIdCliente());
			pst.setString(2, devolucao.getIdVenda());
			pst.setString(3, devolucao.getItemQuantidade());
			pst.setString(4, devolucao.getStatusDevolucao());
			pst.setString(5, devolucao.getMotivo());
            pst.setFloat(6, devolucao.getValorDevolucao());
            pst.setString(7, devolucao.getCupom());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public void atualizarStatusDevolucao(DevolucaoJavaBeans devolucao) {
        String update = "update tbl_devolucao set status=?,motivo=? where id=?";
        try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, devolucao.getStatusDevolucao());
            pst.setString(2, devolucao.getMotivo());
			pst.setString(3, devolucao.getIdDevolucao());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
