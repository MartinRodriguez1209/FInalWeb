package persistencia.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import modelo.Comentario;
import persistencia.ComentarioDao;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;


public class ComentarioDaoImp implements ComentarioDao {

	@Override
	public void setComentario(Connection cn, Comentario comentario) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO comentario (usuario_cliente,usuario_trabajador,contenido,fecha,puntuacion) VALUES"
				+ " ('%s','%s','%s','%s','%s')";
		try {
			Statement s = cn.createStatement();
			try {
				s.executeUpdate(String.format(sql, comentario.getUsuario_cliente(), comentario.getUsuario_trabajador(),
						comentario.getMensaje(), comentario.getFecha(), comentario.getPuntuacion()));
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public List<Comentario> getComentario(Connection cn, String username_trabajador)
			throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		List<Comentario> comentarios = new ArrayList<Comentario>();
		String sql = "SELECT * FROM mydb.comentario where usuario_trabajador='%s'";

		try {
			Statement s = cn.createStatement();
			try {
				ResultSet rs = s.executeQuery(String.format(sql, username_trabajador));
				while (rs.next()) {
					comentarios.add(new Comentario(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6)));
				}
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
			return comentarios;
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}
}
