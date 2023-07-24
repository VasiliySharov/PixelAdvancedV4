package app;

public class CommonFields {

	
	protected void sleep(int millis){
		try {Thread.sleep(millis);} catch (InterruptedException e) {e.printStackTrace();}
	}
	protected void println(Object obj) {
		System.out.println(obj);
	}
	
	protected void sendButton(int button){
		PixelsChecker.robot.keyPress(button);
		PixelsChecker.robot.keyRelease(button);
	}
}
