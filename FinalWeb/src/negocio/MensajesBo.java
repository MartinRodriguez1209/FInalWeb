package negocio;

import java.sql.SQLException;
import java.util.List;

import modelo.Mensaje;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;

public interface MensajesBo {

	public void setMensaje(String usuario_cliente, String usuario_trabajador, String mensaje, String fecha)
			throws SQLException, UserNotFoundException, BadCredentialsException, ClassNotFoundException;

	public List<Mensaje> getMensajes(String username_cliente, String username_trabajador)
			throws SQLException, UserNotFoundException, BadCredentialsException, ClassCastException;

}
