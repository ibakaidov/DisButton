package dq;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class Clicker {
	Robot bot;
	public Clicker() throws Exception{
		bot = new Robot();
	}
	public void click(){
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
