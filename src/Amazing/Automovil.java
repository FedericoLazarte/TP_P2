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
		// TODO Auto-generated method stub
		return super.verPrecioPorViaje();
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

	@Override
	public void quitarPaquete(int idPaquete) {
		if(paqueteYaEstaCargado(idPaquete)) {
			Iterator<Paquete> iterator = super.cargamento().iterator();
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
