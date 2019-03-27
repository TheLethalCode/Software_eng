import java.sql.*;
public class UserDao {

	public static void create()
	{
		try
		{
			Connection con=DB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE SLOT " +
							"(sport CHAR(20) PRIMARY KEY    NOT NULL," +
							" sl1   INT    					NOT NULL, " + 
							" sl2   INT    					NOT NULL, " + 
							" sl3   INT    					NOT NULL, " + 
							" sl4   INT 					NOT NULL," + 
							" sl5   INT 					NOT NULL)"; 
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public static void initialise(String sport)
	{
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into USER(sport,sl1,sl2,sl3,sl4,sl5) values(?,?,?,?,?,?)");
			ps.setString(1,sport);
			ps.setString(2,"10");
			ps.setString(3,"10");
			ps.setString(4,"10");
			ps.setString(5,"10");
			ps.setString(6,"10");
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
	}

	public static int save(String name,String password,String email,String id_no,String residence,String contact){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into USER(name,password,email,id_no,residence,contact) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,id_no);
			ps.setString(5,residence);
			ps.setString(6,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from User where id_no=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static void main(String[] args) {
		create();
		initialise("Badminton");
		initialise("Gym");
		initialise("Squash");
		initialise("Swimming");
		initialise("Table Tennis");
		
	}
}
