package Amazing;

public class Camion extends Transporte{
	private int valorAdicionalPorPaquetes;

	public Camion(String patente, int capacidadVolumenTotal, int precioPorViaje, int valorAdicionalPorPaquetes) {
	    super(patente, capacidadVolumenTotal, precioPorViaje);
	    this.valorAdicionalPorPaquetes = valorAdicionalPorPaquetes;
	}

	@Override
	public int costoTotalPorViaje() {
	    if (totalDePaquetesCargados() == 0) {
	        throw new RuntimeException("El transporte no está cargado");
	    }
	    return (totalDePaquetesCargados() * this.valorAdicionalPorPaquetes) + super.verPrecioPorViaje();
	}


	@Override
	public void cargarPaquete(Paquete paquete) {
		if (!paqueteValido(paquete)) {
			throw new RuntimeException("Los automóviles solo transportan paquete ordinarios, y con un volumen menor a 2000");
		}
		
		if(paqueteYaEstaCargado(paquete.verIdPaquete())) {
			throw new RuntimeException("El paquete ya se encuentra cargado");
		}
		
		super.cargamento().add(paquete);
	}

	
	
	private boolean paqueteValido(Paquete paquete) {
		boolean esEspecial = esUnPaqueteEspecial(paquete);
		boolean volumenMayorA2000 = esValidoElVolumenDelPaquete(paquete);
		return esEspecial && volumenMayorA2000;
	}
	
	private boolean esUnPaqueteEspecial(Paquete paquete) {
		return paquete instanceof PaqueteEspecial;
	}
	
	private boolean esValidoElVolumenDelPaquete(Paquete paquete) {
		return paquete.consultarVolumenDelPaquete() > 2000;
	}
}
