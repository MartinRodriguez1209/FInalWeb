package persistencia;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import modelo.Comentario;
import persistencia.exc.UserNotFoundException;

public interface ComentarioDao {

	public void setComentario(Connection cn, Comentario comentario) throws SQLException, UserNotFoundException;

	public List<Comentario> getComentario(Connection cn, String username_trabajador)
			throws SQLException, UserNotFoundException;

}
