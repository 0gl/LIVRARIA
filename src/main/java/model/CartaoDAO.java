package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CartaoDAO {

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

	/** Cartao CRUD CREATE **/
	public void inserirCartao(CartaoJavaBeans cartao) {
		String create = "insert into tbl_cartao (id_cliente,numero,validade,cvc) values (?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, cartao.getIdCliente());
			pst.setString(2, cartao.getNumeroCartao());
			pst.setString(3, cartao.getValidadeCartao());
			pst.setString(4, cartao.getCvcCartao());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Cartao CRUD READ
	public ArrayList<CartaoJavaBeans> listarCartoes() {
		ArrayList<CartaoJavaBeans> cartoes = new ArrayList<>();
		String read = "select * from tbl_cartao where id_cliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idCartao = rs.getString(1);
				String idCliente = rs.getString(2);
				String numeroCartao = rs.getString(3);
				String validadeCartao = rs.getString(4);
				String cvcCartao = rs.getString(5);
				cartoes.add(new CartaoJavaBeans(idCartao, idCliente, numeroCartao, validadeCartao, cvcCartao));
			}
			con.close();
			return cartoes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
