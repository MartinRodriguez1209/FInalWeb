package modelo;

public class Contrato {

	private String usuario_cliente;
	private String usuario_trabajador;
	private String fecha;
	private String descripcion;
	private int terminado;
	private int idContrato;

	public Contrato(String usuario_cliente, String usuario_trabajador, String fecha, String descripcion,
			int terminado) {
		this.usuario_cliente = usuario_cliente;
		this.usuario_trabajador = usuario_trabajador;
		this.fecha = fecha;
		this.terminado = terminado;
		this.descripcion = descripcion;
	}

	public Contrato(String usuario_cliente, String usuario_trabajador, String fecha, String descripcion, int terminado,
			int idContrato) {
		super();
		this.usuario_cliente = usuario_cliente;
		this.usuario_trabajador = usuario_trabajador;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.terminado = terminado;
		this.idContrato = idContrato;
	}

	public Contrato(String usuario_cliente, String usuario_trabajador, String fecha) {
		super();
		this.usuario_cliente = usuario_cliente;
		this.usuario_trabajador = usuario_trabajador;
		this.fecha = fecha;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public int getTerminado() {
		return terminado;
	}

	public void setTerminado(int terminado) {
		this.terminado = terminado;
	}
}
