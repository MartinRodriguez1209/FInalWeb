package persistencia;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import modelo.Trabajador;
import persistencia.exc.UserNotFoundException;

public interface ZonaDao {

	public List<String> getZonas(Connection cn)throws SQLException;
	
	public List<String> getZonasTrabajador(Connection cn,String username_trabajador)throws SQLException,UserNotFoundException;
	
	public void setZonasTrabajador(Connection cn, Trabajador trabajador,List<String> zonas)throws SQLException,UserNotFoundException;
}
