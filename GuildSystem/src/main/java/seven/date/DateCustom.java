package seven.date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class DateCustom {
	
	private SimpleDateFormat dateFormat;
	private Calendar cal;
	
	public DateCustom() {
		super();
		// TODO Auto-generated constructor stub
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal = Calendar.getInstance(Locale.KOREA);				
	}

	public int currentMaxDate(){
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
	}
	
	public String currentDate(){
		return dateFormat.format(cal.getTime());
	}
}
