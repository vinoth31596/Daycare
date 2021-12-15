package edu.neu.csye6200.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import edu.neu.csye6200.controllers.RegistrationController;
import edu.neu.csye6200.utils.Constants;
import edu.neu.csye6200.utils.Utils;
import java.awt.event.*;

public class RegistrationView implements View {

	// Student components
	private JTextField studentNameTextField;
	private JDatePickerImpl studentDatePicker;
	private JTextField studentFatherNameTextField;
	private JTextField studentMotherNameTextField;
	private JTextField studentPhoneTextField;
	private JTextArea studentAddressTextField;
	private JButton studentRegSubmitButton;

	// Teacher components
	private JTextField teacherNameTextField;
	private JTextField teacherMobileTextField;
	private JTextField teacherEmailTextField;
	private JTextField teacherCatagoryTextField;
	private JButton teacherRegSubmitButton;

	// Getters & Setters
	public JTextField getStudentNameTextField() {
		return studentNameTextField;
	}

	public void setStudentNameTextField(JTextField studentNameTextField) {
		this.studentNameTextField = studentNameTextField;
	}

	public JDatePickerImpl getStudentDatePicker() {
		return studentDatePicker;
	}

	public void setStudentDatePicker(JDatePickerImpl studentDatePicker) {
		this.studentDatePicker = studentDatePicker;
	}

	public JTextField getStudentFatherNameTextField() {
		return studentFatherNameTextField;
	}

	public void setStudentFatherNameTextField(JTextField studentFatherNameTextField) {
		this.studentFatherNameTextField = studentFatherNameTextField;
	}

	public JTextField getStudentMotherNameTextField() {
		return studentMotherNameTextField;
	}

	public void setStudentMotherNameTextField(JTextField studentMotherNameTextField) {
		this.studentMotherNameTextField = studentMotherNameTextField;
	}

	public JTextField getStudentPhoneTextField() {
		return studentPhoneTextField;
	}

	public void setStudentPhoneTextField(JTextField studentPhoneTextField) {
		this.studentPhoneTextField = studentPhoneTextField;
	}

	public JTextArea getStudentAddressTextField() {
		return studentAddressTextField;
	}

	public void setStudentAddressTextField(JTextArea studentAddressTextField) {
		this.studentAddressTextField = studentAddressTextField;
	}

	public JButton getStudentRegSubmitButton() {
		return studentRegSubmitButton;
	}

	public void setStudentRegSubmitButton(JButton studentRegSubmitButton) {
		this.studentRegSubmitButton = studentRegSubmitButton;
	}

	public JTextField getTeacherNameTextField() {
		return teacherNameTextField;
	}

	public void setTeacherNameTextField(JTextField teacherNameTextField) {
		this.teacherNameTextField = teacherNameTextField;
	}

	public JTextField getTeacherMobileTextField() {
		return teacherMobileTextField;
	}

	public void setTeacherMobileTextField(JTextField teacherMobileTextField) {
		this.teacherMobileTextField = teacherMobileTextField;
	}

	public JTextField getTeacherEmailTextField() {
		return teacherEmailTextField;
	}

	public void setTeacherEmailTextField(JTextField teacherEmailTextField) {
		this.teacherEmailTextField = teacherEmailTextField;
	}

	public JTextField getTeacherCatagoryTextField() {
		return teacherCatagoryTextField;
	}

	public void setTeacherCatagoryTextField(JTextField teacherCatagoryTextField) {
		this.teacherCatagoryTextField = teacherCatagoryTextField;
	}

	public JButton getTeacherRegSubmitButton() {
		return teacherRegSubmitButton;
	}

	public void setTeacherRegSubmitButton(JButton teacherRegSubmitButton) {
		this.teacherRegSubmitButton = teacherRegSubmitButton;
	}

