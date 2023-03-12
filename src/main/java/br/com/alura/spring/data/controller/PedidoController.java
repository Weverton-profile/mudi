package br.com.alura.spring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.spring.data.dto.RequisicaoNovoPedido;
import br.com.alura.spring.data.model.Pedido;
import br.com.alura.spring.data.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoPedido requisicao, Model model) {
		if(requisicao.getNomeProduto().isBlank() 
				|| requisicao.getUrlImagem().isBlank() 
				|| requisicao.getUrlProduto().isBlank() 
				|| requisicao.getDescricao().isBlank()) {
			model.addAttribute("mensagem", "o formulário possui campos obrigatórios em branco.");
			return "pedido/formulario";
		}
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		return "home";
	}
	
}
