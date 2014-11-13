package br.com.gymtraining.manager;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import br.com.gymtraining.beans.Usuario;
import br.com.gymtraining.dao.UsuarioDao;

/**
 * Classe usada para manipulação das regras de negocio
 * relacionadas a Usuario
 * 
 * @author kete
 *
 */
public class UsuarioManager {

	private static UsuarioDao dao;
	
	public UsuarioManager() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		dao = new UsuarioDao();
	}
	
	public void cadastrar(Usuario usuario) throws SQLException {
		Date now = new Date();
		usuario.setDataCriacao(now);
		usuario.setDataModificacao(now);
		dao.insert(usuario);
	}
	
	public List<Usuario> listarTodos() throws SQLException, ParseException{
		return dao.getAll();
	}
}
