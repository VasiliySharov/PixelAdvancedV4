package app;

public class SmartKick extends CommonFields implements Runnable {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private String color;
	private int button;

	public SmartKick(int x1, int y1, int x2, int y2, int x3, int y3, String color, int button) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.color = color;
		this.button = button;
	}
	
	@Override
	public void run() {
		
		// if we missed the cast then the next interrupt should be delayed. if the interrupted box appeared then make delay(put the flag interruprDelay = true)
		// if we miss again then the next should be no delay
		// Thread 1: check the interrupt status and change the flag;
		// Thread 2: check the cast;
		// Thread 3: check interrupt cd
		Thread_1 t1 = new Thread_1();
		t1.start();
		Thread_2 t2 = new Thread_2();
		t2.start();
		Thread_3 t3 = new Thread_3();
		t3.start();
//		while(true) {
//			
//			sleep(100);
//			pixAction();
//		}	
	}
	
	private void pixAction() {
		
		if (checkCasting()) {
//			sendButton(button);
			println("casting "+Integer.toHexString(PixelsChecker.imM.getRGB(20,20)));
//			println("true " + "'" + KeyEvent.getKeyText(this.button) + "'");

		} else {
//			println("false " + "'" + KeyEvent.getKeyText(this.button) + "'");

		}
	}
	
	boolean checkCasting() {
		return getRefreshedColor(x2, y2).equals(this.color);
	}
	
	boolean checkSucceedInterrupt() {
	return getRefreshedColor(x1, y1).equals(this.color);
	}
	
	boolean checkInterruptCD() {
	return getRefreshedColor(x3, y3).equals(this.color);
	}
	private String getRefreshedColor(int x, int y) {
		if(PixelsChecker.imM != null) {
			int differceY = y - 755;
			int actualColor = PixelsChecker.imM.getRGB(x, differceY);
			String HexColor = Integer.toHexString(actualColor);
			String hexWithoutFF = HexColor.substring(HexColor.length()-6).toUpperCase();
			return hexWithoutFF;
		}
		return "";
	}
	
	private class Thread_1 extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				checkInterrupt();
			}
		}
		private void checkInterrupt() {
			if (checkSucceedInterrupt()) {
				println("interrupted "+Integer.toHexString(PixelsChecker.imM.getRGB(x1, y1 - 755)));
			}
		}
	}
	private class Thread_2 extends Thread {
		@Override
		public void run() {
			while(true) {
				
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				checkCast();
			}	
		}
		
		private void checkCast() {
			if (checkCasting()) {
				println("casting "+Integer.toHexString(PixelsChecker.imM.getRGB(x2,y2 - 755)));
			}
		}
	}
	
	private class Thread_3 extends Thread {
		@Override
		public void run() {
			while(true) {
				
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				checkCD();
			}	
		}
		private void checkCD() {
			if (checkInterruptCD()) {
				println("CD "+Integer.toHexString(PixelsChecker.imM.getRGB(x3,y3 - 755)));
			}
		}
	}
}
