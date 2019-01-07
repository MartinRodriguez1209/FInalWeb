package negocio;

import java.sql.SQLException;
import java.util.List;
import modelo.Comentario;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;

public interface ComentarioBo {

	public void setComentario(String usuario_cliente, String usuario_trabajador, String mensaje, String fecha,
			int puntuacion) throws SQLException, UserNotFoundException, ClassNotFoundException;

	public List<Comentario> getComentario(String username_trabajador) throws SQLException, UserNotFoundException, ClassNotFoundException, BadCredentialsException;

}
