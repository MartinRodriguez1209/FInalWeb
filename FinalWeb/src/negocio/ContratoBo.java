package negocio;

import java.sql.SQLException;
import java.util.List;
import modelo.Contrato;
import negocio.exc.BadCredentialsException;
import persistencia.exc.UserNotFoundException;

public interface ContratoBo {

	public void setContrato(String usuario_cliente, String usuario_trabajador, String fecha, String descripcion)
			throws SQLException, ClassNotFoundException, BadCredentialsException, UserNotFoundException;

	public List<Contrato> getContratosCliente(String username)
			throws SQLException, ClassNotFoundException, BadCredentialsException, UserNotFoundException;

	public List<Contrato> getContratosTRabajador(String username)
			throws SQLException, ClassNotFoundException, BadCredentialsException, UserNotFoundException;

	public void actualizarContrato(Contrato contrato) throws SQLException, ClassNotFoundException;

}
