package negocio.imp;

import java.sql.SQLException;
import java.util.List;

import Context.Context;
import modelo.Trabajador;
import negocio.TrabajadorBo;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.TrabajadorDaoImp;

public class TrabajadorBoImp implements TrabajadorBo {

	@Override
	public void setTrabajador(String username, String nombre, String apellido, int telefono, String password)
			throws UserAlreadyTaken, SQLException, ClassNotFoundException, BadCredentialsException {
		if (username.length() <= 50 && nombre.length() <= 45 && apellido.length() <= 45 && password.length() <= 45) {
			Trabajador trabajador = new Trabajador(username, nombre, apellido, telefono, password);
			TrabajadorDaoImp t = new TrabajadorDaoImp();
			try {
				t.setTrabajador(Context.getConnection(), trabajador);
			} catch (UserAlreadyTaken e) {
				throw e;
			} catch (SQLException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public Trabajador getTrabajador(String username)
			throws UserNotFoundException, SQLException, BadCredentialsException, ClassNotFoundException {
		// TODO Auto-generated method stub
		if (username.length() <= 50) {

			TrabajadorDaoImp t = new TrabajadorDaoImp();
			try {
				return t.getTrabajador(Context.getConnection(), username);
			} catch (SQLException e) {
				throw e;
			} catch (UserNotFoundException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
	}

	@Override
	public Trabajador loginTrabajador(String username, String password)
			throws UserNotFoundException, SQLException, BadCredentialsException, ClassNotFoundException {
		// TODO Auto-generated method stub
		if (username.length() <= 50 && password.length() <= 45) {
			TrabajadorDaoImp t = new TrabajadorDaoImp();
			try {
				return t.loginTrabajador(Context.getConnection(), username, password);
			} catch (UserNotFoundException e) {
				throw e;
			} catch (SQLException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
	}

	@Override
	public List<String> getRubros() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		TrabajadorDaoImp t = new TrabajadorDaoImp();
		try {
			return t.getRubros(Context.getConnection());
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<String> getRubrosTrabajador(String username_trabajador)
			throws SQLException, UserNotFoundException, ClassNotFoundException, BadCredentialsException {
		// TODO Auto-generated method stub
		if (username_trabajador.length() <= 50) {
			try {
				TrabajadorDaoImp t = new TrabajadorDaoImp();
				return t.getRubrosTrabajador(Context.getConnection(), username_trabajador);
			} catch (SQLException e) {
				throw e;
			} catch (UserNotFoundException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
	}

	@Override
	public void setRubros(Trabajador trabajador, List<String> rubros) throws SQLException, ClassNotFoundException {
		TrabajadorDaoImp t = new TrabajadorDaoImp();
		try {
			t.setRubros(Context.getConnection(), trabajador, rubros);
		} catch (SQLException e) {
			throw e;
		}
	}
}
