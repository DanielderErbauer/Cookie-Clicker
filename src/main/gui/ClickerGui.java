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
	private JTextField cookiesTextField;
	private JButton btnCookieGen;
	private int numbCookies;
	private int megaCookies;
	private int grandmaCount;
	private int grandmaPrice;
	private int minePrice;
	private int mineCount;
	private javax.swing.Timer timer;
	private JButton btnShutdown;
	private JButton btnSave;
	private JButton btnCcx;
	private JButton btnRandomcookies;
	private JTextField megaCookiesTextField;
	private JTextField grandmasTextField;
	private JTextField txtMine;
	private JTextField txtGrandmaprice;
	private JTextField txtMineprice;

	public ClickerGui() throws IOException {
		megaCookies = DataLoader.load("save/megaCookies.txt", 0);
		numbCookies = DataLoader.load("save/numbCookies.txt", 0);
		grandmaCount = DataLoader.load("save/grandmaCount.txt", 0);	
		mineCount = DataLoader.load("save/mineCount.txt", 0);	
		minePrice = DataLoader.load("save/minePrice.txt", 100);
		grandmaPrice = DataLoader.load("save/grandmaPrice.txt", 10);
		this.setTitle("Cookie Clicker in Java");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		cookiesTextField = new JTextField();
		cookiesTextField.setBounds(10, 11, 261, 20);
		contentPane.add(cookiesTextField);
		cookiesTextField.setColumns(10);
		cookiesTextField.setText("Cookies: " + numbCookies);

		ImageIcon cookie = new ImageIcon("resources/cookie.png");
		btnCookieGen = new JButton(cookie);
		btnCookieGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbCookies = CookieFactory.onCookiePressed();
				megaCookies = CookieFactory.getmegaCookies();
				cookiesTextField.setText("Cookies: " + numbCookies);
				megaCookiesTextField.setText("MegaCookies: " + megaCookies);
				try {
					playSound("resources/cookie.wav");
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCookieGen.setBounds(10, 42, 62, 62);
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
				cookiesTextField.setText("Cookies: " + numbCookies);
			}
		});
		btnCcx.setBounds(82, 42, 62, 62);
		contentPane.add(btnCcx);
		btnCcx.setToolTipText("Doubles your Cookies generated on click. Price: Amount * 10, starting with 10,000");

		ImageIcon randomEvent = new ImageIcon("resources/randomEvent.png");
		btnRandomcookies = new JButton(randomEvent);
		btnRandomcookies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbCookies = CookieFactory.randomEvent();
				cookiesTextField.setText("Cookies: " + numbCookies);
			}
		});
		btnRandomcookies.setBounds(154, 42, 62, 62);
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

		megaCookiesTextField = new JTextField();
		megaCookiesTextField.setBounds(281, 11, 143, 20);
		contentPane.add(megaCookiesTextField);
		megaCookiesTextField.setColumns(10);
		megaCookiesTextField.setText("MegaCookies: " + megaCookies);

		ImageIcon grandma = new ImageIcon("resources/grandma.png");
		JButton btnGrandma = new JButton(grandma);
		btnGrandma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grandmaCount = CookieFactory.onGrandmaPressed();
				grandmasTextField.setText("G: "+ grandmaCount);
				grandmaPrice = CookieFactory.getGrandmaPrice();
				txtGrandmaprice.setText("GP:" + grandmaPrice);
			}
		});
		btnGrandma.setBounds(10, 115, 62, 62);
		contentPane.add(btnGrandma);
		btnGrandma.setToolTipText("One grandma gives you one cookie, every 2 seconds. Price: price = price + grandmaCount * 10, price starting with 10.");
		
		grandmasTextField = new JTextField();
		grandmasTextField.setBounds(10, 188, 62, 20);
		contentPane.add(grandmasTextField);
		grandmasTextField.setColumns(10);
		grandmasTextField.setText("G: "+grandmaCount);
		
		ImageIcon mine = new ImageIcon("resources/mine.png");
		JButton btnMine = new JButton(mine);
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mineCount = CookieFactory.onMinePressed();
				minePrice = CookieFactory.getMinePrice();
				txtMine.setText("M: " + mineCount);
				txtMineprice.setText("MP: " + minePrice);
			}
		});
		btnMine.setBounds(82, 115, 62, 62);
		contentPane.add(btnMine);
		btnMine.setToolTipText("One mine gives you 10 cookies, every 2 seconds. Price: price = price + mineCount * 100, price starting with 100.");
		
		txtMine = new JTextField();
		txtMine.setBounds(82, 188, 62, 20);
		contentPane.add(txtMine);
		txtMine.setColumns(10);
		txtMine.setText("M: " + mineCount);
		
		txtGrandmaprice = new JTextField();
		txtGrandmaprice.setText("grandmaprice");
		txtGrandmaprice.setBounds(10, 219, 62, 20);
		contentPane.add(txtGrandmaprice);
		txtGrandmaprice.setColumns(10);
		txtGrandmaprice.setText("GP:" + grandmaPrice);
		
		txtMineprice = new JTextField();
		txtMineprice.setText("minePrice");
		txtMineprice.setBounds(82, 219, 62, 20);
		contentPane.add(txtMineprice);
		txtMineprice.setColumns(10);
		txtMineprice.setText("MP: " + minePrice);
		
		setLocationRelativeTo(null);
	}
	
	public void updateGui() {
		timer = new javax.swing.Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numbCookies = CookieFactory.getnumbCookies();
				megaCookies = CookieFactory.getmegaCookies();
				cookiesTextField.setText("Cookies: " + numbCookies);
				megaCookiesTextField.setText("MegaCookies: " + megaCookies);
			}
		});
		timer.start();
	}
	
	public void playSound(String soundnamedotwav) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundnamedotwav).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
}
