package persistencia.imp;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import modelo.Cliente;
import persistencia.ClienteDao;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;

public class ClienteDaoImp implements ClienteDao {

	@Override
	public void setCliente(Connection cn, Cliente cliente) throws SQLException, UserAlreadyTaken {
		String sql1 = "INSERT INTO persona(usuario,nombre,apellido,num_telefono,contrasenia) VALUES ('%s','%s','%s','%s','%s')";
		String sql2 = "INSERT INTO cliente(usuario_cliente,zona,direccion) VALUES ('%s','%s','%s')";
		try {
			Statement s = cn.createStatement();
			try {
				s.executeUpdate(String.format(sql1, cliente.getUsuario(), cliente.getNombre(), cliente.getApellido(),
						cliente.getTelefono(), cliente.getContrasenia()));
				s.executeUpdate(String.format(sql2, cliente.getUsuario(), cliente.getZona(), cliente.getDireccion()));
			} catch (SQLException ex) {
				throw new UserAlreadyTaken();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}

	}

	@Override
	public Cliente getCliente(Connection cn, String username) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			Statement s = cn.createStatement();
			String sql = String.format(
					"SELECT * FROM persona p inner join cliente c on p.usuario=c.usuario_cliente where usuario='%s'",
					username);
			try {
				ResultSet rs = s.executeQuery(sql);
				rs.next();
				return new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), null,
						rs.getString(7), rs.getString(8));
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public Cliente loginCliente(Connection cn, String username, String password)
			throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			Statement s = cn.createStatement();
			String sql = String.format(
					"SELECT * FROM persona p inner join cliente c on p.usuario=c.usuario_cliente where usuario='%s' and contrasenia='%s'",
					username, password);
			try {
				ResultSet rs = s.executeQuery(sql);
				rs.next();
				return new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), null,
						rs.getString(7), rs.getString(8));
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

}
