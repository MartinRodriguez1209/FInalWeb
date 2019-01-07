package negocio;

import java.sql.SQLException;
import java.util.List;

import modelo.Trabajador;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;

public interface ZonaBo {

	public List<String> getZonas() throws SQLException;

	public List<String> getZonas(String username) throws UserNotFoundException, SQLException, BadCredentialsException;

	public void setZonas(Trabajador trabajador, List<String> zonas)throws SQLException,UserNotFoundException, ClassNotFoundException;

}
