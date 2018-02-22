import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.star.dao.IUserDao;
import com.star.dao.UserDaoImpl;
import com.star.entities.UserEntity;
import com.star.util.dbConnectionFactory;

public class DbService {
	
	private DbService dbService;
	private dbConnectionFactory factory = dbConnectionFactory.getInstance();
	private Connection connection;
	private IUserDao daoImpl;
	
	private DbService() {
		connection = factory.makeConnection();
		daoImpl = new UserDaoImpl();
	}
	
	public boolean isLoggable(UserEntity user) {
		
		boolean canLog = false;
		
		try {
			
			ResultSet set = daoImpl.getUser(user, connection);
			
			if (set.next()) {
				canLog = true;
			}
			
			set.close();
			connection.close();
		} 
		
		catch (SQLException e) {
			try 
			{
				connection.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally {
			if (connection != null) {
				try 
				{
					connection.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return canLog;
	}
	
	public DbService getInstance() {
		
		if (dbService == null) {
			dbService = new DbService();
		}
		
		return dbService;
	}
	

}
