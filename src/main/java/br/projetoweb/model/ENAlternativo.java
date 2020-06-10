package br.projetoweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ENAlternativo {
private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	private String enderecoalternativo;
	private String numeroalternativo;
	
	@ManyToOne
	private  Cliente cliente;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getEnderecoalternativo() {
		return enderecoalternativo;
	}
	public void setEnderecoalternativo(String enderecoalternativo) {
		this.enderecoalternativo = enderecoalternativo;
	}
	public String getNumeroalternativo() {
		return numeroalternativo;
	}
	public void setNumeroalternativo(String numeroalternativo) {
		this.numeroalternativo = numeroalternativo;
	}
	

}
