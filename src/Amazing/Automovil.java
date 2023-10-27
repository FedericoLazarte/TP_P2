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
		return 0;
	}

	@Override
	public void cargarPaquete(Paquete paquete) {
		if (paqueteValido(paquete)) {
			if(hayEspacioParaCargar()) {
				super.cargamento().add(paquete);
			} else {
				throw new RuntimeException("Solo se puede cargar paquetes con un volumen menor a 2000");
			}
		} else {
			throw new RuntimeException("Los automóviles solo transportan paquetes ordinarios");
		}
		
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
	
	
	
	public boolean paqueteValido(Paquete paquete) {
		boolean esOrdinario = esUnPaqueteOrdinario(paquete);
		boolean volumenMenorA2000 = esValidoElVolumenDelPaquete(paquete);
		return esOrdinario && volumenMenorA2000;
	}
	
	public boolean hayEspacioParaCargar() {
		return totalDePaquetesCargados() <= this.limiteDePaquetes;
	}
	
	public boolean esUnPaqueteOrdinario(Paquete paquete) {
		return paquete instanceof PaqueteOrdinario;
	}
	
	public boolean esValidoElVolumenDelPaquete(Paquete paquete) {
		return paquete.consultarVolumenDelPaquete() < 2000;
	}


	
	

}
