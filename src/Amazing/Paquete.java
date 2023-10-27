package Amazing;

import java.util.Objects;

public abstract class Paquete {
    private static int proximoIdPaquete = 1;
	private int idPaquete;
	private int volumen;
	private int precio;
	private boolean entregado;
	
	public Paquete(int volumen, int precio) {
		this.idPaquete = proximoIdPaquete++;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = false;
	}
	
	public  int totalAPagar() {
		return this.precio;
	}
	
	public boolean consultarSiElPaqueteFueEntregado() {
		return this.entregado;
	}
	
	public void marcarComoPaqueteEntregado() {
        if(!this.entregado)
		    this.entregado = true;
        else 
            throw new RuntimeException("El paquete ya fue entregado");
	}
	
	public int consultarVolumenDelPaquete() {
		return this.volumen;
	}

	public int verIdPaquete() {
        return idPaquete;
    }

    public int getPrecio() {
        return precio;
    }
    
    @Override
    public boolean equals(Object otroPaquete) {
        if (this == otroPaquete) {
            return true;
        }
        if (otroPaquete == null || getClass() != otroPaquete.getClass()) {
            return false;
        }
        Paquete paquete = (Paquete) otroPaquete;
        return volumen == paquete.volumen &&
               precio == paquete.precio && getClass().equals(paquete.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen, precio);
    }

}
