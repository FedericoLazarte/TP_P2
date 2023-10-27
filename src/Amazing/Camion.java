package Amazing;

import java.util.Objects;

public class Camion extends Transporte{
	private int valorAdicionalPorPaquetes;

	public Camion(String patente, int capacidadVolumenTotal, int precioPorViaje, int valorAdicionalPorPaquetes) {
		super(patente, capacidadVolumenTotal, precioPorViaje);
		this.valorAdicionalPorPaquetes = valorAdicionalPorPaquetes;
	}

	@Override
	public int costoTotalPorViaje() {
		return (super.totalDePaquetesCargados() * this.valorAdicionalPorPaquetes) + super.verPrecioPorViaje();
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
	
	 @Override
	    public boolean equals(Object otroTransporte) {
	        if (this == otroTransporte) return true;
	        if (otroTransporte == null || getClass() != otroTransporte.getClass()) return false;
	        if (!super.equals(otroTransporte)) return false;
	        Camion camion = (Camion) otroTransporte;
	        return valorAdicionalPorPaquetes == camion.valorAdicionalPorPaquetes;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(super.hashCode(), valorAdicionalPorPaquetes);
	    }

}
