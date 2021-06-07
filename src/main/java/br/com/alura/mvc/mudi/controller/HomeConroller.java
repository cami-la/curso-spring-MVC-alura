package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeConroller {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);		
		model.addAttribute("pedidos", pedidos);

		return "home"; // referente a página home.hml
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
