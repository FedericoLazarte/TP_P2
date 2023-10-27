package Amazing;

import java.util.Objects;

public class PaqueteOrdinario extends Paquete{
	private int constoEnvio;
	
	public PaqueteOrdinario(int volumen, int precio, int costoEnvio) {
		super(volumen, precio);
		if(costoEnvio <= 0)
			throw new RuntimeException("El costo de envío no puede ser menor o igual a 0");
		this.constoEnvio = costoEnvio;
	}

	@Override
	public int totalAPagar() {	
		return super.getPrecio() + this.constoEnvio;
	}
	
	public int consultarCostoEnvio() {
		return this.constoEnvio;
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
	    PaqueteOrdinario paquete = (PaqueteOrdinario) otroPaquete;
	    return constoEnvio == paquete.constoEnvio;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(super.hashCode(), constoEnvio);
	}


}
