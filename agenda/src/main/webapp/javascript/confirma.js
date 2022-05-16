/**
 * funcao confirma a exclusao
 @param id
 */

function confirmar(id) {
	let resp = confirm(" deseja realmente excluir esse contato? ")

	if (resp === true) {
		window.location.href = "delete?id=" + id
	}
}