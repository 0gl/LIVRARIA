/**
 * Confirmacao de exclusao
 * @author leonel
 */

function confirmar(idCliente) {
	let resposta = confirm("Confirma a exclusão deste cliente?")
	if (resposta === true) {
		window.location.href = "delete?idCliente=" + idCliente
	}
}