package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EnderecoDAO {

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

	/** Endereco CRUD CREATE **/
	public void inserirEndereco(EnderecoJavaBeans endereco) {
		String create = "insert into tbl_endereco (id_cliente,logradouro,numero,complemento,bairro,cidade,estado,cep,tipo,entrega,cobranca) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, endereco.getIdCliente());
			pst.setString(2, endereco.getLogradouro());
			pst.setString(3, endereco.getNumero());
			pst.setString(4, endereco.getComplemento());
			pst.setString(5, endereco.getBairro());
			pst.setString(6, endereco.getCidade());
			pst.setString(7, endereco.getEstado());
			pst.setString(8, endereco.getCep());
			pst.setString(9, endereco.getTipo());
			pst.setBoolean(10, endereco.isEntrega());
			pst.setBoolean(11, endereco.isCobranca());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Endereco Entrega CRUD READ
	public ArrayList<EnderecoJavaBeans> listarEnderecosEntrega() {
		ArrayList<EnderecoJavaBeans> enderecosEntrega = new ArrayList<>();
		String read = "select * from tbl_endereco where id_cliente = ? and entrega = true";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idEndereco = rs.getString(1);
				String idCliente = rs.getString(2);
				String logradouro = rs.getString(3);
				String numero = rs.getString(4);
				String complemento = rs.getString(5);
				String bairro = rs.getString(6);
				String cidade = rs.getString(7);
				String estado = rs.getString(8);
				String cep = rs.getString(9);
				String tipo = rs.getString(10);
				boolean entrega = rs.getBoolean(11);
				boolean cobranca = rs.getBoolean(12);
				enderecosEntrega.add(new EnderecoJavaBeans(idEndereco, idCliente, logradouro, numero, complemento, bairro, cidade, estado, cep, tipo, entrega, cobranca));
			}
			con.close();
			return enderecosEntrega;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** Endereco CRUD UPDATE SELECT
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

	//* Endereco CRUD UPDATE CONCLUDE
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

	//* Endereco CRUD DELETE
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
	} **/

}
