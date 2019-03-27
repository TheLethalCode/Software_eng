import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:test.db");
		 } catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		 }
		 return con;
	}

}
