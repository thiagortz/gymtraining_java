<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>Gym Training</title>
		<link href="assets/style/usuarios.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		<jsp:useBean id="dao" class="br.com.gymtraining.dao.UsuarioDao"/>
		
		<form action="cadastrarUsuario" class="novoUsuario" method="post">
			<label>Nome:</label><input type="text" maxlength="80" name="nome">
			<label>Email:</label><input type="email" maxlength="50" name="email">
			<label>Data de Nascimento:</label><input type="date" name="data_nascimento">
			<input type="submit" value="Enviar">
		</form>
		
	</body>
	
</html>