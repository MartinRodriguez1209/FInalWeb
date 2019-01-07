package modelo;

import java.util.ArrayList;
import java.util.List;

public class Trabajador extends Persona implements Comparable<Trabajador> {

	private List<String> rubros;
	private List<String> zonas;

	public List<String> getRubros() {
		return rubros;
	}

	public void setRubros(String rubros) {
		this.rubros.add(rubros);
	}

	public List<String> getZonas() {
		return zonas;
	}

	public void setZonas(String zonas, int i) {
		this.zonas.add(zonas);

	}

	public Trabajador(String usuario, String nombre, String apellido, int telefono, String contrasenia) {
		super(usuario, nombre, apellido, telefono, contrasenia);
		rubros = new ArrayList<String>();
		zonas = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Trabajador arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
