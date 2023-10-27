package Amazing;

import java.util.HashSet;

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
	
	public String consultarPatente( ) {
		return this.patente;
	}
	
	public abstract int costoTotalPorViaje();
	
	public abstract void cargarPaquete(Paquete paquete);
	
	public abstract void quitarPaquete(int idPaquete);
	
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
}
