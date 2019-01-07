package modelo;

public class Persona {
	private String usuario;
	private String nombre;
	private String apellido;
	private int telefono;
	private String contrasenia;
	
	public Persona(String usuario, String nombre, String apellido, int telefono,String contrasenia) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.setContrasenia(contrasenia);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return nombre +" "+apellido;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
