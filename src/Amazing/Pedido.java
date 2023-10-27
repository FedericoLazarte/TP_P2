package Amazing;

import java.util.HashSet;
import java.util.Iterator;


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
	
	public void agregarPaqueteAlCarrito(Paquete paquete) throws Exception {
		if (!pedidoCerrado) {
	        if (estaPaqueteEnElCarrito(paquete)) {
	            throw new Exception("El paquete ya está en el carrito.");
	        } else {
	            carritoDeCompras.add(paquete);
	        }
	    } else {
	        throw new Exception("No se pueden agregar paquetes a un pedido cerrado.");
	    }
	}
	
	public void eliminarPaqueteDelCarrito(int idPaquete) throws Exception {	
		if(!pedidoCerrado ) {
			Paquete paquete = buscarPaquetePorId(idPaquete);
			if (estaPaqueteEnElCarrito(paquete)) {
	            Iterator<Paquete> iterator = carritoDeCompras.iterator();
	            while (iterator.hasNext()) {
	                paquete = iterator.next();
	                if (paquete.verIdPaquete() == idPaquete) {
	                    iterator.remove();
	                }
	            }
	        } else {
	            throw new Exception("El paquete no se encuentra en el carrito" );
	        }
			
		} else {
			throw new RuntimeException("No se pueden eliminar paquetes de un pedido cerrado.");
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

/*
Un Iterator es una interfaz en Java que se utiliza para recorrer elementos en una 
colección (como un HashSet, ArrayList, HashMap, entre otros). Su principal propósito
es proporcionar un medio para acceder a los elementos de una colección de manera 
secuencial, sin exponer la estructura interna de la colección.
*/
