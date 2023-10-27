package Amazing;

public class Camion extends Transporte{
	private int valorAdicionalPorPaquetes;

	public Camion(String patente, int capacidadVolumenTotal, int precioPorViaje, int valorAdicionalPorPaquetes) {
		super(patente, capacidadVolumenTotal, precioPorViaje);
		this.valorAdicionalPorPaquetes = valorAdicionalPorPaquetes;
	}

	@Override
	public int costoTotalPorViaje() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cargarPaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarPaquete(int idPaquete) {
		// TODO Auto-generated method stub
		
	}

	

}
