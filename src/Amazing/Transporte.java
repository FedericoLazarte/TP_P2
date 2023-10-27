package Amazing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public abstract class Transporte {
	private String patente;
	private int capacidadVolumenTotal;
	private int precioPorViaje;
	private HashSet<Paquete> paquetesCargados;
	
	public Transporte(String patente, int capacidadVolumenTotal, int precioPorViaje) {
		this.patente = patente;
		this.capacidadVolumenTotal = capacidadVolumenTotal;
		this.precioPorViaje = precioPorViaje;
		this.paquetesCargados = new HashSet<>();
	}
	
	public abstract int costoTotalPorViaje();
	
	public abstract void cargarPaquete(Paquete paquete);
	
	public void quitarPaquete(int idPaquete) {
		if(paqueteYaEstaCargado(idPaquete)) {
			Iterator<Paquete> iterator = this.paquetesCargados.iterator();
			while(iterator.hasNext()) {
				Paquete paquete = iterator.next();
				if(paquete.verIdPaquete() == idPaquete) {
					iterator.remove();
				}
			}
		} else {
			throw new RuntimeException("El paquete no se encuentra en el cargamento");
		}
		
	}
	
	public String consultarPatente( ) {
		return this.patente;
	}
	
	public int verPrecioPorViaje() {
		return this.precioPorViaje;
	}
	
	public  boolean paqueteYaEstaCargado(int idPaquete) {
		for(Paquete paquete : this.paquetesCargados) {
			if (paquete.verIdPaquete() == idPaquete)
				return true;
		}
		return false;
	}
	
	public HashSet<Paquete> cargamento() {
		return this.paquetesCargados;
	}
	
	public HashSet<Paquete> listadoDePaquetesNoEntregados() {
		HashSet<Paquete> paquetesNoEntregados = new HashSet<>();
		for(Paquete paqueteNoEntregado : this.paquetesCargados) {
			if (!paqueteNoEntregado.consultarSiElPaqueteFueEntregado()) {
				paquetesNoEntregados.add(paqueteNoEntregado);
			}
		}
		return paquetesNoEntregados;
	}
	
	public int totalDePaquetesCargados() {
		return this.paquetesCargados.size();
	}
	
	public boolean estaCargado() {
	    return !paquetesCargados.isEmpty();
	}

	
	@Override
    public boolean equals(Object otroTransporte) {
        if (this == otroTransporte) 
        	return true;
        if (otroTransporte == null || getClass() != otroTransporte.getClass()) 
        	return false;
        Transporte transporte = (Transporte) otroTransporte;
        return !patente.equals(transporte.patente) &&
               getClass().equals(transporte.getClass()) &&  
               paquetesCargados.equals(transporte.paquetesCargados);  
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), paquetesCargados);
    }

}
