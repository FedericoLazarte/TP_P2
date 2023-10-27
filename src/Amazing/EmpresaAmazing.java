package Amazing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class EmpresaAmazing implements IEmpresa {
	private String cuit;
	private ArrayList<Transporte> transportes;
	private ArrayList<Pedido> pedidos;
	private double facturacionTotalPedidosCerrados;

	public EmpresaAmazing(String cuit) {
		this.cuit = cuit;
		this.transportes = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.facturacionTotalPedidosCerrados = 0;
	}
	
	private Transporte obtenerTransporte(String patente) {
	    for (Transporte transporte : transportes) {
	        if (transporte.consultarPatente().equals(patente)) {
	            return transporte;
	        }
	    }
	    return null;
	}


	@Override
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		if (!transporteYaRegistrado(patente)) {
			Transporte automovil = new Automovil(patente, volMax, valorViaje, maxPaq);
			this.transportes.add(automovil);
		} else {
			throw new RuntimeException("El Vehículo ya se encuentra registado");
		}
	}

	@Override
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		if (!transporteYaRegistrado(patente)) {
			Transporte utilitario = new Utilitario(patente, volMax, valorViaje, valorExtra);
			this.transportes.add(utilitario);
		} else {
			throw new RuntimeException("El Vehículo ya se encuentra registado");
		}

	}

	@Override
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		if (!transporteYaRegistrado(patente)) {
			Transporte camion = new Camion(patente, volMax, valorViaje, adicXPaq);
			this.transportes.add(camion);
		} else {
			throw new RuntimeException("El Camión ya se encuentra registado");
		}
	}

	@Override
	public int registrarPedido(String cliente, String direccion, int dni) {
		Cliente clientePedido = new Cliente(cliente, dni, direccion);
		Pedido pedido = new Pedido(clientePedido);
		this.pedidos.add(pedido);

		return pedido.consultarNumeroPedido();
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {
		if (!pedidoYaRegistrado(codPedido))
			throw new RuntimeException("El pedido no se encuentra registrado");
		if (pedidoFinalizado(codPedido))
			throw new RuntimeException("El pedido se encuentra finalizado, no se pueden agregar más paquetes");
		Paquete paqueteOrdinario = new PaqueteOrdinario(volumen, precio, costoEnvio);
		Pedido pedido = damePedido(codPedido);
		pedido.agregarPaqueteAlCarrito(paqueteOrdinario);
		return pedido.consultarNumeroPedido();
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
		if (!pedidoYaRegistrado(codPedido))
			throw new RuntimeException("El pedido no se encuentra registrado");
		if (pedidoFinalizado(codPedido))
			throw new RuntimeException("El pedido se encuentra finalizado, no se pueden agregar más paquetes");
		Paquete paqueteEspecial = new PaqueteEspecial(volumen, precio, porcentaje, adicional);
		Pedido pedido = damePedido(codPedido);
		pedido.agregarPaqueteAlCarrito(paqueteEspecial);
		return pedido.consultarNumeroPedido();
	}

	@Override
	public boolean quitarPaquete(int codPaquete) {
		for (Pedido pedido : this.pedidos) {
			if (!pedido.consultarSiElPedidoEstaCerrado()) {
				if (pedido.eliminarPaqueteDelCarrito(codPaquete)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public double cerrarPedido(int codPedido) {
		Pedido pedido = damePedido(codPedido);
		if (pedido == null) {
			throw new RuntimeException("El pedido no se encuentra registrado");
		}
		if (pedido.consultarSiElPedidoEstaCerrado())
			throw new RuntimeException("El pedido ya está cerrado");
		double totalAPagar = pedido.totalAPagar();
		pedido.cerrarPedido();

		this.facturacionTotalPedidosCerrados += totalAPagar;

		return totalAPagar;
	}

	@Override
	public String cargarTransporte(String patente) {
	    Transporte transporte = obtenerTransporte(patente);
	    if (transporte == null) {
	        throw new RuntimeException("El transporte no está cargado.");
	    }

	    if (transporte.estaCargado()) {
	        return "Transporte cargado\n";
	    } else {
	        return "Transporte vacío\n";
	    }
	}



	@Override
	public double costoEntrega(String patente) {
	    Transporte transporte = buscarTransportePorPatente(patente);

	    if (transporte == null) {
	        throw new RuntimeException("La patente del transporte no está registrada.");
	    }

	    if (!transporte.estaCargado()) {
	        throw new RuntimeException("El transporte no está cargado.");
	    }

	    return transporte.costoTotalPorViaje();
	}


	@Override
	public Map<Integer, String> pedidosNoEntregados() {
		Map<Integer, String> pedidosNoEntregados = new HashMap<>();

		for (Pedido pedido : pedidos) {
			if (pedido.consultarSiElPedidoEstaCerrado()) {
				HashSet<Paquete> carritoDeCompras = pedido.verCarritoDeCompras();
				boolean tienePaquetesSinEntregar = false;

				Iterator<Paquete> iterator = carritoDeCompras.iterator();
				while (iterator.hasNext() && !tienePaquetesSinEntregar) {
					Paquete paquete = iterator.next();
					if (!paquete.consultarSiElPaqueteFueEntregado()) {
						tienePaquetesSinEntregar = true;
					}
				}

				if (tienePaquetesSinEntregar) {
					pedidosNoEntregados.put(pedido.consultarNumeroPedido(),
							pedido.verCliente().consultarNombreCliente());
				}
			}
		}

		return pedidosNoEntregados;
	}

	@Override
	public double facturacionTotalPedidosCerrados() {
		return this.facturacionTotalPedidosCerrados;
	}
	
	@Override
	public boolean hayTransportesIdenticos() {
	    int numTransportes = transportes.size();
	    
	    for (int i = 0; i < numTransportes; i++) {
	        Transporte transporteA = transportes.get(i);

	        for (int j = i + 1; j < numTransportes; j++) {
	            Transporte transporteB = transportes.get(j);

	            if (transporteA.equals(transporteB)) {
	                return true;  
	            }
	        }
	    }
	    
	    return false; 
	}




	@Override
	public String toString() {
		return "EmpresaAmazing [CUIT: " + cuit + "]";
	}


	private boolean transporteYaRegistrado(String patente) {
		for (Transporte transporte : this.transportes) {
			if (transporte.consultarPatente().equals(patente))
				return true;
		}
		return false;
	}

	private Transporte buscarTransportePorPatente(String patente) {
		for (Transporte transporte : transportes) {
			if (transporte.consultarPatente().equals(patente)) {
				return transporte;
			}
		}
		return null;
	}

	private boolean pedidoYaRegistrado(int idPedido) {
		for (Pedido pedido : this.pedidos) {
			if (pedido.consultarNumeroPedido() == idPedido)
				return true;
		}
		return false;
	}

	private Pedido damePedido(int idPedido) {
		for (Pedido pedido : this.pedidos) {
			if (pedido.consultarNumeroPedido() == idPedido)
				return pedido;
		}
		return null;
	}

	private boolean pedidoFinalizado(int idPedido) {
		Pedido pedido = damePedido(idPedido);
		return pedido.consultarSiElPedidoEstaCerrado();
	}

}
