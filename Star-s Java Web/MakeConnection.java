import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class dbConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static Connection conn;
	
	private static dbConnectionFactory instance;
	
	static {
		Properties prop = new Properties();
		try {
			InputStream in = dbConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("=========数据读取失败=========");
		}
		
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	private dbConnectionFactory() {
		
	}
	
	public static dbConnectionFactory getInstance() {
		if (instance == null) {
			instance = new dbConnectionFactory();
		}
		return instance;
	}
	
	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		getInstance().makeConnection();
	}
}
