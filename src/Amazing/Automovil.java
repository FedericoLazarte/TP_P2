package Amazing;

import java.util.Iterator;

public class Automovil extends Transporte{
	private int limiteDePaquetes;

	public Automovil(String patente, int capacidadVolumenTotal, int precioPorViaje, int limiteDePaquetes) {
		super(patente, capacidadVolumenTotal, precioPorViaje);
		this.limiteDePaquetes = limiteDePaquetes;
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
		if (!paqueteValido(paquete)) {
			throw new RuntimeException("Los automóviles solo transportan paquete ordinarios, y con un volumen menor a 2000");
		}

		if(!hayEspacioParaCargar()) {
			throw new RuntimeException("Ya no se puede cargar más paquetes");
		}	

		if(paqueteYaEstaCargado(paquete.verIdPaquete())) {
			throw new RuntimeException("El paquete ya se encuentra cargado");
		}

		super.cargamento().add(paquete);
	}

	
	private boolean paqueteValido(Paquete paquete) {
		boolean esOrdinario = esUnPaqueteOrdinario(paquete);
		boolean volumenMenorA2000 = esValidoElVolumenDelPaquete(paquete);
		return esOrdinario && volumenMenorA2000;
	}
	
	private boolean hayEspacioParaCargar() {
		return totalDePaquetesCargados() <= this.limiteDePaquetes;
	}
	
	private boolean esUnPaqueteOrdinario(Paquete paquete) {
		return paquete instanceof PaqueteOrdinario;
	}
	
	private boolean esValidoElVolumenDelPaquete(Paquete paquete) {
		return paquete.consultarVolumenDelPaquete() < 2000;
	}


	
	

}
