package persistencia.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import modelo.Mensaje;
import persistencia.MensajesDao;
import persistencia.exc.UserNotFoundException;

public class MensajeDaoImp implements MensajesDao {

	@Override
	public void setMensaje(Connection cn, Mensaje mensaje) throws SQLException, UserNotFoundException {
		String sql = "insert into mensaje (usuario_cliente,usuario_trabajador,mensaje,fecha,hora) values ('%s','%s','%s',current_date(),current_time())";
		try {
			Statement s = cn.createStatement();
			try {
				s.executeUpdate(String.format(sql, mensaje.getUsuario_cliente(), mensaje.getUsuario_trabajador(),
						mensaje.getMensaje()));
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public List<Mensaje> getMensaje(Connection cn, String username_cli, String username_trab)
			throws SQLException, UserNotFoundException {
		String sql = "select * from mensaje where usuario_cliente='%s' and usuario_trabajador='%s'";
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		try {
			Statement s = cn.createStatement();
			try {
				ResultSet rs = s.executeQuery(String.format(sql, username_cli, username_trab));
				while (rs.next()) {
					mensajes.add(new Mensaje(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6)));
				}
				return mensajes;
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

}
