package com.example.fw;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class HotKeyesHelper extends BaseHelper {
//	private static int CTRL = 17;
//	private static int R = 82;

	public HotKeyesHelper(ApplicationManager manager) {
		super(manager);
	}

	public void typeNewFolder() {
		typeHotKeyes(KeyEvent.VK_CONTROL, KeyEvent.VK_R);
	}

	private void typeHotKeyes(int keycode1, int keycode2) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(keycode1);
		robot.delay(20);
		robot.keyPress(keycode2);
		robot.delay(50);
		robot.keyRelease(keycode2);
		robot.delay(20);
		robot.keyRelease(keycode1);
	}

}
