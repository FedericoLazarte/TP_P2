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
		if(super.consultarVolumenDelPaquete() > 5000) {
			return super.getPrecio() + this.porcentaje + (this.adicional * 2);
		}
		
		if(super.consultarVolumenDelPaquete() > 3000) {
			return super.getPrecio() + this.porcentaje + this.adicional;
		}
		
		return super.getPrecio() + this.porcentaje;	
	}

}
