package persistencia.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import modelo.Trabajador;
import persistencia.ZonaDao;
import persistencia.exc.UserNotFoundException;

public class ZonaDaoImp implements ZonaDao {

	@Override
	public List<String> getZonas(Connection cn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from zona";
		List<String> rubros = new ArrayList<String>();
		try {
			Statement s = cn.createStatement();
			try {
				ResultSet rs = s.executeQuery(sql);
				while (rs.next())
					rubros.add(rs.getString(1));
				return rubros;
			} catch (SQLException ex) {
				throw new SQLException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public List<String> getZonasTrabajador(Connection cn, String username_trabajador)
			throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from area_trabajo where usuario_trabajador='%s'";
		List<String> rubros = new ArrayList<String>();
		try {
			Statement s = cn.createStatement();
			try {
				ResultSet rs = s.executeQuery(String.format(sql, username_trabajador));
				while (rs.next())
					rubros.add(rs.getString(2));
				return rubros;
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public void setZonasTrabajador(Connection cn, Trabajador trabajador, List<String> zonas)
			throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Statement s;
		for (int i = 0; i < zonas.size(); i++) {
			try {
				s = cn.createStatement();
			} catch (SQLException ex) {
				// TODO: handle exception
				throw new SQLException();
			}
			try {
				String sql = "insert into area_trabajo (usuario_trabajador,zona) values ('%s','%s')";
				s.executeUpdate(String.format(sql, trabajador.getUsuario(), zonas.get(i)));
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}

		}

	}

}
