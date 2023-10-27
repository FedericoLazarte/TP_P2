package Amazing;

import java.util.Objects;

public class PaqueteEspecial extends Paquete{
	private int porcentaje;
	private int adicional;
	
	public PaqueteEspecial(int volumen, int precio, int porcentaje, int adicional) {
		super(volumen, precio);
		if(porcentaje <= 0)
			throw new RuntimeException("El porcentaje no puede ser menor o igual a 0");
		if(adicional <= 0)
			throw new RuntimeException("El adicional no puede ser menor o igual a 0");
		this.porcentaje = porcentaje;
		this.adicional = adicional;
	}

	@Override
	public int totalAPagar() {
	    int sumaPorcentaje = super.getPrecio() + (super.getPrecio() * this.porcentaje / 100);
	    if (super.consultarVolumenDelPaquete() > 5000) {
	        return sumaPorcentaje + (this.adicional * 2);
	    }

	    if (super.consultarVolumenDelPaquete() > 3000) {
	        return sumaPorcentaje + this.adicional;
	    }

	    return sumaPorcentaje;
	}
	
	@Override
	public boolean equals(Object otroPaquete) {
	    if (this == otroPaquete) {
	        return true;
	    }
	    if (otroPaquete == null || getClass() != otroPaquete.getClass()) {
	        return false;
	    }
	    if (!super.equals(otroPaquete)) {
	        return false;
	    }
	    PaqueteEspecial paquete = (PaqueteEspecial) otroPaquete;
	    return porcentaje == paquete.porcentaje && adicional == paquete.adicional;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(super.hashCode(), porcentaje, adicional);
	}



}
