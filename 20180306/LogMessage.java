import java.util.regex.Pattern;

public class LogMessage {
	
	//避免魔法数字，所以应该将所有的变量（定量）作为类成员声明。KEYWORD应该是final的。
	private String machineId;
	private String description;
	private final String KEYWORD;
	
	public LogMessage(String message, String keyword) {
		KEYWORD = keyword;
		String [] strings = message.split(":");
		machineId = strings[0];
		description = strings[1];
	}
	
	public boolean containsWord(String sentence) {
		
		if (sentence.startsWith(KEYWORD) || sentence.endsWith(KEYWORD)) {
			return true;
		}
		else if (Pattern.matches(".* "+KEYWORD+" .*", sentence)) {
			return true;
		}
		return false;
	}
	
	public String getMachineId() {
		return machineId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static void main(String[] args) {
		LogMessage message = new LogMessage("happy:adfadf Desk afdsfadi", "desk");
		System.out.println(message.getMachineId());
		System.out.println(message.getDescription());
		System.out.println(message.containsWord(message.getDescription()));
	}
}
