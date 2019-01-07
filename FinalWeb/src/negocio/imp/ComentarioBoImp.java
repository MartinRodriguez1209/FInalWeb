package negocio.imp;

import java.sql.SQLException;
import java.util.List;

import Context.Context;
import modelo.Comentario;
import negocio.ComentarioBo;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.ComentarioDaoImp;

public class ComentarioBoImp implements ComentarioBo {

	@Override
	public void setComentario(String usuario_cliente, String usuario_trabajador, String mensaje, String fecha,
			int puntuacion) throws SQLException, UserNotFoundException, ClassNotFoundException {
		if (usuario_cliente.length() <= 50 && usuario_trabajador.length() <= 50 && mensaje.length() <= 300) {
			Comentario comentario = new Comentario(usuario_cliente, usuario_trabajador, mensaje, fecha, puntuacion);
			ComentarioDaoImp c = new ComentarioDaoImp();
			try {
				c.setComentario(Context.getConnection(), comentario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw e;
			} catch (UserNotFoundException e) {
				throw e;
			}
		}
	}

	@Override
	public List<Comentario> getComentario(String username_trabajador)
			throws SQLException, UserNotFoundException, ClassNotFoundException, BadCredentialsException {
		// TODO Auto-generated method stub
		if (username_trabajador.length() <= 50) {
			ComentarioDaoImp c = new ComentarioDaoImp();
			try {
				return c.getComentario(Context.getConnection(), username_trabajador);
			} catch (SQLException e) {
				throw e;
			} catch (UserNotFoundException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
	}
}
