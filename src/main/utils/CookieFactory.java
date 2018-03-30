package main.utils;

import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;

public class CookieFactory extends TimerTask{

	private static int numbCookies;
	private static int CCMultiplier;
	private static int CCPrice;
	private static int megaCookies;
	
	public static void loadCookieFactory() throws IOException {
		numbCookies = DataLoader.load("save/numbCookies.txt", 0);
		CCMultiplier = DataLoader.load("save/CCMultiplier.txt", 1);
		CCPrice = DataLoader.load("save/CCPrice.txt", 20);
		megaCookies = DataLoader.load("save/megaCookies.txt", 0);

	}

	public static int getCCPrice() {
		return CCPrice;
	}

	public static int getnumbCookies() {
		return numbCookies;
	}

	public static int getmegaCookies() {
		return megaCookies;
	}

	public static int onCookieClicked() {
		numbCookies = numbCookies + (1 * CCMultiplier);
		return numbCookies;
	}

	public static int ondoublecookieClickedMultiplier() {
		if (numbCookies >= CCPrice) {
			numbCookies = numbCookies - CCPrice;
			CCPrice = CCPrice * 4;
			CCMultiplier = CCMultiplier * 2;
			return numbCookies;
		} else {
			return numbCookies;
		}
	}

	public static void saveCookieFactory() throws IOException {
		DataLoader.save("save/numbCookies.txt", numbCookies);
		DataLoader.save("save/CCMultiplier.txt", CCMultiplier);
		DataLoader.save("save/CCPrice.txt", CCPrice);
		DataLoader.save("save/megaCookies.txt", megaCookies);
	}

	public static void resetSave() throws IOException {
		DataLoader.save("save/numbCookies.txt", 0);
		DataLoader.save("save/CCMultiplier.txt", 1);
		DataLoader.save("save/CCPrice.txt", 20);
		DataLoader.save("save/megaCookies.txt", 0);
	}

	public static int randomEvent() {
		if (numbCookies >= 1000) {
			Random random = new Random();
			numbCookies = (numbCookies - 1000) + (random.nextInt(2000));
			return numbCookies;
		} else {
			return numbCookies;
		}
	}

	@Override
	public void run() {
		if (numbCookies < 0) {
			numbCookies = numbCookies * 0;
			megaCookies++;
			CCMultiplier = 1 + megaCookies;
			CCPrice = 20 * (megaCookies + 1);
		}
		
	}

}
