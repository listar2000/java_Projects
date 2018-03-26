package tmall.bean;

public class User 
{
	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAnonymousName() 
	{
		if (username == null) return null;
		if (username.length() <= 0) return "*";
		if (username.length() == 2) return username.substring(0, 1) + "*";
		
		char [] name = username.toCharArray();
		for (int i = 1; i < name.length-1; i++) {
			name[i] = '*';
		}
		return new String(name);
	}
	//test
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("listar2000");
		System.out.println(user.getAnonymousName());
	}
}
