package br.com.gymtraining.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gymtraining.beans.Usuario;

public class UsuarioDaoTest {
	
	private static UsuarioDao dao;
	private static Usuario usuario;
	private String nomeUsuario = "Joao";
	
	@BeforeClass
	public static void beforeClass() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		dao = new UsuarioDao();
		usuario = new Usuario();
		usuario.setNome("Joao");
		usuario.setEmail("joao@faculdade.com.br");

		Date now = new Date();
		usuario.setDataNascimento(now);
		usuario.setDataCriacao(now);
		usuario.setDataModificacao(now);
	}
	
	@Before
	public void before() throws SQLException {
		dao.insert(usuario);
	}
	
	@After
	public void after() throws SQLException {
		dao.delete(null);
	}
	
	@Test
	public void quando_eu_insiro_um_usuario_o_num_registros_aumenta() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, ParseException {
		
		List<Usuario> usuariosAntesDoInsert = dao.getByName(nomeUsuario);
		usuario.setEmail("newUser@gmail.com");
		dao.insert(usuario);
		List<Usuario> usuariosDepoisDoInsert = dao.getByName(nomeUsuario);
		
		assertNotNull(usuariosDepoisDoInsert);
		assertEquals(usuariosAntesDoInsert.size() + 1, usuariosDepoisDoInsert.size());
	}

	@Test
	public void se_eu_passar_um_nome_usuarios_sao_retornados() throws SQLException,
	InstantiationException, IllegalAccessException,
	ClassNotFoundException, ParseException {
		
		List<Usuario> usuarios = dao.getByName(nomeUsuario);
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		assertNotNull(usuarios);
		assertEquals(usuarios.get(0).getNome(), nomeUsuario);
	}

	@Test
	public void se_eu_deletar_todos_o_select_nao_retorna_nada() throws SQLException,
		InstantiationException, IllegalAccessException,
		ClassNotFoundException, ParseException {
		
		List<Usuario> usuarios = dao.getByName(nomeUsuario);
		
		assertNotNull(usuarios);
		assertEquals(usuarios.size(), 1);
		
		dao.delete(null);
		usuarios = dao.getByName(nomeUsuario);
		
		assertNotNull(usuarios);
		assertEquals(usuarios.size(), 0);
	}
}
