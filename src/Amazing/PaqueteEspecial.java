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
		int sumaPorcentaje = (super.getPrecio() * (this.porcentaje/100)) + super.getPrecio();
		if(super.consultarVolumenDelPaquete() > 5000) {
			return sumaPorcentaje + (this.adicional * 2);
		}
		
		if(super.consultarVolumenDelPaquete() > 3000) {
			return sumaPorcentaje + this.adicional;
		}
		
		return sumaPorcentaje;	
	}

}
