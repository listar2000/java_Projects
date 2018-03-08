import java.io.File;

public class Book {
	
	private String name;
	private File file;
	
	public Book(String name, String url) {
		this.name = name;
		this.file = new File(url);
	}
	
	public Book(File file) {
		this.name = file.getName();
		this.file = file;
	}

	public String getName() {
		return this.name;
	}
	
	public File getFile() {
		return this.file;
	}
	
}
