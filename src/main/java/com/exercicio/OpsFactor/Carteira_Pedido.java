package com.exercicio.OpsFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import Pedido.Produto;

@Entity
@Table(name="CARTEIRA_PEDIDO")
public class Carteira_Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num_pedido;
	
	@Column(name="PRODUTO")
	private String prod_nome;
	
	@Column(name="CLIENTE")
	private int cliente_cnpj;
	
	@Column(name="QUANTIDADE")
	private long quantidade;
	
	@Transient
	private Produto prod;
	
	@Transient
	private Cliente cli;
	
	public Carteira_Pedido() {
		
	}
	
	public Carteira_Pedido(Produto prod, Cliente cli) {
		this.prod = prod;
		this.cli = cli;
		quantidade = prod.getQuantidade();
		cliente_cnpj = cli.getCnpj();
		prod_nome = prod.getName();
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public String getProd_nome() {
		return prod_nome;
	}

	public int getCliente_cnpj() {
		return cliente_cnpj;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public String toString() {
		return String.format("Pedido %d: produto %s, cliente cnpj %d, quantidade = %d", num_pedido, prod_nome, cliente_cnpj, quantidade);
	}
	
}
