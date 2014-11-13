package br.com.gymtraining.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
	
	private Long id;
	
	private String nome;
	private String email;
	private Date dataNascimento;
	private Date dataCriacao;
	private Date dataModificacao;

	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		sb.append(getPropertyInJsonFormat("id", id)).append(",");
		sb.append(getPropertyInJsonFormat("nome", nome)).append(",");
		sb.append(getPropertyInJsonFormat("email", email)).append(",");
		sb.append(getPropertyInJsonFormat("dataNascimento", sf.format(dataNascimento))).append(",");
		sb.append(getPropertyInJsonFormat("dataCriacao", sf.format(dataCriacao))).append(",");
		sb.append(getPropertyInJsonFormat("dataModificacao", sf.format(dataModificacao))).append("}");
		
		return sb.toString();
	}
	
	private String getPropertyInJsonFormat(String property, Object value){
		String aspasDuplas = "\"";
		return aspasDuplas + property + aspasDuplas + ":" + aspasDuplas + value + aspasDuplas;
		
	}
	
	
}
