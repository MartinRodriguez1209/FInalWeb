package negocio;

import java.sql.SQLException;
import java.util.List;
import modelo.Trabajador;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;

public interface TrabajadorBo {

	public void setTrabajador(String username, String nombre, String apellido, int telefono, String password)
			throws UserAlreadyTaken, SQLException, ClassNotFoundException, BadCredentialsException;

	public Trabajador getTrabajador(String username)
			throws UserNotFoundException, SQLException, BadCredentialsException, ClassNotFoundException;

	public Trabajador loginTrabajador(String username, String password)
			throws UserNotFoundException, SQLException, BadCredentialsException, ClassNotFoundException;

	public List<String> getRubros() throws SQLException, ClassNotFoundException;

	public List<String> getRubrosTrabajador(String username_trabajador)
			throws SQLException, UserNotFoundException, ClassNotFoundException, BadCredentialsException;

	public void setRubros(Trabajador trabajador, List<String> rubros) throws SQLException, ClassNotFoundException;
}
