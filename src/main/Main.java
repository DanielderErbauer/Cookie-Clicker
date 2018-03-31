package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import main.gui.ClickerGui;
import main.timertasks.BackroundUpdateTimer;
import main.timertasks.GrandmaBackingTimer;
import main.utils.CookieFactory;

public class Main {

	Timer timer;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.backroundTimer(new BackroundUpdateTimer(), 1000, 100);
		main.backroundTimer(new GrandmaBackingTimer(), 1000, 5000);
		main.start();

	}

	public Main() throws IOException {
		CookieFactory.loadCookieFactory();
		timer = new Timer();
	}
	
	public void textFieldUpdateTimer() {
		
	}

	public void start() {
		try {
			ClickerGui frame = new ClickerGui();
			frame.timer = new javax.swing.Timer(100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					frame.numbCookies = CookieFactory.getnumbCookies();
					frame.megaCookies = CookieFactory.getmegaCookies();
					frame.textField.setText("Cookies: " + frame.numbCookies);
					frame.megaCookiesTextField.setText("MegaCookies: " + frame.megaCookies);
				}
			});
			frame.timer.start();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void backroundTimer(TimerTask task, int starttime, int interval) {
		timer.schedule(task, starttime, interval);
	}	

}
