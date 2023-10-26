package Amazing;

public class Automovil extends Transporte{
	private int limiteDePaquetes;

	public Automovil(String patente, int capacidadVolumenTotal, int precioPorViaje, int limiteDePaquetes) {
		super(patente, capacidadVolumenTotal, precioPorViaje);
		this.limiteDePaquetes = limiteDePaquetes;
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
	public void quitarPaquete(int idPauqete) {
		// TODO Auto-generated method stub
		
	}

}
