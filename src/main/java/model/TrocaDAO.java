package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TrocaDAO {

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

	/** Troca CRUD CREATE **/
	public void inserirTroca(TrocaJavaBeans troca) {
		String create = "insert into tbl_troca (id_cliente,id_carrinho,forma_pagamento,cupons,descricao_frete,endereco_entrega,valor_base,valor_desconto,valor_frete,valor_total,status_pedido) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, troca.getIdCliente());
			pst.setString(2, troca.getIdVenda());
			pst.setString(3, troca.getItemQuantidade());
			pst.setString(4, troca.getStatusTroca());
			pst.setString(5, troca.getMotivo());
            pst.setFloat(6, troca.getValorTroca());
            pst.setString(7, troca.getCupom());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public void atualizarStatusTroca(TrocaJavaBeans troca) {
        String update = "update tbl_troca set status=?,motivo=? where id=?";
        try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, troca.getStatusTroca());
            pst.setString(2, troca.getMotivo());
			pst.setString(3, troca.getIdTroca());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
