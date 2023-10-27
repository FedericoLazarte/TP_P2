package Amazing;

import java.util.Objects;

public abstract class Paquete {
	private int idPaquete = 0;
	private int volumen;
	private int precio;
	private boolean entregado;
	
	public Paquete(int volumen, int precio) {
		this.idPaquete = this.idPaquete++;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = false;
	}
	
	public abstract int totalAPagar();
	
	public boolean consultarSiElPaqueteFueEntregado() {
		return this.entregado;
	}
	
	public void marcarComoPaqueteEntregado() {
		this.entregado = true;
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
               precio == paquete.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen, precio);
    }

}
