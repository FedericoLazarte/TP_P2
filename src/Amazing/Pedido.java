package Amazing;

import java.util.HashSet;
import java.util.Iterator;


public class Pedido {
	private int codigoPedido = 0;
	private Cliente cliente;
	private HashSet<Paquete> carritoDeCompras;
	private boolean pedidoCerrado;
	
	public Pedido(Cliente cliente) {
		this.codigoPedido++;
        this.cliente = cliente;
        this.carritoDeCompras = new HashSet<>();
        this.pedidoCerrado = false;
	}
	
	public int consultarNumeroPedido() {
		return this.codigoPedido;
	}
	
	public void agregarPaqueteAlCarrito(Paquete paquete) throws Exception {
		if (!pedidoCerrado) {
	        if (carritoDeCompras.contains(paquete)) {
	            throw new Exception("El paquete ya está en el carrito.");
	        } else {
	            carritoDeCompras.add(paquete);
	        }
	    } else {
	        throw new Exception("No se pueden agregar paquetes a un pedido cerrado.");
	    }
	}
	
	public void eliminarPaqueteDelCarrito(int idPaquete) throws Exception {
		if (!pedidoCerrado) {
            Iterator<Paquete> iterator = carritoDeCompras.iterator();
            while (iterator.hasNext()) {
                Paquete paquete = iterator.next();
                if (paquete.getId() == idPaquete) {
                    iterator.remove();
                }
            }
        } else {
            throw new Exception("No se pueden eliminar paquetes de un pedido cerrado.");
        }
	}
	
	public boolean consultarSiElPedidoEstaCerrado() {
		return this.pedidoCerrado;
	}
	
	public void cerrarPedido() throws Exception {
		if (!pedidoCerrado) {
            pedidoCerrado = true;
        } else {
        	throw new Exception("El pedido ya está cerrado.");
        }
	}
	
	public int totalAPagar() {
	    return calcularTotalAPagar(carritoDeCompras.iterator());
	}

	private int calcularTotalAPagar(Iterator<Paquete> iterator) {
	    if (!iterator.hasNext()) {
	        return 0;
	    } else {
	        Paquete paquete = iterator.next();
	        int precioPaquete = paquete.totalAPagar();
	        return precioPaquete + calcularTotalAPagar(iterator);
	    }
	}
}

/*
Un Iterator es una interfaz en Java que se utiliza para recorrer elementos en una 
colección (como un HashSet, ArrayList, HashMap, entre otros). Su principal propósito
es proporcionar un medio para acceder a los elementos de una colección de manera 
secuencial, sin exponer la estructura interna de la colección.
*/


