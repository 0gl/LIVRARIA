package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {
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

	/** Cliente CRUD CREATE **/
	public void inserirCliente(ClienteJavaBeans cliente) {
		String create = "insert into tbl_cliente (nome,sobrenome,cpf,email,fone,endereco) values (?,?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, cliente.getNomeCliente());
			pst.setString(2, cliente.getSobrenomeCliente());
			pst.setString(3, cliente.getCpfCliente());
			pst.setString(4, cliente.getEmailCliente());
			pst.setString(5, cliente.getFoneCliente());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Cliente CRUD READ **/
	public ArrayList<ClienteJavaBeans> listarClientes() {
		ArrayList<ClienteJavaBeans> clientes = new ArrayList<>();
		String read = "select * from tbl_cliente order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idCliente = rs.getString(1);
				String nomeCliente = rs.getString(2);
				String sobrenomeCliente = rs.getString(3);
				String cpfCliente = rs.getString(4);
				String emailCliente = rs.getString(5);
				String foneCliente = rs.getString(6);
				clientes.add(new ClienteJavaBeans(idCliente, nomeCliente, sobrenomeCliente, cpfCliente, emailCliente, foneCliente));
			}
			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** Cliente CRUD UPDATE SELECT **/
	public void selecionarCliente(ClienteJavaBeans cliente) {
		String read2 = "select * from tbl_cliente where id_cliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cliente.getIdCliente());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cliente.setIdCliente(rs.getString(1));
				cliente.setNomeCliente(rs.getString(2));
				cliente.setSobrenomeCliente(rs.getString(2));
				cliente.setCpfCliente(rs.getString(3));
				cliente.setEmailCliente(rs.getString(4));
				cliente.setFoneCliente(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Cliente CRUD UPDATE CONCLUDE **/
	public void editarCliente(ClienteJavaBeans cliente) {
		String update = "update tbl_cliente set nome=?, sobrenome=?, cpf=?, email=?, fone=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, cliente.getNomeCliente());
			pst.setString(2, cliente.getSobrenomeCliente());
			pst.setString(3, cliente.getCpfCliente());
			pst.setString(4, cliente.getEmailCliente());
			pst.setString(5, cliente.getFoneCliente());
			pst.setString(7, cliente.getIdCliente());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Cliente CRUD DELETE **/
	public void excluirCliente(ClienteJavaBeans cliente) {
		String delete = "delete from tbl_cliente where id_cliente=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cliente.getIdCliente());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
