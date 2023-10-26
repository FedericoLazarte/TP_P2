package Amazing;

public class Cliente {
	private String nombre;
	private int dni;
	private String direccion;
	
	public Cliente(String nombre, int dni, String direccion) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}
	
	public String consultarNombreCliente() {
		return this.nombre;
	}
	
	public int consultarDniCliente() {
		return this.dni;
	}
	
	public String consultarDireccionCliente() {
		return this.direccion;
	}
}
