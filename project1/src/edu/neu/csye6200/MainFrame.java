package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private JTextField txtEmployeeId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.window);
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().setMinimumSize(new Dimension(1280, 800));
		frame.getContentPane().setMaximumSize(new Dimension(1280, 800));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jubilant Daycare Management Portal");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		lblNewLabel.setBounds(15, 63, 1245, 85);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Page");
		lblNewLabel_1.setForeground(SystemColor.controlShadow);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(594, 139, 88, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.menu);
		panel.setBounds(393, 196, 489, 428);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setForeground(SystemColor.menuText);
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 66, 116, 54);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setForeground(SystemColor.menuText);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(10, 168, 116, 54);
		panel.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = txtEmployeeId.getText();
				String password = passwordField.getText();
				
				if(userName.equals("vinoth") && password.equals("apple")) {
					JOptionPane.showMessageDialog(frame, "Success");
//					
//					FrameTwo ft = new FrameTwo();
//					ft.FrameTwo.setVisible(true);
					
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(frame, "Login credentials are wrong");
				}
				
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setForeground(SystemColor.controlDkShadow);
		btnNewButton.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		btnNewButton.setBounds(180, 331, 128, 54);
		panel.add(btnNewButton);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setForeground(SystemColor.windowBorder);
		txtEmployeeId.setToolTipText("Enter Employee ID");
		//txtEmployeeId.setText("\r\n");
		txtEmployeeId.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		txtEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtEmployeeId.setBounds(180, 67, 299, 54);
		panel.add(txtEmployeeId);
		txtEmployeeId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter password");
		passwordField.setForeground(SystemColor.windowBorder);
		passwordField.setEchoChar('*');
		passwordField.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordField.setBounds(180, 168, 299, 54);
		panel.add(passwordField);
		frame.setMinimumSize(new Dimension(1280, 800));
		frame.setMaximumSize(new Dimension(1280, 800));
		frame.setBounds(100, 100, 763, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
