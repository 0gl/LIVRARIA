package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ClienteDAO;
import model.ClienteJavaBeans;
import model.EnderecoDAO;
import model.EnderecoJavaBeans;

@WebServlet(urlPatterns = { "/maincliente", "/insertcliente", "/selectcliente", "/updatecliente", "/deletecliente" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	EnderecoDAO enderecoDao = new EnderecoDAO();
	ClienteJavaBeans cliente = new ClienteJavaBeans();
	EnderecoJavaBeans enderecoEntrega = new EnderecoJavaBeans();
	EnderecoJavaBeans enderecoCobranca = new EnderecoJavaBeans();

	public ClienteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/maincliente")) {
			clientes(request, response);
		} else if (action.equals("/insertcliente")) {
			inserirCliente(request, response);
		} else if (action.equals("/selectcliente")) {
			selecionarCliente(request, response);
		} else if (action.equals("/updatecliente")) {
			editarCliente(request, response);
		} else if (action.equals("/deletecliente")) {
			excluirCliente(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Clientes
	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ClienteJavaBeans> lista = clienteDao.listarClientes();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);
	}

	// Inserir cliente
	protected void inserirCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		cliente.setNomeCliente(request.getParameter("nomeCliente"));
		cliente.setSobrenomeCliente(request.getParameter("sobrenomeCliente"));
		cliente.setCpfCliente(request.getParameter("cpfCliente"));
		cliente.setEmailCliente(request.getParameter("emailCliente"));
		cliente.setFoneCliente(request.getParameter("foneCliente"));
		clienteDao.inserirCliente(cliente);
		//enderecoEntrega.
		response.sendRedirect("maincliente");
	}

	// Selecionar cliente
	protected void selecionarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idCliente = request.getParameter("idCliente");
		cliente.setIdCliente(idCliente);
		clienteDao.selecionarCliente(cliente);
		request.setAttribute("idCliente", cliente.getIdCliente());
		request.setAttribute("nomeCliente", cliente.getNomeCliente());
		request.setAttribute("sobrenomeCliente", cliente.getNomeCliente());
		request.setAttribute("cpfCliente", cliente.getCpfCliente());
		request.setAttribute("emailCliente", cliente.getEmailCliente());
		request.setAttribute("foneCliente", cliente.getFoneCliente());
		RequestDispatcher rd = request.getRequestDispatcher("editarcliente.jsp");
		rd.forward(request, response);
	}

	// Editar cliente
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setIdCliente(request.getParameter("idCliente"));
		cliente.setNomeCliente(request.getParameter("nomeCliente"));
		cliente.setSobrenomeCliente(request.getParameter("sobrenomeCliente"));
		cliente.setCpfCliente(request.getParameter("cpfCliente"));
		cliente.setEmailCliente(request.getParameter("emailCliente"));
		cliente.setFoneCliente(request.getParameter("foneCliente"));
		clienteDao.editarCliente(cliente);
		response.sendRedirect("maincliente");
	}

	// Excluir cliente
	protected void excluirCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setIdCliente(request.getParameter("idCliente"));
		clienteDao.excluirCliente(cliente);
		response.sendRedirect("maincliente");
	}
}
