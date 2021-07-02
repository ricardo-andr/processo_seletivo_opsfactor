package com.exercicio.OpsFactor;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Pedido.Produto;

@RestController	
@RequestMapping("/")
public class Controller_Process_App {
	
	@Autowired
	private ClienteCrud clienteCrud;
	
	@Autowired
	private CarteiraCrud carteiraCrud;
	
	@Autowired
	private ExpedicaoCrud expedicaoCrud;
	
	@Autowired
	private TransferenciaCrud transferenciaCrud;
	
	@Autowired
	private ProducaoCrud producaoCrud;
	
	@PostMapping("/regis_db")
	public String addContent() {
		 
		clienteCrud.deleteAll();
		carteiraCrud.deleteAll();
		expedicaoCrud.deleteAll();
		transferenciaCrud.deleteAll();
		producaoCrud.deleteAll();
		
		ArrayList<Cliente> cli = new ArrayList();
		ArrayList<Carteira_Pedido> cp = new ArrayList();
		ArrayList<OrdemExped> oe = new ArrayList();
		ArrayList<OrdemTransf> ot = new ArrayList();
		ArrayList<OrdemProd> op = new ArrayList();
		
		cli.add(new Cliente(5000,3));
		cli.add(new Cliente(7000,2));
		cli.add(new Cliente(3000,1));
		
		cp.add(new Carteira_Pedido(new Produto("X",2000), cli.get(0)));
		cp.add(new Carteira_Pedido(new Produto("Y",3000), cli.get(0)));
		cp.add(new Carteira_Pedido(new Produto("X",1500), cli.get(1)));
		cp.add(new Carteira_Pedido(new Produto("Y",1500), cli.get(1)));
		cp.add(new Carteira_Pedido(new Produto("X",2000), cli.get(2)));
		cp.add(new Carteira_Pedido(new Produto("Y",2000), cli.get(2)));
		
		for (int i=0;i<cli.size();i++) {
			clienteCrud.save(cli.get(i));
		}
		
		for (int i=0;i<cp.size();i++) {
			carteiraCrud.save(cp.get(i));
		}
		
		for(int i=0;i<carteiraCrud.count();i++) {
			
			oe.add(new OrdemExped(cp.get(i)));
			expedicaoCrud.save(oe.get(i));
			
			ot.add(new OrdemTransf(oe.get(i)));
			transferenciaCrud.save(ot.get(i));
			
			op.add(new OrdemProd(ot.get(i)));
			producaoCrud.save(op.get(i));
		}

		return "Clientes e Carteiras registrados no Banco de Dados com sucesso!";
	}
	
	/* Formacao da view por classe
	@GetMapping("/show_table_ordem")
	public String showExped() {
		
		String tab_exped, tab_transf, tab_prod;
		
		tab_exped = "<div>Ordem de Expedicao</div>";
		tab_transf = "<div>Ordem de Expedicao</div>";
		tab_prod = "<div>Ordem de Expedicao</div>";
		
		for (int i=0;i<carteiraCrud.count();i++) {
			tab_exped = String.format("%s %n <div>%s</div>", tab_exped, oe.get(i).toString());
			tab_transf = String.format("%s %n <div>%s</div>", tab_transf, ot.get(i).toString());
			tab_prod = String.format("%s %n <div>%s</div>", tab_prod, op.get(i).toString());
		}
		
		String tab_sugestoes = String.format(String.format("<div><div>%s</div> <br><br> <div>%s</div> <br><br> <div>%s</div></div>", tab_exped, tab_transf, tab_prod));
		
		return tab_sugestoes;
	}
	*/
	
	@GetMapping("/show_table_ordem")
	public String showExped() {
		
		ArrayList<OrdemExped> ordem_exped = new ArrayList();
		ArrayList<OrdemTransf> ordem_transf = new ArrayList();
		ArrayList<OrdemProd> ordem_prod = new ArrayList();
		
		for(OrdemExped oe: expedicaoCrud.findAll()) ordem_exped.add(oe);
		for(OrdemTransf ot: transferenciaCrud.findAll()) ordem_transf.add(ot);
		for(OrdemProd op: producaoCrud.findAll()) ordem_prod.add(op);
		
		String tab_exped, tab_transf, tab_prod;
		
		tab_exped = "<table><tr><td><h2>Ordem de Expedicao</h2></td></tr>";
		tab_transf = "<table><tr><td><h2>Ordem de Transferencia</h2></td></tr>";
		tab_prod = "<table><tr><td><h2>Ordem de Producao</h2></td></tr>";
		
		for (int i=0;i<carteiraCrud.count();i++) {
			tab_exped = String.format("%s <tr><td>%s</td></tr>", tab_exped, ordem_exped.get(i).toString());
			tab_transf = String.format("%s <tr><td>%s</td></tr>", tab_transf, ordem_transf.get(i).toString());
			tab_prod = String.format("%s <tr><td>%s</td></tr>", tab_prod, ordem_prod.get(i).toString());
		}
		
		String tab_sugestoes = String.format(String.format("%s</table> %s</table> %s</table>", tab_exped, tab_transf, tab_prod));
		
		return tab_sugestoes;
	}
}
