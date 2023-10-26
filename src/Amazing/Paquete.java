package Amazing;

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
}
