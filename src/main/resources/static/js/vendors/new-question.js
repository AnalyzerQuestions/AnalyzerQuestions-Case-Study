// modais

$(document).ready(function() {
	$('#modalExplicativo').modal('show');
});


// ativação dos botões
function habi() {
	//se os dois campos estiverem preenchidos, o botao sera habilitado.
	if (document.getElementById('titulo-input').value != ''
		&& document.getElementById('editor-f').value != '') {
		document.getElementById("btn-get-sug").disabled = false;
		document.getElementById("btn-completter").disabled = false;
	}
	//se qualquer um dos campos estiver em branco, o botao ficara desabilitado.
	if (document.getElementById('titulo-input').value == '') {
		document.getElementById("btn-get-sug").disabled = true;
		document.getElementById("btn-completter").disabled = true;
	}
	if (document.getElementById('editor-f').value == '') {
		document.getElementById("btn-get-sug").disabled = true;
		document.getElementById("btn-completter").disabled = true;
	}
}
