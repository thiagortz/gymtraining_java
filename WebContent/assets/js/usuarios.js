//Adiciona o evento para que quando a pagina for carregada executar a funcao createPage
document.addEventListener('DOMContentLoaded', buscarTodosUsuarios);

function buscarTodosUsuarios() {
	
	var request = new XMLHttpRequest();
	var url = "listarUsuarios";
	var resposta = "";
	request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            resposta = request.responseText;
            mostrarTodosOsUsuarios(resposta);
        }
    };
	request.open('post', url);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.setRequestHeader("Content-Type", "text/html; charset=iso-8859-1");
	request.send();
	
}

function mostrarTodosOsUsuarios(dados){
	var usuarios = JSON.parse(dados);
	var html = ""
	
	for(var i=0, length = usuarios.length; i < length; i++){
		html += "<tr>";
		html += "<td>"+ usuarios[i].nome + "</td>";
		html += "<td>"+ usuarios[i].email + "</td>";
		html += "<td>"+ usuarios[i].dataNascimento + "</td>";
		html += "<td>"+ usuarios[i].dataCriacao + "</td>";
		html += "<td>"+ usuarios[i].dataModificacao + "</td>";
		html += '<td><a href=""> X </a></td>';
		html +="</tr>"
	}
	
	var tbody = document.querySelector('#lista_usuarios tbody')
	tbody.innerHTML += html;
	
	
	
}