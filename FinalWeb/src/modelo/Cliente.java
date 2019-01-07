package modelo;

public class Cliente extends Persona implements Comparable<Cliente> {

	private String zona;
	private String direccion;

	public Cliente(String usuario, String nombre, String apellido, int telefono, String contrasenia, String zona,
			String direccion) {
		super(usuario, nombre, apellido, telefono, contrasenia);
		this.zona = zona;
		this.direccion = direccion;
		// TODO Auto-generated constructor stub
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int compareTo(Cliente arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Cliente :" + super.toString();
	}

}
