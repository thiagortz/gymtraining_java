package br.com.gymtraining.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gymtraining.beans.Usuario;
import br.com.gymtraining.manager.UsuarioManager;

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -3018266393583529368L;

	private static UsuarioManager manager;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			manager = new UsuarioManager();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String nomeParam = request.getParameter("nome");
		String emailParam = request.getParameter("email");
		String dataNascParam = request.getParameter("data_nascimento");
		
		if(dataNascParam == null || nomeParam == null || emailParam == null){
			StringBuilder sb = new StringBuilder("Elementos obrigatórios não informados [");
			sb.append("nome =").append(nomeParam);
			sb.append(", email =").append(emailParam);
			sb.append(", data_nascimento =").append(dataNascParam).append("]");
			throw new IllegalArgumentException(sb.toString());
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(nomeParam);
		usuario.setEmail(emailParam);
		Date dataNascimento;
		
		try {
			
			dataNascimento = sf.parse(dataNascParam);
			usuario.setDataNascimento(dataNascimento);
			manager.cadastrar(usuario);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String nextJSP = "/usuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		
		
	}
}
