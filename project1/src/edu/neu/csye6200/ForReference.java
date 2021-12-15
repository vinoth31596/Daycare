package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ForReference {

	private JFrame frame;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForReference window = new ForReference();
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
	public ForReference() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Frame
		frame = new JFrame("Sample Title Here");
//		frame.getContentPane().setLayout(new BorderLayout());
//		frame.getContentPane().setLayout(new FlowLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.red);
//		((JComponent) frame).setBorder(new EmptyBorder(5, 5, 5, 5));
//		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

//	    frame.add(new JLabel("North", JLabel.CENTER), BorderLayout.NORTH);

		// FIRST NAME
		JLabel label1 = new JLabel("Label 1");
		label1.setOpaque(true);
		label1.setBackground(Color.ORANGE);
		frame.add(label1, BorderLayout.NORTH);

		JLabel label2 = new JLabel("Label 2");
		label2.setOpaque(true);
		label2.setBackground(Color.red);
		frame.add(label2, BorderLayout.SOUTH);

		JLabel label3 = new JLabel("Label 3");
		label3.setOpaque(true);
		label3.setBackground(Color.blue);
		frame.add(label3, BorderLayout.EAST);

		JLabel label4 = new JLabel("Label 4");
		label4.setOpaque(true);
		label4.setBackground(Color.cyan);
		frame.add(label4, BorderLayout.WEST);

		JPanel LoginPanel = new JPanel();
		LoginPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		LoginPanel.setBackground(Color.yellow);

//		// Panel
//		JPanel LoginPanel = new JPanel();
//		LoginPanel.setBackground(Color.red);
//		LoginPanel.setLayout(new GridLayout(2,2));

		JLabel userNameLabel = new JLabel("User Name: ");
		userNameLabel.setOpaque(true);
		userNameLabel.setBackground(Color.green);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.anchor = GridBagConstraints.EAST;
		LoginPanel.add(userNameLabel, gbc);

		JTextField userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		userNameTextField.setOpaque(true);
		userNameTextField.setBackground(Color.magenta);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		LoginPanel.add(userNameTextField, gbc);

		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setOpaque(true);
		passwordLabel.setBackground(Color.lightGray);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		LoginPanel.add(passwordLabel, gbc);

		JTextField passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setOpaque(true);
		passwordTextField.setBackground(Color.pink);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		LoginPanel.add(passwordTextField, gbc);

//		centerPanel.add(LoginPanel, new GridBagConstraints());
		frame.add(LoginPanel);

		// frame.getContentPane().add(panel, BorderLayout.CENTER);

//
//		firstNameTextField = new JTextField();
//		firstNameTextField.setColumns(10);
//		frame.add(firstNameTextField, BorderLayout.CENTER);

		// // Last Name
//		lastNameLabel = new JLabel("Last Name: ");
//		frame.getContentPane().add(lastNameLabel);
//
//		lastNameTextField = new JTextField();
//		lastNameTextField.setColumns(10);
//		frame.getContentPane().add(lastNameTextField);
//
//		// Submit Button
//		JButton submitButton = new JButton("SUBMIT");
//		frame.getContentPane().add(submitButton);
//
//		// Dynamic button
//		JButton btnNewButton1 = new JButton("Dynamic Button");
//		frame.getContentPane().add(btnNewButton1);
//		btnNewButton1.setVisible(false);

//		JPanel panel = new JPanel();
////		panel.setBackground(Color.ORANGE);
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//
//		panel.add(new JButton("panel_button_1"));
//		panel.add(new JButton("panel_button_2"));
//		frame.add(panel, BorderLayout.SOUTH);

//		frame.pack();
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);

//		submitButton.addActionListener(new java.awt.event.ActionListener() {
//			@Override
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				if (btnNewButton1.isVisible())
//					btnNewButton1.setVisible(false);
//				else
//					btnNewButton1.setVisible(true);
////				JOptionPane.showMessageDialog(null,
////						"Hi " + firstNameTextField.getText() + " " + lastNameTextField.getText(), "Message Dialog",
////						JOptionPane.PLAIN_MESSAGE);
//			}
//		});
	}
}
