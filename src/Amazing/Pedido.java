package Amazing;

import java.util.HashSet;

public class Pedido {
	private int codigoPedido = 0;
	private Cliente cliente;
	private HashSet<Paquete> carritoDeCompras;
	private boolean pedidoCerrado;
	
	public Pedido(Cliente cliente) {
		this.codigoPedido = this.codigoPedido++;
		this.cliente = cliente;
		this.carritoDeCompras = new HashSet<>();
		this.pedidoCerrado = false;
	}
	
	public int consultarNumeroPedido() {
		return this.codigoPedido;
	}
	
	public void agregarPaqueteAlCarrito(Paquete paquete) {
		
	}
	
	public void eliminarPaqueteDelCarrito(int idPaquete) {
		
	}
	
	public boolean consultarSiElPedidoEstaCerrado() {
		return this.pedidoCerrado;
	}
	
	public void cerrarPedido() {
		this.pedidoCerrado = true;
	}
	
	public int totalApagar() {
		return 0;
	}
}
