package main.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.utils.CookieFactory;
import main.utils.DataLoader;

public class ClickerGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCookies;
	private JButton btnCookieGen;
	private int numbCookies;
	private int megaCookies;
	private int grandmaCount;
	private int grandmaPrice;
	private int minePrice;
	private int mineCount;
	private int generalBackroundProduction;
	private int factoryCount;
	private int factoryPrice;
	private javax.swing.Timer timer;
	private JButton btnShutdown;
	private JButton btnSave;
	private JButton btnCcx;
	private JButton btnRandomcookies;
	private JTextField txtmegaCookies;
	private JTextField txtGrandmaCount;
	private JTextField txtMineCount;
	private JTextField txtGrandmaprice;
	private JTextField txtMineprice;
	private JTextField txtGeneralbackroundproduction;
	private JTextField txtFactorycount;
	private JTextField txtFactoryprice;

	public ClickerGui() throws IOException {
		megaCookies = DataLoader.load("save/megaCookies.txt", 0);
		numbCookies = DataLoader.load("save/numbCookies.txt", 0);
		grandmaCount = DataLoader.load("save/grandmaCount.txt", 0);
		mineCount = DataLoader.load("save/mineCount.txt", 0);
		minePrice = DataLoader.load("save/minePrice.txt", 100);
		grandmaPrice = DataLoader.load("save/grandmaPrice.txt", 10);
		factoryCount = DataLoader.load("save/factoryCount.txt", 0);
		factoryPrice = DataLoader.load("save/factoryPrice.txt", 500);
		generalBackroundProduction = CookieFactory.getGeneralBackroundProduction();
		this.setTitle("Cookie Clicker in Java");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		txtCookies = new JTextField();
		txtCookies.setBounds(10, 11, 261, 20);
		contentPane.add(txtCookies);
		txtCookies.setColumns(10);
		txtCookies.setText("Cookies: " + numbCookies);

		ImageIcon cookie = new ImageIcon("resources/cookie.png");
		btnCookieGen = new JButton(cookie);
		btnCookieGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbCookies = CookieFactory.onCookiePressed();
				megaCookies = CookieFactory.getmegaCookies();
				txtCookies.setText("Cookies: " + numbCookies);
				txtmegaCookies.setText("MegaCookies: " + megaCookies);

				try {
					playSound("resources/cookie.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnCookieGen.setBounds(20, 42, 62, 62);
		contentPane.add(btnCookieGen);
		btnCookieGen.setToolTipText("Click here to generate Cookies...");

		ImageIcon shutdown = new ImageIcon("resources/shutdown.png");
		btnShutdown = new JButton(shutdown);
		btnShutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CookieFactory.saveCookieFactory();
					System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShutdown.setBounds(362, 188, 62, 62);
		contentPane.add(btnShutdown);
		btnShutdown.setToolTipText("Shuts down your game and saves it.");

		ImageIcon save = new ImageIcon("resources/save.png");
		btnSave = new JButton(save);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CookieFactory.saveCookieFactory();
					Thread.sleep(500);
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(362, 42, 62, 62);
		contentPane.add(btnSave);
		btnSave.setToolTipText("Saves your progress!");

		ImageIcon ccx2 = new ImageIcon("resources/ccx2.png");
		btnCcx = new JButton(ccx2);
		btnCcx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbCookies = CookieFactory.ondoublecookieClickedMultiplier();
				txtCookies.setText("Cookies: " + numbCookies);
			}
		});
		btnCcx.setBounds(128, 42, 62, 62);
		contentPane.add(btnCcx);
		btnCcx.setToolTipText("Doubles your Cookies generated on click. Price: oldprice * 10, starting with 10,000");

		ImageIcon randomEvent = new ImageIcon("resources/randomEvent.png");
		btnRandomcookies = new JButton(randomEvent);
		btnRandomcookies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbCookies = CookieFactory.randomEvent();
				txtCookies.setText("Cookies: " + numbCookies);
			}
		});
		btnRandomcookies.setBounds(233, 42, 62, 62);
		contentPane.add(btnRandomcookies);
		btnRandomcookies.setToolTipText("Give 1000 and get a random amount between 0 & 2000");

		ImageIcon deleteSave = new ImageIcon("resources/delete.png");
		JButton btnDeletesave = new JButton(deleteSave);
		btnDeletesave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CookieFactory.resetSave();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnDeletesave.setBounds(362, 115, 62, 62);
		contentPane.add(btnDeletesave);
		btnDeletesave.setToolTipText("!!!WARNING!!!Resets your save and shuts down the program.");

		txtmegaCookies = new JTextField();
		txtmegaCookies.setBounds(281, 11, 143, 20);
		contentPane.add(txtmegaCookies);
		txtmegaCookies.setColumns(10);
		txtmegaCookies.setText("MegaCookies: " + megaCookies);

		ImageIcon grandma = new ImageIcon("resources/grandma.png");
		JButton btnGrandma = new JButton(grandma);
		btnGrandma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grandmaCount = CookieFactory.onGrandmaPressed();
				txtGrandmaCount.setText("G: " + grandmaCount);
				grandmaPrice = CookieFactory.getGrandmaPrice();
				txtGrandmaprice.setText("GP:" + grandmaPrice);
			}
		});
		btnGrandma.setBounds(20, 146, 62, 62);
		contentPane.add(btnGrandma);
		btnGrandma.setToolTipText(
				"One grandma gives you one cookie, every 2 seconds. Price: oldprice + grandmaCount * 10, price starting with 10.");

		txtGrandmaCount = new JTextField();
		txtGrandmaCount.setBounds(10, 226, 85, 20);
		contentPane.add(txtGrandmaCount);
		txtGrandmaCount.setColumns(10);
		txtGrandmaCount.setText("G: " + grandmaCount);
		txtGrandmaCount.setToolTipText("Grandmacount");

		ImageIcon mine = new ImageIcon("resources/mine.png");
		JButton btnMine = new JButton(mine);
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mineCount = CookieFactory.onMinePressed();
				minePrice = CookieFactory.getMinePrice();
				txtMineCount.setText("M: " + mineCount);
				txtMineprice.setText("MP: " + minePrice);
			}
		});
		btnMine.setBounds(128, 146, 62, 62);
		contentPane.add(btnMine);
		btnMine.setToolTipText(
				"One mine gives you 10 cookies, every 2 seconds. Price: oldprice + mineCount * 100, price starting with 100.");

		txtMineCount = new JTextField();
		txtMineCount.setBounds(117, 226, 85, 20);
		contentPane.add(txtMineCount);
		txtMineCount.setColumns(10);
		txtMineCount.setText("M: " + mineCount);
		txtMineCount.setToolTipText("Minecount");

		txtGrandmaprice = new JTextField();
		txtGrandmaprice.setText("grandmaprice");
		txtGrandmaprice.setBounds(10, 257, 85, 20);
		contentPane.add(txtGrandmaprice);
		txtGrandmaprice.setColumns(10);
		txtGrandmaprice.setText("GP:" + grandmaPrice);
		txtGrandmaprice.setToolTipText("Grandmaprice");

		txtMineprice = new JTextField();
		txtMineprice.setText("minePrice");
		txtMineprice.setBounds(117, 257, 85, 20);
		contentPane.add(txtMineprice);
		txtMineprice.setColumns(10);
		txtMineprice.setText("MP: " + minePrice);
		txtMineprice.setToolTipText("Mineprice");
		
		txtGeneralbackroundproduction = new JTextField();
		txtGeneralbackroundproduction.setBounds(10, 115, 342, 20);
		contentPane.add(txtGeneralbackroundproduction);
		txtGeneralbackroundproduction.setColumns(10);
		txtGeneralbackroundproduction.setToolTipText("GeneralBackroundProduction");
		
		ImageIcon factory = new ImageIcon("resources/factory.png");
		JButton btnFactory = new JButton(factory);
		btnFactory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				factoryCount = CookieFactory.onFactoryPressed();
				factoryPrice = CookieFactory.getFactoryPrice();
				txtFactorycount.setText("F: " + factoryCount);
				txtFactoryprice.setText("FP: " + factoryPrice);
			}
		});
		btnFactory.setBounds(233, 146, 62, 62);
		contentPane.add(btnFactory);
		btnFactory.setToolTipText("One factory gives you 50 cookies, every 2 seconds. Price: oldprice + factorycount * 500, price starting with 500");
		
		txtFactorycount = new JTextField();
		txtFactorycount.setText("factoryCount");
		txtFactorycount.setBounds(226, 226, 85, 20);
		contentPane.add(txtFactorycount);
		txtFactorycount.setColumns(10);
		txtFactorycount.setText("F: " + factoryCount);
		txtFactorycount.setToolTipText("Factorycount");
		
		
		txtFactoryprice = new JTextField();
		txtFactoryprice.setText("factoryPrice");
		txtFactoryprice.setBounds(226, 257, 85, 20);
		contentPane.add(txtFactoryprice);
		txtFactoryprice.setColumns(10);
		txtFactoryprice.setText("FP: " + factoryPrice);
		txtFactoryprice.setToolTipText("Factoryprice");

		setLocationRelativeTo(null);
	}

	public void updateGui() {
		timer = new javax.swing.Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numbCookies = CookieFactory.getnumbCookies();
				megaCookies = CookieFactory.getmegaCookies();
				generalBackroundProduction = CookieFactory.getGeneralBackroundProduction();
				txtCookies.setText("Cookies: " + numbCookies);
				txtmegaCookies.setText("MegaCookies: " + megaCookies);
				txtGeneralbackroundproduction.setText("GeneralBackroundProduction: "+generalBackroundProduction);
				
			}
		});
		timer.start();
	}

	public void playSound(String soundnamedotwav)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem
				.getAudioInputStream(new File(soundnamedotwav).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
}
