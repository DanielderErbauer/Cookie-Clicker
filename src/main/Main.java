package main;

import java.io.IOException;
import java.util.Timer;

import main.gui.ClickerGui;
import main.utils.CookieFactory;

public class Main {
	
	Timer timer;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.start();

	}
	
	public Main() throws IOException {
		CookieFactory.loadCookieFactory();
		timer = new Timer();
		timer.schedule(new CookieFactory(), 1000, 100);
	}
	
	public void start() {
		try {
			ClickerGui frame = new ClickerGui();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
