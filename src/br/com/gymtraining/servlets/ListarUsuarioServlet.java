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

@WebServlet("/listarUsuarios")
public class ListarUsuarioServlet extends HttpServlet {

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
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			response.getWriter().print(manager.listarTodos());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
