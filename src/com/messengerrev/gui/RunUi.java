package com.messengerrev.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;

import com.messengerrev.data.DataUser;

import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

public class RunUi extends JFrame {

	private JPanel contentPane;
	private JPanel panelLogIn;
	private JLabel lblPassword;
	private JTextField tF_username;
	private JPasswordField pF_password;
	private JPanel panelHome;
	private JTextField tFCari;
	private JLabel lblUsername;
	private JButton btnSearch;
	private JPanel panelHeader;
	private JLabel lblCari;
	private JPanel panelPesan;
	private JPanel panelKontak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunUi frame = new RunUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RunUi() {
		setTitle("MessengerApps");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 737);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
//		panelHome LogIn
		panelLogIn = new JPanel();
		contentPane.add(panelLogIn, "logIn");
		panelLogIn.setLayout(null);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsername.setBounds(62, 238, 90, 24);
		panelLogIn.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(62, 316, 90, 24);
		panelLogIn.add(lblPassword);
		
		tF_username = new JTextField();
		tF_username.setBounds(167, 238, 253, 26);
		panelLogIn.add(tF_username);
		tF_username.setColumns(10);
		
		pF_password = new JPasswordField();
		pF_password.setBounds(167, 314, 253, 26);
		panelLogIn.add(pF_password);		
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataUser mUser = new DataUser();
				
				if (tF_username.getText().equals(mUser.getUsername()) && String.valueOf(pF_password.getPassword()).equals(mUser.getPassword()) ) {
					contentPane.removeAll();
					contentPane.repaint();
					contentPane.revalidate();
					
					contentPane.add(panelHome);
					contentPane.repaint();
					contentPane.revalidate();
				} else {
					JOptionPane.showMessageDialog(contentPane,"Data yang anda masukan salah!");
				}
			}
		});
		btnLogin.setBounds(167, 398, 115, 29);
		panelLogIn.add(btnLogin);
		
		
		
		
		

		
//		Panel Home
		panelHome = new JPanel();
		panelHome.setBackground(new Color(100, 149, 237));
		contentPane.add(panelHome);
		
		panelHeader = new JPanel();
		panelHeader.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panelHeader.setBackground(new Color(0, 0, 128));
		panelHeader.setLayout(null);
		
		lblCari = new JLabel("Cari");
		lblCari.setForeground(Color.WHITE);
		lblCari.setBackground(Color.WHITE);
		lblCari.setBounds(34, 16, 37, 24);
		lblCari.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panelHeader.add(lblCari);
		
		tFCari = new JTextField();
		tFCari.setBounds(106, 13, 280, 34);
		panelHeader.add(tFCari);
		tFCari.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(398, 12, 112, 37);
		panelHeader.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JTabbedPane tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panelHome = new GroupLayout(panelHome);
		gl_panelHome.setHorizontalGroup(
			gl_panelHome.createParallelGroup(Alignment.LEADING)
				.addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
				.addComponent(tabbedPaneMain, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
		);
		gl_panelHome.setVerticalGroup(
			gl_panelHome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHome.createSequentialGroup()
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPaneMain, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
		);
		
		panelPesan = new JPanel();
		tabbedPaneMain.addTab("PESAN", null, panelPesan, null);
		
		panelKontak = new JPanel();
		panelKontak.setBackground(Color.MAGENTA);
		tabbedPaneMain.addTab("KONTAK", null, panelKontak, null);
		panelHome.setLayout(gl_panelHome);
		
		
		
		
		
		
		
		
	}
}
