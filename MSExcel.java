package ph.com.bpi.hello.M2_Act4;

public class MSExcel implements Executable2 {
	
	@Override
	public void run() {
		String message = "Opening MS Excel...";
		System.out.println(message);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Excel...";
		System.out.println(message);
	}
}
