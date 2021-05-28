package br.com.alura.mvc.mudi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeConroller {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos = repository.recuperaTodosOsPedidos();		
		model.addAttribute("pedidos", pedidos);

		return "home"; // referente a página home.hml
	}
}
