package persistencia;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import modelo.Contrato;
import persistencia.exc.UserNotFoundException;

public interface ContratoDao {

	public void setContrato(Connection cn, Contrato contrato) throws SQLException, UserNotFoundException;

	public List<Contrato> getContratoCli(Connection cn, String username_cli) throws SQLException, UserNotFoundException;

	public List<Contrato> getContratoTrab(Connection cn, String username_trab)
			throws SQLException, UserNotFoundException;

	public void actualizarContrato(Connection cn, Contrato contrato) throws SQLException;
}
