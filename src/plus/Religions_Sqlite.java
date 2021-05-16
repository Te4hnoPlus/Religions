package plus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Religions_Sqlite {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;

	public static void Conn() throws ClassNotFoundException, SQLException {
		   Class.forName("org.sqlite.JDBC");
		   
		   conn = DriverManager.getConnection("jdbc:sqlite:religions.s3db");
		   statmt = conn.createStatement();
		   System.out.println("База данных подключена");
	}
	
	public static void CreateDB() throws ClassNotFoundException, SQLException {
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'relig' text);");
	}

	public static void saveData(String nick, String relig) throws SQLException {
		statmt.execute(String.format("DELETE FROM 'users' WHERE name = '%s' ", nick));
		statmt.execute(String.format("INSERT INTO 'users' ('name', 'relig') VALUES ('%s', '%s')", nick, relig));
	}
	
	public static String getData(String nick) throws SQLException{
		
		ResultSet result = statmt.executeQuery(String.format("SELECT * FROM users WHERE name = '%s' ", nick));
		return result.getString("relig");
	}

	public static void CloseDB() throws ClassNotFoundException, SQLException{
		conn.close();
		statmt.close();
		resSet.close();
			
		System.out.println("База данных выключена");
	}
}