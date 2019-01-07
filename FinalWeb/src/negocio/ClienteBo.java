package negocio;

import java.sql.SQLException;

import modelo.Cliente;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;

public interface ClienteBo {

	public void setCliente(String username, String nombre, String apellido, int telefono, String password, String zona,
			String direccion) throws UserAlreadyTaken, SQLException, ClassNotFoundException, BadCredentialsException;

	public Cliente getCliente(String username) throws UserNotFoundException, SQLException, BadCredentialsException;

	public Cliente loginCliente(String username, String password) throws UserNotFoundException, SQLException, BadCredentialsException;
}
