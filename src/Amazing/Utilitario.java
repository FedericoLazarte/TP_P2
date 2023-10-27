package Amazing;

import java.util.Objects;

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
	
	 @Override
	    public boolean equals(Object otroTransporte) {
	        if (this == otroTransporte) return true;
	        if (otroTransporte == null || getClass() != otroTransporte.getClass()) return false;
	        if (!super.equals(otroTransporte)) return false;
	        Utilitario utilitario = (Utilitario) otroTransporte;
	        return valorExtra == utilitario.valorExtra;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(super.hashCode(), valorExtra);
	    }
}
