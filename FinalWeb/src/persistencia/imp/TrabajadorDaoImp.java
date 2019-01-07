package persistencia.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import modelo.Trabajador;
import persistencia.TrabajadorDao;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;

public class TrabajadorDaoImp implements TrabajadorDao {

	@Override
	public void setTrabajador(Connection cn, Trabajador trabajador) throws SQLException, UserAlreadyTaken {
		String sql1 = "INSERT INTO persona(usuario,nombre,apellido,num_telefono,contrasenia) VALUES ('%s','%s','%s','%s','%s')";
		String sql2 = "INSERT INTO trabajador(usuario_trabajador) VALUES ('%s')";
		try {
			Statement s = cn.createStatement();
			try {
				s.executeUpdate(String.format(sql1, trabajador.getUsuario(), trabajador.getNombre(),
						trabajador.getApellido(), trabajador.getTelefono(), trabajador.getContrasenia()));
				s.executeUpdate(String.format(sql2, trabajador.getUsuario()));
			} catch (SQLException ex) {
				throw new UserAlreadyTaken();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}

	}

	@Override
	public Trabajador getTrabajador(Connection cn, String username) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			Statement s = cn.createStatement();
			String sql = String.format(
					"SELECT * FROM persona p inner join trabajador t on p.usuario=t.usuario_trabajador where usuario='%s'",
					username);
			try {
				ResultSet rs = s.executeQuery(sql);
				rs.next();
				return new Trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public Trabajador loginTrabajador(Connection cn, String username, String password)
			throws SQLException, UserNotFoundException {
		try {
			Statement s = cn.createStatement();
			String sql = String.format(
					"SELECT * FROM persona p inner join cliente c on p.usuario=c.usuario_cliente where usuario='%s' and contrasenia='%s'",
					username, password);
			try {
				ResultSet rs = s.executeQuery(sql);
				rs.next();
				return new Trabajador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}

	}

	@Override
	public List<String> getRubros(Connection cn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from rubros";
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
	public void setRubros(Connection cn, Trabajador trabajador, List<String> rubros) throws SQLException {
		// TODO Auto-generated method stub
		Statement s;
		for (int i = 0; i < rubros.size(); i++) {
			try {
				s = cn.createStatement();
			} catch (SQLException ex) {
				// TODO: handle exception
				throw new SQLException();
			}
			try {
				String sql = "insert into trabajador_rubro (usuario_trabajador,rubro) values ('%s','%s')";
				s.executeUpdate(String.format(sql, trabajador.getUsuario(), rubros.get(i)));
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	@Override
	public List<String> getRubrosTrabajador(Connection cn, String username_trabajador)
			throws SQLException, UserNotFoundException {
		String sql = "select * from trabajador_rubro where usuario_trabajador='%s'";
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

}
