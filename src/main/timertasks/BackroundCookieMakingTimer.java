package main.timertasks;

import java.util.TimerTask;

import main.utils.CookieFactory;

public class BackroundCookieMakingTimer extends TimerTask {

	@Override
	public void run() {
		CookieFactory.grandmaBaking();
		CookieFactory.mineMining();
	}

}
