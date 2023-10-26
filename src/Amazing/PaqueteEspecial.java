package Amazing;

public class PaqueteEspecial extends Paquete{
	private int porcentaje;
	private int adicional;
	
	public PaqueteEspecial(int volumen, int precio, int porcentaje, int adicional) {
		super(volumen, precio);
		this.porcentaje = porcentaje;
		this.adicional = adicional;
	}

	@Override
	public int totalAPagar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
