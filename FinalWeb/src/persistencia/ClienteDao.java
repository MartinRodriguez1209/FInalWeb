package persistencia;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import modelo.Cliente;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;

public interface ClienteDao {

	public void setCliente(Connection cn, Cliente cliente) throws SQLException,UserAlreadyTaken;

	public Cliente getCliente(Connection cn, String username) throws SQLException,UserNotFoundException;

	public Cliente loginCliente(Connection cn, String username, String password)
			throws SQLException, UserNotFoundException;

}
