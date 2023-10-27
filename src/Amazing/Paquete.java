package Amazing;

import java.util.Objects;

public abstract class Paquete {
    private static int proximoIdPaquete = 1;
	private int idPaquete;
	private int volumen;
	private int precio;
	private boolean entregado;
	
	public Paquete(int volumen, int precio) {
		if(volumen <= 0)
			throw new RuntimeException("El volumen no puede ser menor o igual que 0");
		if(precio <= 0)
			throw new RuntimeException("El precio no puede ser menor o igual que 0");
		this.idPaquete = proximoIdPaquete++;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = false;
	}
	
	public  abstract int totalAPagar();
	
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
        return this.idPaquete;
    }

    public int getPrecio() {
        return this.precio;
    }
    
    @Override
    public boolean equals(Object otroPaquete) {
        if (this == otroPaquete) return true;
        if (otroPaquete == null || getClass() != otroPaquete.getClass()) return false;
        Paquete paquete = (Paquete) otroPaquete;
        return volumen == paquete.volumen && precio == paquete.precio && entregado == paquete.entregado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen, precio, entregado);
    
    }

    
}
