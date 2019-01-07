package negocio.imp;

import java.sql.SQLException;
import java.util.List;

import Context.Context;
import modelo.Contrato;
import negocio.ContratoBo;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.ContratoDaoImp;

public class ContratoBoImp implements ContratoBo {

	@Override
	public void setContrato(String usuario_cliente, String usuario_trabajador, String fecha, String descripcion)
			throws SQLException, ClassNotFoundException, BadCredentialsException, UserNotFoundException {
		if (usuario_cliente.length() <= 50 && usuario_trabajador.length() <= 50 && descripcion.length() <= 150) {
			ContratoDaoImp c = new ContratoDaoImp();
			try {
				c.setContrato(Context.getConnection(),
						new Contrato(usuario_cliente, usuario_trabajador, fecha, descripcion, 0));
			} catch (UserNotFoundException ex) {
				throw ex;
			} catch (SQLException ex) {
				throw ex;
			}
		} else {
			throw new BadCredentialsException();
		}
	}

	@Override
	public List<Contrato> getContratosCliente(String username)
			throws SQLException, ClassNotFoundException, BadCredentialsException, UserNotFoundException {
		if (username.length() <= 50) {
			ContratoDaoImp c = new ContratoDaoImp();
			try {
				return c.getContratoCli(Context.getConnection(), username);
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
	public List<Contrato> getContratosTRabajador(String username)
			throws SQLException, ClassNotFoundException, BadCredentialsException, UserNotFoundException {
		if (username.length() <= 50) {
			ContratoDaoImp c = new ContratoDaoImp();
			try {
				return c.getContratoTrab(Context.getConnection(), username);
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
	public void actualizarContrato(Contrato contrato) throws SQLException, ClassNotFoundException {
		ContratoDaoImp c = new ContratoDaoImp();
		try {
			c.actualizarContrato(Context.getConnection(), contrato);
		} catch (SQLException e) {
			throw e;
		}
	}
}
