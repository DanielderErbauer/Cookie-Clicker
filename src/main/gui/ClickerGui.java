package main.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.utils.CookieFactory;
import main.utils.DataLoader;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClickerGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField;
	private JButton btnCookieGen;
	public int numbCookies;
	public int megaCookies;
	public javax.swing.Timer timer;
	private JButton btnShutdown;
	private JButton btnSave;
	private JButton btnCcx;
	private JButton btnRandomcookies;
	public JTextField megaCookiesTextField;

	public ClickerGui() throws IOException {
		megaCookies = DataLoader.load("save/megaCookies.txt", 0);
		numbCookies = DataLoader.load("save/numbCookies.txt", 0);
		this.setTitle("Cookie Clicker in Java");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		textField = new JTextField();
		textField.setBounds(10, 11, 261, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Cookies: " + numbCookies);

		ImageIcon cookie = new ImageIcon("resources/cookie.png");
		btnCookieGen = new JButton(cookie);
		btnCookieGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CookieFactory.onCookiePressed();
				numbCookies = CookieFactory.getnumbCookies();
				megaCookies = CookieFactory.getmegaCookies();
				textField.setText("Cookies: " + numbCookies);
				megaCookiesTextField.setText("MegaCookies: " + megaCookies);
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
				textField.setText("Cookies: " + numbCookies);
			}
		});
		btnCcx.setBounds(82, 42, 62, 62);
		contentPane.add(btnCcx);
		btnCcx.setToolTipText("Doubles your Cookies generated on click.");

		ImageIcon randomEvent = new ImageIcon("resources/randomEvent.png");
		btnRandomcookies = new JButton(randomEvent);
		btnRandomcookies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbCookies = CookieFactory.randomEvent();
				textField.setText("Cookies: " + numbCookies);
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
				numbCookies = CookieFactory.onGrandmaPressed();
				textField.setText("Cookies: " + numbCookies);
			}
		});
		btnGrandma.setBounds(226, 42, 62, 62);
		contentPane.add(btnGrandma);
		
		setLocationRelativeTo(null);
	}
}
