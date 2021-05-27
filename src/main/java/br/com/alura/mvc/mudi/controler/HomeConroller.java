package br.com.alura.mvc.mudi.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeConroller {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Kindle Paperwhite 8 GB - Agora à prova d´água");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61ldUg%2BPqQL._AC_SL1000_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Kindle-Paperwhite-8GB-%C3%A0-prova-d%C2%B4%C3%A1gua/dp/B0773XBMB6/ref=asc_df_B0773XBMB6/?tag=googleshopp00-20&linkCode=df0&hvadid=379765355516&hvpos=&hvnetw=g&hvrand=11125534485196871156&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001624&hvtargid=pla-988775427992&psc=1");
		pedido.setDescricao("uma descrição qualquer para este pedido");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		
		model.addAttribute("pedidos", pedidos);
		
		return "home"; //referente a página home.hml
	}
}
