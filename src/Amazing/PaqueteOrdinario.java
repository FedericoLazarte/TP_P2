package Amazing;

public class PaqueteOrdinario extends Paquete{
	private int constoEnvio;
	
	public PaqueteOrdinario(int volumen, int precio, int costoEnvio) {
		super(volumen, precio);
		this.constoEnvio = costoEnvio;
	}

	@Override
	public int totalAPagar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int consultarCostoEnvio() {
		return this.constoEnvio;
	}

}
