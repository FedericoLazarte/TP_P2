package modelos;

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
	
	public abstract void quitarPaquete(int idPauqete);
	
	public HashSet<Paquete> listadoDePaquetesCargados() {
		HashSet<Paquete> ejem = new HashSet<>();
		return ejem;
	}
	
	public HashSet<Paquete> listadoDePaquetesNoEntregados() {
		HashSet<Paquete> ejem = new HashSet<>();
		return ejem;
	}
}
