
public class TalkingClock {
	
	public static final String[] numbers= {"", "one", "two", "three", "four", "five", "six", "seven",
	            "eight", "nine", "ten", "eleven", "twelve",  "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
	        	"nineteen"};
	
	public static final String[] tens = { "twenty", "thirty", "fourty", "fifty" };
	
	public static String turnthetime(String message) {
		String[] time = message.split(":");
		String text = "";
		text += numbers[(Integer.parseInt(time[0]) % 12)] + " ";
		if(Integer.parseInt(time[1]) < 20){
			if(Integer.parseInt(time[1]) ==12) 
				text += numbers[12] + " ";
			else
				text += numbers[(Integer.parseInt(time[1]))] + " ";
		}
		else {
			//System.out.println(Integer.parseInt(time[1]) / 10 );
			text += tens[Integer.parseInt(time[1]) / 10 -2] + " " + numbers[Integer.parseInt(time[1]) % 10] + " ";
		}
		if(Integer.parseInt(time[0]) >= 12){
			text += "pm";
		}
		else {
			text += "am";
		}
		
		return text;
	}
	
	public static void main(String[] args) {
		
		System.out.println(turnthetime("01:30"));
		System.out.println(turnthetime("14:17"));
		
	}
}
