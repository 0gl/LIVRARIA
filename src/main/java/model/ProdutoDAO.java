package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

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

	// Produto CRUD READ
	public ArrayList<ProdutoJavaBeans> listarProdutos() {
		ArrayList<ProdutoJavaBeans> produtos = new ArrayList<>();
		String read = "select * from tbl_produto";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idProduto = rs.getString(1);
				String tituloProduto = rs.getString(2);
				String autorProduto = rs.getString(3);
				String editoraProduto = rs.getString(4);
				String descricaoProduto = rs.getString(4);
				float precoProduto = rs.getFloat(5);
				produtos.add(new ProdutoJavaBeans(idProduto, tituloProduto, autorProduto, editoraProduto,
						descricaoProduto, precoProduto));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
