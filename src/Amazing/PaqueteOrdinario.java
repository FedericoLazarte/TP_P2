package Amazing;

public class PaqueteOrdinario extends Paquete{
	private int constoEnvio;
	
	public PaqueteOrdinario(int volumen, int precio, int costoEnvio) {
		super(volumen, precio);
		this.constoEnvio = costoEnvio;
	}

	@Override
	public int totalAPagar() {	
		return super.getPrecio() + this.constoEnvio;
	}
	
	public int consultarCostoEnvio() {
		return this.constoEnvio;
	}

}
