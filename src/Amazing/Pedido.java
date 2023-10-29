package Amazing;

import java.util.HashSet;

public class Pedido {
	private static int proximoCodPedido = 1;
	private int codigoPedido;
	private Cliente cliente;
	private HashSet<Paquete> carritoDeCompras;
	private boolean pedidoCerrado;
	
	public Pedido(Cliente cliente) {
		this.codigoPedido = proximoCodPedido++;
        this.cliente = cliente;
        this.carritoDeCompras = new HashSet<>();
        this.pedidoCerrado = false;
	}
	
	public int consultarNumeroPedido() {
		return this.codigoPedido;
	}
	
	public void agregarPaqueteAlCarrito(Paquete paquete){
		if(this.pedidoCerrado)
			throw new RuntimeException("No se pueden agregar paquetes a un pedido cerrado");
		if(estaPaqueteEnElCarrito(paquete))
			throw new RuntimeException("El paquete ya está en el carrito");
		this.carritoDeCompras.add(paquete);
	}
	
	public boolean eliminarPaqueteDelCarrito(int idPaquete) {
		if (pedidoCerrado) {
			throw new RuntimeException("No se puede eliminar paquetes de un pedido cerrado");
		}
	
		Paquete paquete = buscarPaquetePorId(idPaquete);
		if (paquete != null) {
			return carritoDeCompras.remove(paquete);
		}
		return false; // El paquete no se encontraba en el carrito.
	}
	
	
	public Cliente verCliente() {
		return this.cliente;
	}
	
	public boolean consultarSiElPedidoEstaCerrado() {
		return this.pedidoCerrado;
	}
	
	public HashSet<Paquete> verCarritoDeCompras() {
		return this.carritoDeCompras;
	}
	public void cerrarPedido() {
		if (!pedidoCerrado) {
            pedidoCerrado = true;
        } else {
        	throw new RuntimeException("El pedido ya está cerrado.");
        }
	}
	
	public int totalAPagar() {
	    return calcularTotalAPagar();
	}
	
	public Paquete damePaqueteDelCarrito(int idPaquete) {
		return buscarPaquetePorId(idPaquete);
	}
	
	public boolean estaPaqueteEnElCarrito(int idPaquete) {
		return carritoDeCompras.stream().anyMatch(paquete -> paquete.verIdPaquete() == idPaquete);
	}
	

	private int calcularTotalAPagar() {
		int sumaPrecios = 0;
		for(Paquete paq : this.carritoDeCompras) {
			sumaPrecios += paq.totalAPagar();
		}
		return sumaPrecios;
	}
	
	
	
	private boolean estaPaqueteEnElCarrito(Paquete paquete) {
		return this.carritoDeCompras.contains(paquete);
	}
	
	private Paquete buscarPaquetePorId(int idPaquete) {
		for(Paquete paquete : this.carritoDeCompras) {
			if(paquete.verIdPaquete() == idPaquete) {
				return paquete;
			}
		}
		return null;
	}
}

