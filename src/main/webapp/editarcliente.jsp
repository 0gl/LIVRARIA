<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Cliente | Livraria</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Editar Cliente</h1>
	<form name="frmCliente" action="update">
		<table>
			<tr>
				<td><input type="text" name="idCliente" class="caixa3" readonly
					value="<%out.print(request.getAttribute("idCliente"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nomeCliente" class="Caixa1"
					value="<%out.print(request.getAttribute("nomeCliente"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpfCliente" class="Caixa2"
					value="<%out.print(request.getAttribute("cpfCliente"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="enderecoCliente" class="Caixa1"
					value="<%out.print(request.getAttribute("enderecoCliente"));%>"></td>
			</tr>
		</table>
		<input type="submit" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>

</html>