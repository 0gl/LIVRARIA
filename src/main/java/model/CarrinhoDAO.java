package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarrinhoDAO {

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
    // Carrinho CRUD READ
	public CarrinhoJavaBeans lerCarrinho() {
		CarrinhoJavaBeans carrinho = new CarrinhoJavaBeans();
		String read = "select * from tbl_carrinho where id_cliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				carrinho.setIdCarrinho(rs.getString(1));
				carrinho.setIdCliente(rs.getString(2));
				carrinho.setItemQuantidadeProduto(rs.getString(3));
			}
			con.close();
			return carrinho;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** Carrinho CRUD UPDATE CONCLUDE **/
	public void atualizarCarrinho(CarrinhoJavaBeans carrinho) {
		String update = "update tbl_carrinho set item_qtde=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, carrinho.getItemQuantidadeProduto());
			pst.setString(2, carrinho.getIdCarrinho());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
