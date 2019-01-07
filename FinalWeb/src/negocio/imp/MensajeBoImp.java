package negocio.imp;

import java.sql.SQLException;
import java.util.List;

import Context.Context;
import modelo.Mensaje;
import negocio.MensajesBo;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.MensajeDaoImp;

public class MensajeBoImp implements MensajesBo {

	@Override
	public void setMensaje(String usuario_cliente, String usuario_trabajador, String mensaje, String fecha)
			throws SQLException, UserNotFoundException, BadCredentialsException, ClassNotFoundException {
		if (usuario_cliente.length() <= 50 && usuario_trabajador.length() <= 50 && mensaje.length() <= 300) {
			MensajeDaoImp m = new MensajeDaoImp();
			try {
				m.setMensaje(Context.getConnection(), new Mensaje(usuario_cliente, usuario_trabajador, mensaje, fecha));
			} catch (SQLException e) {
				throw e;
			} catch (UserNotFoundException e) {
				throw e;
			}
		} else {
			throw new BadCredentialsException();
		}
	}

	@Override
	public List<Mensaje> getMensajes(String username_cliente, String username_trabajador)
			throws SQLException, UserNotFoundException, BadCredentialsException, ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

}
