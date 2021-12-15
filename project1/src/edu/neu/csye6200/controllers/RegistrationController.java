package edu.neu.csye6200.controllers;

import edu.neu.csye6200.models.Student;
import edu.neu.csye6200.utils.Utils;
import edu.neu.csye6200.views.RegistrationView;
import edu.neu.csye6200Backend.DBBasicConnection;

import java.util.Date;

import javax.swing.JOptionPane;

public class RegistrationController implements Controller {
	private Student model;
	private RegistrationView view;

	public RegistrationController(Student model, RegistrationView view) {
		this.model = model;
		this.view = view;
		initView();
		initController();
	}

	// code for setting the actions to be performed when the user interacts to the
	// view.
	@Override
	public void initController() {
		view.getStudentRegSubmitButton().addActionListener(e -> registerStudent());
		view.getTeacherRegSubmitButton().addActionListener(e -> registerTeacher());
	}

	// reset student form fields to empty
	private void resetStudentFields() {
		view.getStudentNameTextField().setText("");
		view.getStudentFatherNameTextField().setText("");
		view.getStudentMotherNameTextField().setText("");
		view.getStudentPhoneTextField().setText("");
		view.getStudentAddressTextField().setText("");
		view.getStudentDatePicker().getJFormattedTextField().setText("");
	}

	// reset teacher form fields to empty
	private void resetTeacherFields() {
		view.getTeacherNameTextField().setText("");
		view.getTeacherMobileTextField().setText("");
		view.getTeacherEmailTextField().setText("");
		view.getTeacherCatagoryTextField().setText("");
	}

	// add teacher details to db
	private void registerTeacher() {
		String name = view.getTeacherNameTextField().getText();
		String mobile = view.getTeacherMobileTextField().getText();
		String email = view.getTeacherEmailTextField().getText();
		String catagory = view.getTeacherCatagoryTextField().getText();

//      TODO FIX dbc.addTeacher AND UNCOMMENT THIS
//		// add data to db
//		DBBasicConnection dbc = Utils.getDbConnector();
//		boolean is_successful = dbc.addTeacher(name, mobile, email, catagory);
//
//		// show appropriate message to the user
//		if (is_successful) {
//			resetTeacherFields();
//			view.showPopupDialog("Teacher has successfully Registered!!", "Success");
//		} else
//			view.showPopupDialog("Failed to register", "Failure");
	}

	// add student details to db
	private void registerStudent() {
		String name = view.getStudentNameTextField().getText();
		String fatherName = view.getStudentFatherNameTextField().getText();
		String motherName = view.getStudentMotherNameTextField().getText();
		String phone = view.getStudentPhoneTextField().getText();
		String address = view.getStudentAddressTextField().getText();
		Date ageDate = (Date) view.getStudentDatePicker().getModel().getValue();
		int ageInMonths = Utils.getAgeInMonths(ageDate);

		// add data to db
		DBBasicConnection dbc = Utils.getDbConnector();
		boolean is_successful = dbc.addStudent(name, ageInMonths, fatherName, motherName, address, phone);

		// show appropriate message to the user
		if (is_successful) {
			resetStudentFields();
			view.showPopupDialog("Student has successfully Registered!!", "Success");
		} else
			view.showPopupDialog("Failed to register", "Failure");
	}
}
