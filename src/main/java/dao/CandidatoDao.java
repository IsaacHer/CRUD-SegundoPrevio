package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import modelo.Candidato;
import util.Conexion;


public class CandidatoDao {
	
	private Conexion conexion;

	public static final String INSERT_CANDIDATO_SQL = "INSERT INTO candidato (documento, nombre, apellido, eleccion, numero) VALUES(?,?,?,?,?);";
	public static final String DELETE_CANDIDATO_SQL = "DELETE FROM candidato WHERE id=?;";
	public static final String UPDATE_CANDIDATO_SQL = "UPDATE candidato SET documento = ?, nombre = ?, apellido = ?, eleccion = ?, numero = ? WHERE id = ?;";
	public static final String SELECT_CANDIDATO_BY_ID = "SELECT * FROM candidato WHERE id = ?:";
	public static final String SELECT_ALL_CANDIDATOS = "SELECT * FROM candidato;";
	
	
	public CandidatoDao() {
		this.conexion = Conexion.getConexion();
	}
	
	public void insert (Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(4, candidato.getEleccion());
			preparedStatement.setInt(5, candidato.getNumero());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_CANDIDATO_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void update(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(2, candidato.getEleccion());
			preparedStatement.setInt(3, candidato.getNumero());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public List<Candidato> selectAll() {
		List <Candidato> candidatos = new ArrayList<>();
		
		try {
			PreparedStatement  preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_CANDIDATOS);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int eleccion = rs.getInt("eleccion");
				int numero = rs.getInt("numero");
				candidatos.add(new Candidato(id, documento, nombre, apellido, eleccion, numero));
			}
		}catch(SQLException e) {}
		
		return candidatos;
	}
	
	public Candidato select(int id) {
		Candidato candidato = null;
		
		try {
			PreparedStatement  preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_CANDIDATO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int eleccion = rs.getInt("eleccion");
				int numero = rs.getInt("numero");
				candidato = new Candidato(id, documento, nombre, apellido, eleccion, numero);
			}
		}catch(SQLException e) {}
		
		return candidato;
	}
	
	
}
