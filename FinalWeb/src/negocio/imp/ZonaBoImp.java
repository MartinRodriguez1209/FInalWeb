package negocio.imp;

import java.sql.SQLException;
import java.util.List;

import Context.Context;
import modelo.Trabajador;
import negocio.ZonaBo;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.ZonaDaoImp;

public class ZonaBoImp implements ZonaBo {

	@Override
	public List<String> getZonas() throws SQLException {
		ZonaBoImp zona = new ZonaBoImp();
		try {
			return zona.getZonas();
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public List<String> getZonas(String username) throws UserNotFoundException, BadCredentialsException, SQLException {
		if (username.length() <= 50) {
			ZonaBoImp zona = new ZonaBoImp();
			try {
				return zona.getZonas(username);
			} catch (SQLException ex) {
				throw ex;
			}
		} else {
			throw new BadCredentialsException();
		}
	}

	@Override
	public void setZonas(Trabajador trabajador, List<String> zonas)
			throws SQLException, UserNotFoundException, ClassNotFoundException {
		try {
			ZonaDaoImp zona = new ZonaDaoImp();
			zona.setZonasTrabajador(Context.getConnection(), trabajador, zonas);
		} catch (SQLException ex) {
			throw ex;
		}
	}

}
