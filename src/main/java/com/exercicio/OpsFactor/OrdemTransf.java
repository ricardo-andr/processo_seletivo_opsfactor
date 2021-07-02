package com.exercicio.OpsFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import Pedido.Produto;
import Pedido.Unidade;

@Entity
@Table(name="ORDEM_TRANSFERENCIA")
public class OrdemTransf {
	
	@Transient
	private OrdemExped oe;
	@Transient
	private Produto prod;
	@Transient
	private Unidade uni;
	@Transient
	private Carteira_Pedido cp;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_transf;
	
	@Column(name="NUM_PEDIDO")
	private int num_pedido;
	
	@Column(name="QUANTIDADE_PROD")
	private long quantidade_prod;
	
	@Column(name="NOME_PROD")
	private String nome_prod;
	
	@Column(name="FABRICA")
	private String fabrica;
	
	@Column(name="ARMAZEM")
	private String armazem;
	
	public OrdemTransf(OrdemExped oe){
		this.oe = oe;
		
		cp = oe.getCp();
		prod = new Produto(oe.getNameProd(), oe.getQuant());
		uni = oe.getUni();
		
		num_pedido = oe.getNum_pedido();
		quantidade_prod = prod.getQuantidade();
		nome_prod = prod.getName();
		fabrica = uni.getFab();
		armazem = uni.getArm();
		
	}
	
	public OrdemTransf() {
		
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public long getQuantidade_prod() {
		return quantidade_prod;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public OrdemExped getOe() {
		return oe;
	}

	public Produto getProd() {
		return prod;
	}

	public Unidade getUni() {
		return uni;
	}

	public Carteira_Pedido getCp() {
		return cp;
	}
	
	public String toString() {
		return String.format("Transferência de %s unidades do produto %s da Fábrica %s para o armazém %s", quantidade_prod, nome_prod, fabrica, armazem);
	}
	
}
