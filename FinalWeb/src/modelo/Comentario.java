package modelo;

public class Comentario {

	private String usuario_cliente;
	private String usuario_trabajador;
	private String mensaje;
	private String fecha;
	private int puntuacion;

	public Comentario(String usuario_cliente, String usuario_trabajador, String mensaje, String fecha, int puntuacion) {
		super();
		this.usuario_cliente = usuario_cliente;
		this.usuario_trabajador = usuario_trabajador;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.puntuacion = puntuacion;
	}

	public String getUsuario_cliente() {
		return usuario_cliente;
	}

	public void setUsuario_cliente(String usuario_cliente) {
		this.usuario_cliente = usuario_cliente;
	}

	public String getUsuario_trabajador() {
		return usuario_trabajador;
	}

	public void setUsuario_trabajador(String usuario_trabajador) {
		this.usuario_trabajador = usuario_trabajador;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

}
