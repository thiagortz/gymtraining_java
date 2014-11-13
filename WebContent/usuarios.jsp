
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Gym Training</title>
		<link href="assets/style/usuarios.css" rel="stylesheet" type="text/css">
		<meta charset="UTF-8">
	</head>
	
	<body>
		<jsp:include page="header.jsp" />
		
		<jsp:useBean id="dao" class="br.com.gymtraining.dao.UsuarioDao"/>
		
		<jsp:include page="usuarios_new.jsp" />
		
		<table id="lista_usuarios">
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Data de Nascimento</td>
				<td>Data de Criação</td>
				<td>Última Modificação</td>
				<td> </td>
			</tr>
			
			<c:forEach var="usuario" items="${dao.all}">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.dataNascimento}</td>
					<td>${usuario.dataCriacao}</td>
					<td>${usuario.dataModificacao}</td>
					<td><a href=""> X </a></td>
				</tr>
				
			</c:forEach>
		</table>
	</body>
	
</html>