	public void showPopupDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
	}

	// Initialize the page
	@Override
	public JPanel initialize() {
		return genRegistrationPage();
	}

	// Generate Student Registration page
	private JPanel genStudentRegPage() {
		// 1.1 Student Registration Tab
		JPanel studentRegPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Student Registration title
		JLabel studentTitleLabel = new JLabel("STUDENT REGISTRATION", JLabel.CENTER);
		studentTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		studentRegPanel.add(studentTitleLabel, gbc);

		gbc.insets = new Insets(8, 8, 8, 8);

		// NAME
		JLabel studentNameLabel = new JLabel("Student's Name: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentNameLabel, gbc);

		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentNameTextField, gbc);

		// AGE
		JLabel studentAgeLabel = new JLabel("DOB: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentAgeLabel, gbc);

		studentDatePicker = Utils.genJDatePicker();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentDatePicker, gbc);

		// FATHER'S NAME
		JLabel studentFatherNameLabel = new JLabel("Father's Name: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentFatherNameLabel, gbc);

		studentFatherNameTextField = new JTextField();
		studentFatherNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentFatherNameTextField, gbc);

		// MOTHER'S NAME
		JLabel studentMotherNameLabel = new JLabel("Mother's Name: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentMotherNameLabel, gbc);

		studentMotherNameTextField = new JTextField();
		studentMotherNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentMotherNameTextField, gbc);

		// PHONE NUMBER
		JLabel studentPhoneLabel = new JLabel("Phone Number: ");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentPhoneLabel, gbc);

		studentPhoneTextField = new JTextField();
		studentPhoneTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentPhoneTextField, gbc);

		// ADDRESS
		JLabel studentAddressLabel = new JLabel("Address: ");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		studentRegPanel.add(studentAddressLabel, gbc);

		studentAddressTextField = new JTextArea(5, 5);
		studentAddressTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		studentRegPanel.add(studentAddressTextField, gbc);

		// Submit button
		studentRegSubmitButton = new JButton("SUBMIT");
		studentRegSubmitButton.setPreferredSize(new Dimension(90, 40));
		studentRegSubmitButton.setFont(Constants.BUTTON_FONT);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30, 8, 8, 50);

		studentRegPanel.add(studentRegSubmitButton, gbc);

		return studentRegPanel;
	}

	// Generate Teacher Registration page
	private JPanel genTeacherRegPage() {
		// 1.2 Teacher Registration Tab
		JPanel teacherRegPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Teacher Registration title
		JLabel teacherTitleLabel = new JLabel("TEACHER REGISTRATION", JLabel.CENTER);
		teacherTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		teacherRegPanel.add(teacherTitleLabel, gbc);

		gbc.insets = new Insets(8, 8, 8, 8);

		// NAME
		JLabel teacherNameLabel = new JLabel("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherNameLabel, gbc);

		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherNameTextField, gbc);

		// CONTACT
		JLabel teacherMobileLabel = new JLabel("Contact: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherMobileLabel, gbc);

		teacherMobileTextField = new JTextField();
		teacherMobileTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherMobileTextField, gbc);

		// EMAIL
		JLabel teacherEmailLabel = new JLabel("Email: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherEmailLabel, gbc);

		teacherEmailTextField = new JTextField();
		teacherEmailTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherEmailTextField, gbc);

		// CATAGORY
		JLabel teacherCatagoryLabel = new JLabel("Catagory: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		teacherRegPanel.add(teacherCatagoryLabel, gbc);

		teacherCatagoryTextField = new JTextField();
		teacherCatagoryTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		teacherRegPanel.add(teacherCatagoryTextField, gbc);

		// Submit button
		teacherRegSubmitButton = new JButton("SUBMIT");
		teacherRegSubmitButton.setPreferredSize(new Dimension(90, 40));
		teacherRegSubmitButton.setFont(Constants.BUTTON_FONT);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30, 8, 8, 8);
		teacherRegPanel.add(teacherRegSubmitButton, gbc);

		return teacherRegPanel;
	}

	// Generate Registration page
	private JPanel genRegistrationPage() {
		// 1. Registration Page
		JPanel RegistrationPanel = new JPanel(new BorderLayout());
		JTabbedPane RegTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		RegistrationPanel.add(RegTabbedPane, BorderLayout.CENTER);

		// 1.1 Student Registration Tab
		JPanel studentRegPanel = genStudentRegPage();
		RegTabbedPane.addTab("Student", null, studentRegPanel, null);

		// 1.2 Teacher Registration Tab
		JPanel teacherRegPanel = genTeacherRegPage();
		RegTabbedPane.addTab("Teacher", null, teacherRegPanel, null);

		return RegistrationPanel;
	}

}
