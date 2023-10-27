package Amazing;

public class Utilitario extends Transporte{
	private int valorExtra;

	public Utilitario(String patente, int capacidadVolumenTotal, int precioPorViaje, int valorExtra) {
		super(patente, capacidadVolumenTotal, precioPorViaje);
		this.valorExtra = valorExtra;
	}

	@Override
	public int costoTotalPorViaje() {
	    if (totalDePaquetesCargados() == 0) {
	        throw new RuntimeException("El transporte no está cargado");
	    }
	    return (totalDePaquetesCargados()) + super.verPrecioPorViaje();
	}

	@Override
	public void cargarPaquete(Paquete paquete) {
		if(paqueteYaEstaCargado(paquete.verIdPaquete())) {
			throw new RuntimeException("El paquete ya se encuentra cargado");
		}
		
		super.cargamento().add(paquete);
		
	}
}
