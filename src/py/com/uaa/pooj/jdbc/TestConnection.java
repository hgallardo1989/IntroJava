package py.com.uaa.pooj.jdbc;

//Se importan todas las clases del paquete para trabajo con SQL
import java.sql.*;

public class TestConnection {

	// Se declaran constantes con el nombre del driver JDBC y la URL de
	// coneccion. Esto es dependiente del motor
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/crmdata";

	// Credenciales para conectarse a la base de datos
	static final String USER = "gsoria";
	static final String PASS = "postgres";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Registrar el driver JDBC
			Class.forName("org.postgresql.Driver");

			// Abrir una conexion
			System.out.println("Conectandose a la base de datos..");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Ejecutar un query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from servicios.clientes";
			ResultSet rs = stmt.executeQuery(sql);

			// Extraer datos del resultset
			while (rs.next()) {
				// recuperar las columnas por nombre
				String nombre = rs.getString("nombre");
				String ruc = rs.getString("ruc");
				String direccion = rs.getString("direccion");

				int cod = rs.getInt("codintcli");

				// desplegar valores por consola
				System.out.print("Nombre: " + nombre);
				System.out.print(", RUC: " + ruc);
				System.out.print(", Direccion: " + direccion);
				System.out.println(", CodIntCli: " + cod);
			}
			// limpiar entorno
			rs.close();
			stmt.close();
			// cerrar conexiones
			conn.close();
		} catch (SQLException se) {
			// Si hay errores JDBC, manejarlos
			se.printStackTrace();
		} catch (Exception e) {
			// Manejar errores para la carga del driver Class.forName
			e.printStackTrace();
		} finally {
			//finally usado para cerrar conexiones 
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Adios!");
	}// end main
}// end TestConnection

