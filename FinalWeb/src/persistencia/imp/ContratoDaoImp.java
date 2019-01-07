package persistencia.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import modelo.Contrato;
import persistencia.ContratoDao;
import persistencia.exc.UserNotFoundException;

public class ContratoDaoImp implements ContratoDao {

	@Override
	public void setContrato(Connection cn, Contrato contrato) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO contrato (usuario_cliente,usuario_trabajador,fecha,descripcion,terminado) values"
				+ " ('%s','%s','%s','%s',%d)";
		try {
			Statement s = cn.createStatement();
			try {
				s.executeUpdate(String.format(sql, contrato.getUsuario_cliente(), contrato.getUsuario_trabajador(),
						contrato.getFecha(), contrato.getDescripcion(), 0));
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public List<Contrato> getContratoCli(Connection cn, String username_cli)
			throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from contrato where usuario_cliente='%s'";
		List<Contrato> contratos = new ArrayList<Contrato>();
		try {
			Statement s = cn.createStatement();
			try {
				ResultSet rs = s.executeQuery(String.format(sql, username_cli));
				while (rs.next()) {
					contratos.add(new Contrato(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getInt(6), rs.getShort(1)));
				}
				return contratos;
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new ex;
		}
	}

	@Override
	public List<Contrato> getContratoTrab(Connection cn, String username_trab)
			throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from contrato where usuario_cliente='%s'";
		List<Contrato> contratos = new ArrayList<Contrato>();
		try {
			Statement s = cn.createStatement();
			try {
				ResultSet rs = s.executeQuery(String.format(sql, username_trab));
				while (rs.next()) {
					contratos.add(new Contrato(rs.getString(0), rs.getString(1), rs.getString(4), rs.getString(5),
							rs.getInt(6), rs.getInt(0)));
				}
				return contratos;
			} catch (SQLException ex) {
				throw new UserNotFoundException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	@Override
	public void actualizarContrato(Connection cn, Contrato contrato) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE contrato SET terminado='%d' WHERE idcontrato='%d'";
		try {
			Statement s = cn.createStatement();
			try {
				System.out.println(String.format(sql, contrato.getTerminado(), contrato.getIdContrato()));
				s.executeUpdate(String.format(sql, contrato.getTerminado(), contrato.getIdContrato()));
			} catch (SQLException ex) {
				throw new SQLException();
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

}
