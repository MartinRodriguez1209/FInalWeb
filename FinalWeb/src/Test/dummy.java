package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Context.Context;
import modelo.Cliente;
import modelo.Comentario;
import modelo.Contrato;
import modelo.Mensaje;
import modelo.Trabajador;
import negocio.exc.BadCredentialsException;
import negocio.imp.ClienteBoImp;
import negocio.imp.TrabajadorBoImp;
import persistencia.TrabajadorDao;
import persistencia.imp.TrabajadorDaoImp;
import persistencia.exc.UserAlreadyTaken;
import persistencia.exc.UserNotFoundException;
import persistencia.imp.ClienteDaoImp;
import persistencia.imp.ComentarioDaoImp;
import persistencia.imp.ContratoDaoImp;
import persistencia.imp.MensajeDaoImp;

public class dummy {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, UserAlreadyTaken,
			UserNotFoundException, BadCredentialsException {
		TrabajadorBoImp t = new TrabajadorBoImp();
		try {
			System.out.println(t.getTrabajador("cassrlos").getTelefono());
		} catch (UserNotFoundException e) {
			System.out.println("que clase de carlos es ese");
		} catch (SQLException e) {
			System.out.println("se fue todo al choto");
		}
	}
}
