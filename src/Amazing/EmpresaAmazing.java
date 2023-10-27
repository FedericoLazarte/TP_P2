package Amazing;

import java.util.ArrayList;
import java.util.Map;

public class EmpresaAmazing implements IEmpresa{
	private String cuit;
	private ArrayList<Transporte> transportes;
	private ArrayList<Pedido> pedidos;
	
	
	public EmpresaAmazing(String cuit) {
		this.cuit = cuit;
		this.transportes = new ArrayList<>();
		this.pedidos = new ArrayList<>();
	}
	

	@Override
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		if(!transporteYaRegistrado(patente)) {
			Transporte automovil = new Automovil(patente, volMax, valorViaje, maxPaq);
			this.transportes.add(automovil);
		} else {
			throw new RuntimeException("El Vehículo ya se encuentra registado");
		}
	}

	@Override
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		if(!transporteYaRegistrado(patente)) {
			Transporte utilitario = new Utilitario(patente, volMax, valorViaje, valorExtra);
			this.transportes.add(utilitario);
		} else {
			throw new RuntimeException("El Vehículo ya se encuentra registado");
		}
		
	}

	@Override
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		if(!transporteYaRegistrado(patente)) {
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
		if(!pedidoYaRegistrado(codPedido))
			throw new RuntimeException("El pedido no se encuentra registrado");
		if(pedidoFinalizado(codPedido))
			throw new RuntimeException("El pedido se encuentra finalizado, no se pueden agregar más paquetes");
		Paquete paqueteOrdinario = new PaqueteOrdinario(volumen, precio, costoEnvio);
		Pedido pedido = damePedido(codPedido);
		pedido.agregarPaqueteAlCarrito(paqueteOrdinario);
		return pedido.consultarNumeroPedido();
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean quitarPaquete(int codPaquete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double cerrarPedido(int codPedido) {
		if(!pedidoYaRegistrado(codPedido)) {
			throw new RuntimeException("El pedido no se encuentra registrado");
		}
		
		Pedido pedido = damePedido(codPedido);
		if(pedido.consultarSiElPedidoEstaCerrado()) {
			throw new RuntimeException("El pedido ya había sido cerrado");
		}
		
		pedido.cerrarPedido();
		
		return pedido.totalAPagar();
	}

	@Override
	public String cargarTransporte(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrega(String patente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Integer, String> pedidosNoEntregados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double facturacionTotalPedidosCerrados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hayTransportesIdenticos() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean transporteYaRegistrado(String patente) {
		for(Transporte transporte : this.transportes) {
			if(transporte.consultarPatente().equals(patente))
				return true;
		}
		return false;
	}
	
	private boolean pedidoYaRegistrado(int idPedido) {
		for(Pedido pedido : this.pedidos) {
			if(pedido.consultarNumeroPedido() == idPedido)
				return true;
		}
		return false;
	}
	
	private Pedido damePedido(int idPedido) {
		for(Pedido pedido : this.pedidos) {
			if(pedido.consultarNumeroPedido() == idPedido)
				return pedido;
		}
		return null;
	}
	
	private boolean pedidoFinalizado(int idPedido) {
		Pedido pedido = damePedido(idPedido);
		return pedido.consultarSiElPedidoEstaCerrado();
	}
	
	
}
