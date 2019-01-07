package persistencia;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import modelo.Mensaje;
import persistencia.exc.UserNotFoundException;

public interface MensajesDao {

	public void setMensaje(Connection cn, Mensaje mensaje) throws SQLException, UserNotFoundException;

	public List<Mensaje> getMensaje(Connection cn, String username_cli, String username_trab)
			throws SQLException, UserNotFoundException;

}
