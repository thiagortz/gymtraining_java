package br.com.gymtraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.gymtraining.beans.Usuario;
import br.com.gymtraining.database.DataBaseFactory;

public class UsuarioDao {

	private Connection conexao;

	public UsuarioDao() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		conexao = DataBaseFactory.getConnection();

	}

	public void insert(Usuario usuario) throws SQLException {
		
		// cria um preparedStatement
		String sql = "insert into usuarios"
				+ " (nome,email,data_nascimento, data_criacao, data_modificacao )"
				+ " values (?,?,?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);

		//seta os valores que serao substituidos pelos ?  no sql
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setDate(3,new java.sql.Date(usuario.getDataNascimento().getTime()));
		stmt.setDate(4, new java.sql.Date(usuario.getDataModificacao().getTime()));
		stmt.setDate(5, new java.sql.Date(usuario.getDataModificacao().getTime()));

		// executa
		stmt.executeUpdate();
		//Fecha o statement
		stmt.close();

		System.out.println("Usuário Cadastrado!");

	}

	public void update(Usuario usuario) throws SQLException {

		// cria um preparedStatement
		String sql = "update usuarios set nome=?, email=?, data_nascimento=?, data_modificacao=? where id=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setDate(3,
				new java.sql.Date(usuario.getDataNascimento().getTime()));
		stmt.setDate(4, new java.sql.Date(usuario.getDataModificacao()
				.getTime()));
		stmt.setLong(5, usuario.getId());

		// executa
		stmt.executeUpdate();
		//Fecha o statement
		stmt.close();

		System.out.println("Usuário Atualizado!");

	}

	public void delete(Long id) throws SQLException {

		// cria um preparedStatement
		String sql = "delete from usuarios";
		//Recupera o PreparedStatement
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		//Se o usuario passar id == null, deleta tudo
		if(id != null) {
			sql += " where id=?";
			// preenche os valores
			stmt.setLong(1, id);
		}

		// executa
		stmt.executeUpdate();
		//Fecha o statement
		stmt.close();

		System.out.println("Usuário Deletado!");

	}

	public List<Usuario> select( String name) throws SQLException, ParseException {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		// cria um preparedStatement
		String sql = "select * from usuarios where nome=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		// preenche os valores
		stmt.setString(1, name);

		// executa
		ResultSet rs = stmt.executeQuery();
		
		Usuario usuario = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// itera no ResultSet e popula um objeto Usuario
		while (rs.next()) {
			
			usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setId(Long.parseLong(rs.getString("id")));
			usuario.setDataNascimento(formatter.parse(rs.getString("data_nascimento")));
			usuario.setDataModificacao(formatter.parse(rs.getString("data_modificacao")));
			usuario.setDataCriacao(formatter.parse(rs.getString("data_criacao")));
			
			usuarios.add(usuario);
		}
		
		rs.close();
		stmt.close();

		return usuarios;

	}

}
