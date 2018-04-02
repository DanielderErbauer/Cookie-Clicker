package main;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import main.gui.ClickerGui;
import main.timertasks.BackroundUpdateTimer;
import main.timertasks.BackroundCookieMakingTimer;
import main.utils.CookieFactory;

public class Main {

	Timer timer;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.backroundTimer(new BackroundUpdateTimer(), 1000, 100);
		main.backroundTimer(new BackroundCookieMakingTimer(), 1000, 2000);
		main.start();

	}

	public Main() throws IOException {
		CookieFactory.loadCookieFactory();
		timer = new Timer();
	}

	public void start() {
		try {
			ClickerGui frame = new ClickerGui();
			frame.setVisible(true);
			frame.updateGui();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void backroundTimer(TimerTask task, int starttime, int interval) {
		timer.schedule(task, starttime, interval);
	}	

}
