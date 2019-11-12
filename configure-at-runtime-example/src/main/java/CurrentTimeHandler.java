import java.util.Date;

public class CurrentTimeHandler implements Handler {
	@Override
	public String handle() {
		return new Date().toString();
	}
}
