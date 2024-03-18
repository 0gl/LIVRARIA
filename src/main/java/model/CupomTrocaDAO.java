package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CupomTrocaDAO {

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

	/** Cupom Troca CRUD CREATE **/
	public void inserirCupomTroca(CupomTroca cupomTroca) {
		String create = "insert into tbl_cupom_troca (id_cliente,id_troca,codigo,valor,utilizado) values (?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, cupomTroca.getIdCliente());
			pst.setString(2, cupomTroca.getIdTroca());
			pst.setString(3, cupomTroca.getCodigoCupom());
			pst.setFloat(4, cupomTroca.getValor());
			pst.setBoolean(5, cupomTroca.isUtilizado());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public void selecionarCupomTroca(CupomTroca cupomTroca) {
        String read2 = "select * from tbl_cupom_troca where id=?";
        try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, cupomTroca.getIdCupom());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cupomTroca.setIdCupom(rs.getString(1));
                cupomTroca.setIdCliente(rs.getString(2));
                cupomTroca.setIdTroca(rs.getString(3));
                cupomTroca.setCodigoCupom(rs.getString(4));
                cupomTroca.setValor(rs.getFloat(5));
                cupomTroca.setUtilizado(rs.getBoolean(6));
            }
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
