package persistencia;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import modelo.Trabajador;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;

public interface TrabajadorDao {

	public void setTrabajador(Connection cn, Trabajador trabajador) throws SQLException, UserAlreadyTaken;

	public Trabajador getTrabajador(Connection cn, String username) throws SQLException, UserNotFoundException;

	public Trabajador loginTrabajador(Connection cn, String username, String password)
			throws SQLException, UserNotFoundException;

	public List<String> getRubros(Connection cn) throws SQLException;
	
	public List<String> getRubrosTrabajador(Connection cn,String username_trabajador) throws SQLException,UserNotFoundException;
	
	public void setRubros(Connection cn,Trabajador trabajador,List<String> rubros)throws SQLException;
	
	
}
