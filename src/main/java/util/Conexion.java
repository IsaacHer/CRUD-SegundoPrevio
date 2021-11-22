package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private Connection con = null;
	private static Conexion db;
	private PreparedStatement preparedStatement;
	
	private static final String url = "postgres://mnjgxshj:Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV@queenie.db.elephantsql.com/mn\r\n"
			+ "jgxshj";
	private static final String dbname = "mnjgxshj";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	/*
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String dbname = "sistema";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "";
	*/
	public Conexion() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbname, userName, password);
		}catch(InstantiationException | IllegalAccessException 
				| ClassNotFoundException | SQLException e) {
			//TODO Auto-generated cath block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion() {
		if(db == null) {
			return db = new Conexion();
		}
		return db;
	}
	
	
	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	public int execute() throws SQLException{
		int result = preparedStatement.executeUpdate();
		return result;
	}
	
	public Connection getCon() {
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement (String sql) throws SQLException {
		
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
}
