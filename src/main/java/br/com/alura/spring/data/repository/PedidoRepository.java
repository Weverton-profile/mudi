package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.spring.data.model.Pedido;
import br.com.alura.spring.data.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);
	
}
