package app;

import static java.awt.event.KeyEvent.VK_7;


public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		
		Thread pixelsChecker = new Thread(new PixelsChecker());
		pixelsChecker.start();

		
//		m.checkPixel(19, 762, "00FF00", VK_7);
//		m.smartKick(31, 779, 63, 785, 100, 781, "00FF00", VK_7);

		
		System.out.println(Thread.activeCount() + " threads running");
	}

	private void checkPixel(int x, int y, String color, int button) {
		PixelAction p = new PixelAction(x, y,color , button);
		Thread thread = new Thread(p);
		thread.start();
	}
	

//	private void smartKick(int x1, int y1, int x2, int y2, int x3, int y3, String color, int button) {
//		SmartKick p = new SmartKick(x1, y1, x2, y2, x3, y3, color , button);
//		Thread thread = new Thread(p);
//		thread.start();
//	}
}
