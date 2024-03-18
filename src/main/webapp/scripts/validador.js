/**
 * Validacao de formulario
 * @author leonel
 */

function validarNovoCliente() {
	//
	let nome = frmCliente.nomeCliente.value
	let sobrenome = frmcliente.sobrenomeCliente.value
	let cpf = frmCliente.cpfCliente.value
	let email = frmCliente.emailCliente.value
	let fone = frmCliente.foneCliente.value
	let logradouroEntrega = frmCliente.logradouroEnderecoEntrega.value;
    let numeroEntrega = frmCliente.numeroEnderecoEntrega.value;
    let bairroEntrega = frmCliente.bairroEnderecoEntrega.value;
    let cidadeEntrega = frmCliente.cidadeEnderecoEntrega.value;
    let estadoEntrega = frmCliente.estadoEnderecoEntrega.value;
    let cepEntrega = frmCliente.cepEnderecoEntrega.value;
    let logradouroCobranca = frmCliente.logradouroEnderecoCobranca.value;
    let numeroCobranca = frmCliente.numeroEnderecoCobranca.value;
    let bairroCobranca = frmCliente.bairroEnderecoCobranca.value;
    let cidadeCobranca = frmCliente.cidadeEnderecoCobranca.value;
    let estadoCobranca = frmCliente.estadoEnderecoCobranca.value;
    let cepCobranca = frmCliente.cepEnderecoCobranca.value;
	if (nome === "") {
		alert('Preencher o nome do cliente')
		frmCliente.nomeCliente.focus()
		return false
	} else if (sobrenome === "") {
		alert('Preencher o sobrenome do cliente')
		frmCliente.sobrenomeCliente.focus()
		return false
	} else if (cpf === "") {
		alert('Preencher o CPF do cliente')
		frmCliente.cpfCliente.focus()
		return false
	} else if (email === "") {
		alert('Preencher o e-mail do cliente')
		frmCliente.emailCliente.focus()
		return false
	} else if (fone === "") {
		alert('Preencher o telefone do cliente')
		frmCliente.foneCliente.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
}
