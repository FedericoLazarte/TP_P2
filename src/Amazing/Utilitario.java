package Amazing;

public class Utilitario extends Transporte{
	private int valorExtra;

	public Utilitario(String patente, int capacidadVolumenTotal, int precioPorViaje, int valorExtra) {
		super(patente, capacidadVolumenTotal, precioPorViaje);
		this.valorExtra = valorExtra;
	}

	@Override
	public int costoTotalPorViaje() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cargarPaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		
	}
}
