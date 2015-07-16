package py.edu.uaa.finalTrabajo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionPractica {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/registros";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "12345";
	
 
	public boolean insertarPractica(Practica practica) throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String insertTableSQL = "INSERT INTO practica"
				+ "(nro_cedula, cod_materia, fecha, cantidad_horas) VALUES"
				+ "(?,?,?,?)";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
			
			preparedStatement.setInt(1, practica.getCantidadHoras());
			preparedStatement.setString(2, practica.getNombreMateria());
			preparedStatement.setString(3, practica.getNombreMateria());
			preparedStatement.setString(4, practica.getNombreMateria());
 
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		
			System.out.println("Record is inserted into MATERIA table!");
			return true;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
	
}
