package main.utils;

import java.io.IOException;
import java.util.Random;

public class CookieFactory{

	private static int numbCookies;
	private static int clickerMultiplier;
	private static int doubleClickerPrice;
	private static int megaCookies;
	private static int grandmaPrice;
	private static int grandmaCount;
	private static int mineCount;
	private static int minePrice;
	private static int factoryCount;
	private static int factoryPrice;
	private static Random random;
	
	public static void loadCookieFactory() throws IOException {
		numbCookies = DataLoader.load("save/numbCookies.txt", 0);
		clickerMultiplier = DataLoader.load("save/clickerMultiplier.txt", 1);
		doubleClickerPrice = DataLoader.load("save/doubleClickerPrice.txt", 10000);
		megaCookies = DataLoader.load("save/megaCookies.txt", 0);
		grandmaPrice = DataLoader.load("save/grandmaPrice.txt", 10);
		grandmaCount = DataLoader.load("save/grandmaCount.txt", 0);
		mineCount = DataLoader.load("save/mineCount.txt", 0);
		minePrice = DataLoader.load("save/minePrice.txt", 100);
		factoryCount = DataLoader.load("save/factoryCount.txt", 0);
		factoryPrice = DataLoader.load("save/factoryPrice.txt", 500);
	}
	
	public static void saveCookieFactory() throws IOException {
		DataLoader.save("save/numbCookies.txt", numbCookies);
		DataLoader.save("save/clickerMultiplier.txt", clickerMultiplier);
		DataLoader.save("save/doubleClickerPrice.txt", doubleClickerPrice);
		DataLoader.save("save/megaCookies.txt", megaCookies);
		DataLoader.save("save/grandmaPrice.txt", grandmaPrice);
		DataLoader.save("save/grandmaCount.txt", grandmaCount);
		DataLoader.save("save/mineCount.txt", mineCount);
		DataLoader.save("save/minePrice.txt", minePrice);
		DataLoader.save("save/factoryCount.txt", factoryCount);
		DataLoader.save("save/factoryPrice.txt", factoryPrice);
	}

	public static void resetSave() throws IOException {
		DataLoader.save("save/numbCookies.txt", 0);
		DataLoader.save("save/clickerMultiplier.txt", 1);
		DataLoader.save("save/doubleClickerPrice.txt", 10000);
		DataLoader.save("save/megaCookies.txt", 0);
		DataLoader.save("save/grandmaPrice.txt", 10);
		DataLoader.save("save/grandmaCount.txt", 0);
		DataLoader.save("save/mineCount.txt", 0);
		DataLoader.save("save/minePrice.txt", 100);
		DataLoader.save("save/factoryCount.txt", 0);
		DataLoader.save("save/factoryPrice.txt", 500);
		
	}

	public static int getCCPrice() {
		return doubleClickerPrice;
	}

	public static int getnumbCookies() {
		return numbCookies;
	}

	public static int getmegaCookies() {
		return megaCookies;
	}
	
	public static int getGrandmaPrice() {
		return grandmaPrice;
	}
	
	public static int getMinePrice() {
		return minePrice;
	}
	
	public static int getFactoryPrice() {
		return factoryPrice;
	}

	public static int onCookiePressed() {
		numbCookies = numbCookies + (1 * clickerMultiplier);
		return numbCookies;
	}

	public static int ondoublecookieClickedMultiplier() {
		if (numbCookies >= doubleClickerPrice) {
			numbCookies -= doubleClickerPrice;
			doubleClickerPrice *= 10;
			clickerMultiplier *= 2;
			return numbCookies;
		} else {
			return numbCookies;
		}
	}

	public static int randomEvent() {
		if (numbCookies >= 1000) {
			random = new Random();
			numbCookies = (numbCookies - 1000) + (random.nextInt(2000));
			return numbCookies;
		} else {
			return numbCookies;
		}
	}
	
	public static void cookiesToMegaCookies() {
		if (numbCookies < 0) {
			numbCookies *= 0;
			megaCookies++;
			clickerMultiplier += 1 + megaCookies;
			doubleClickerPrice = 10000 * (megaCookies + 1);
		}
	}
	
	public static int onGrandmaPressed() {
		if (numbCookies >= grandmaPrice) {
			numbCookies -= grandmaPrice;
			grandmaCount++;
			grandmaPrice += (10 * grandmaCount);
			return grandmaCount;
		}
		return grandmaCount;
	}
	
	public static int onMinePressed() {
		if (numbCookies >= minePrice) {
			numbCookies -= minePrice;
			mineCount++;
			minePrice += (100 * mineCount);
			return mineCount;
		}
		return mineCount;
	}
	
	public static int onFactoryPressed() {
		if(numbCookies >= factoryPrice) {
			numbCookies -= factoryPrice;
			factoryCount++;
			factoryPrice += (500 * factoryCount);
			return factoryCount;
		}
		return factoryCount;
	}
	
	public static void grandmaBaking() {
		if (grandmaCount >= 1) {
			numbCookies += (1 * grandmaCount);
		}
	}
	
	public static void mineMining() {
		if (mineCount >= 1) {
			numbCookies += (10 * mineCount);
		}
	}
	
	public static void factoryFactoring() {
		if (factoryCount >= 1) {
			numbCookies += (50 * factoryCount);
		}
	}
	
	public static int getGeneralBackroundProduction() {
		return grandmaCount * 1 + mineCount * 10 + factoryCount * 50;
	}

}
