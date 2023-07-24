package app;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class PixelsChecker extends CommonFields implements Runnable {
	static volatile Robot robot;
	static volatile BufferedImage imM;
	Rectangle bounds;
//
	public PixelsChecker() {
		bounds = new Rectangle();
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {

		while(true) {
			sleep(10);
			captureScreen();
//			println(Integer.toHexString(imM.getRGB(20, 20)));
		}
	}

	private void captureScreen(){
		bounds.setSize(125, 85);
		bounds.setLocation (0, 755);
		imM = robot.createScreenCapture(bounds);
	}
}
