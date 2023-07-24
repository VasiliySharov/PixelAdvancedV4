package app;

public class PixelAction extends CommonFields implements Runnable {
	private int x;
	private int y;
	private String color;
	private int button;
	
	public PixelAction(int x, int y, String color, int button) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.button = button;
	}
	
	@Override
	public void run() {
		
		while(true) {
			sleep(10);
			pixAction();
		}	
	}
	
	private void pixAction() {
		
		if (getRefreshedColor().equals(this.color)) {
//			sendButton(button);
			println("pix action "+PixelsChecker.imM.getRGB(20,20));
//			println("true " + "'" + KeyEvent.getKeyText(this.button) + "'");
		} else {
//			println("false " + "'" + KeyEvent.getKeyText(this.button) + "'");
		}
	}
	
	private String getRefreshedColor() {
		if(PixelsChecker.imM != null) {
			int differceY = this.y - 755;
			int actualColor = PixelsChecker.imM.getRGB(this.x, differceY);
			String HexColor = Integer.toHexString(actualColor);
			String hexWithoutFF = HexColor.substring(HexColor.length()-6).toUpperCase();
			return hexWithoutFF;
		}
		return "";
	}
	


}
