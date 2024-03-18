package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CupomDevolucaoDAO {

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

	/** Cupom Devolucao CRUD CREATE **/
	public void inserirCupomDevolucao(CupomDevolucao cupomDevolucao) {
		String create = "insert into tbl_cupom_devolucao (id_cliente,id_devolucao,codigo,valor,utilizado) values (?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, cupomDevolucao.getIdCliente());
			pst.setString(2, cupomDevolucao.getIdDevolucao());
			pst.setString(3, cupomDevolucao.getCodigoCupom());
			pst.setFloat(4, cupomDevolucao.getValor());
			pst.setBoolean(5, cupomDevolucao.isUtilizado());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public void selecionarCupomDevolucao(CupomDevolucao cupomDevolucao) {
        String read2 = "select * from tbl_cupom_devolucao where id=?";
        try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, cupomDevolucao.getIdCupom());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cupomDevolucao.setIdCupom(rs.getString(1));
                cupomDevolucao.setIdCliente(rs.getString(2));
                cupomDevolucao.setIdDevolucao(rs.getString(3));
                cupomDevolucao.setCodigoCupom(rs.getString(4));
                cupomDevolucao.setValor(rs.getFloat(5));
                cupomDevolucao.setUtilizado(rs.getBoolean(6));
            }
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}