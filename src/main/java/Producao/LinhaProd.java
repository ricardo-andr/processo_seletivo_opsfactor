package Producao;

import Pedido.Produto;

public class LinhaProd {
	private Produto prod;
	
	public LinhaProd(Produto prod) {
		this.prod = prod;
	}
	
	public String getLinhaProd() {
		return String.format("LP-%s", prod.getName());
	}
}
