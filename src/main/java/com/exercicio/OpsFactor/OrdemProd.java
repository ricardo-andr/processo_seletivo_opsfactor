package com.exercicio.OpsFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import Pedido.Produto;
import Producao.LinhaProd;

@Entity
@Table(name="ORDEM_PRODUCAO")
public class OrdemProd {
	@Transient
	private OrdemTransf ot;
	@Transient
	private Produto prod;
	@Transient
	private LinhaProd lp;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_prod;
	
	@Column(name="NUM_PEDIDO")
	private int num_pedido;
	
	@Column(name="QUANTIDADE_PROD")
	private long quantidade_prod;
	
	@Column(name="NOME_PROD")
	private String nome_prod;
	
	@Column(name="LINHA_PROD")
	private String linha_prod;
	
	public OrdemProd(OrdemTransf ot) {
		this.ot = ot;
		prod = ot.getProd();
		lp = new LinhaProd(prod);
		
		num_pedido = ot.getNum_pedido();
		quantidade_prod = ot.getQuantidade_prod();
		nome_prod = ot.getNome_prod();
		linha_prod = lp.getLinhaProd();
	}
	
	public OrdemProd() {
		
	}

	public OrdemTransf getOt() {
		return ot;
	}

	public Produto getProd() {
		return prod;
	}

	public LinhaProd getLp() {
		return lp;
	}
	
	public String toString() {
		return String.format("Produção de %d unidades do produto %s na linha %s", quantidade_prod, nome_prod, linha_prod);
	}
}
