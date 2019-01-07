package negocio.imp;

import java.sql.SQLException;
import Context.Context;
import modelo.Cliente;
import negocio.ClienteBo;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.ClienteDaoImp;

public class ClienteBoImp implements ClienteBo {

	@Override
	public void setCliente(String username, String nombre, String apellido, int telefono, String password, String zona,
			String direccion) throws UserAlreadyTaken, SQLException, ClassNotFoundException, BadCredentialsException {
		// TODO Auto-generated method stub
		if (username.length() <= 50 && nombre.length() <= 45 && apellido.length() <= 45 && password.length() <= 45
				&& zona.length() <= 45 && direccion.length() <= 100) {
			Cliente cliente = new Cliente(username, nombre, apellido, telefono, password, zona, direccion);
			ClienteDaoImp cd = new ClienteDaoImp();
			try {
				cd.setCliente(Context.getConnection(), cliente);
			} catch (UserAlreadyTaken e) {
				// TODO Auto-generated catch block
				throw new UserAlreadyTaken();
			} catch (SQLException e) {
				throw new SQLException();
			}

		} else
			throw new BadCredentialsException();

	}

	@Override
	public Cliente getCliente(String username) throws UserNotFoundException, SQLException, BadCredentialsException {
		// TODO Auto-generated method stub
		if (username.length() <= 50) {
			ClienteDaoImp c = new ClienteDaoImp();
			try {
				return c.getCliente(Context.getConnection(), username);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				throw e;
			} catch (UserNotFoundException e) {
				throw e;
			}
		} else
			throw new BadCredentialsException();
		return null;
	}

	@Override
	public Cliente loginCliente(String username, String password)
			throws UserNotFoundException, SQLException, BadCredentialsException {
		// TODO Auto-generated method stub
		if (username.length() <= 50 && password.length() <= 45) {
			ClienteDaoImp c = new ClienteDaoImp();
			try {
				return c.loginCliente(Context.getConnection(), username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				throw e;
			} catch (SQLException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
		return null;
	}

}
