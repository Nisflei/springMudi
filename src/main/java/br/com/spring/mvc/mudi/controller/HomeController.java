package br.com.spring.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.spring.mvc.mudi.model.Pedido;
import br.com.spring.mvc.mudi.model.StatusPedido;
import br.com.spring.mvc.mudi.repository.PedidoRepository;
import br.com.spring.mvc.mudi.repository.PedidoRepository_JPA;

@Controller
public class HomeController {

	// usando springDATA
	@Autowired
	private PedidoRepository repository;

	// usando JPA
	@Autowired
	private PedidoRepository_JPA repositoryJPA; 	 


	@GetMapping("/home/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		// usando springDATA
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));

		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status",status);
		return "home";
	}	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
	
	@GetMapping("/home")
	public String home(Model model) {
		// usando springDATA
		List<Pedido> pedidos = repository.findAll();

		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	
	@GetMapping("/homeJPA")
	public String homeJPA(Model model) {
		// usando JPA
		List<Pedido> pedidos = repositoryJPA.recuperaTodosOsPedidos();
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	
	
	
	
	@GetMapping("/homeFIXO")
	public String homeFIXO(Model model) {

		Pedido pedido = new Pedido();

		pedido.setNomeProduto("Celular Realme 8i 4GB+64GB Roxo");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/717vzzRvwHL._AC_SX522_.jpg");
		pedido.setUrlProduto(
				"https://www.amazon.com.br/Celular-Realme-4GB-64GB-Roxo/dp/B09TWMWYP6/ref=sr_1_2_sspa?keywords=celular&qid=1648651919&sprefix=celu%2Caps%2C240&sr=8-2-spons&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExSU8xVzRCMVBPNzlFJmVuY3J5cHRlZElkPUEwMDU3OTIxMzJKNEtPR1RZUU85WSZlbmNyeXB0ZWRBZElkPUEwMjk0MTg3Mk05TEVXQ1ZJNkNWNiZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=");
		pedido.setDescricao("DADOS FIXOS");

		List<Pedido> pedidos = Arrays.asList(pedido);

		model.addAttribute("pedidos", pedidos);
		return "home";
	}

}
