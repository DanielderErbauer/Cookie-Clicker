package main.timertasks;

import java.util.TimerTask;

import main.utils.CookieFactory;

public class BackroundUpdateTimer extends TimerTask{

	@Override
	public void run() {
		CookieFactory.cookiesToMegaCookies();
		
	}

}
