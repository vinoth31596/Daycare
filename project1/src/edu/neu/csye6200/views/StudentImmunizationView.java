package edu.neu.csye6200.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import org.jdatepicker.impl.JDatePickerImpl;

import edu.neu.csye6200.utils.Constants;
import edu.neu.csye6200.utils.Utils;

public class StudentImmunizationView implements View {

	@Override
	public JPanel initialize() {
		return genStudentImmunizationPage();
	}

	private JPanel genAddImmunizationPage() {
		// 2.1 Teacher Registration Tab
		JPanel addImmunizationPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Student Registration title
		JLabel ImmunizationTitleLabel = new JLabel("ADD/MODIFY IMMUNIZATION", JLabel.CENTER);
		ImmunizationTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		addImmunizationPanel.add(ImmunizationTitleLabel, gbc);

		gbc.insets = new Insets(8, 8, 8, 8);

		// STUDENT ID
		JLabel studentIdLabel = new JLabel("Student Id: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(studentIdLabel, gbc);

		JTextField studentIdTextField = new JTextField();
		studentIdTextField.setColumns(Constants.TEXT_FIELD_WIDTH);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(studentIdTextField, gbc);

		// VACCINE TYPE
		JLabel vaccineTypeLabel = new JLabel("Vaccine Type: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(vaccineTypeLabel, gbc);

		String vaccineTypes[] = { "Hib", "DTap", "Polio", "Hepatitis B", "MMR", "Varicella" };
		JComboBox vaccineTypeComboBox = new JComboBox(vaccineTypes);
		vaccineTypeComboBox.setPreferredSize(Constants.COMBO_BOX_DIM);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(vaccineTypeComboBox, gbc);

		// VACCINE DOSE COUNT
		JLabel vaccineDoseNoLabel = new JLabel("Dose No: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(vaccineDoseNoLabel, gbc);

		String vaccineDoseTypes[] = { "1", "2", "3", "4" };
		JComboBox vaccineDoseComboBox = new JComboBox(vaccineDoseTypes);
		vaccineDoseComboBox.setPreferredSize(Constants.COMBO_BOX_DIM);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(vaccineDoseComboBox, gbc);

		// VACCINE DATE
		JLabel vaccineDateLabel = new JLabel("Date: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		addImmunizationPanel.add(vaccineDateLabel, gbc);

		JDatePickerImpl datePicker = Utils.genJDatePicker();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		addImmunizationPanel.add(datePicker, gbc);

		// Submit button
		JButton vaccineSubmitButton = new JButton("Add/Update");
		vaccineSubmitButton.setPreferredSize(new Dimension(110, 40));
		vaccineSubmitButton.setFont(Constants.BUTTON_FONT);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30, 8, 8, 50);
		addImmunizationPanel.add(vaccineSubmitButton, gbc);

		return addImmunizationPanel;
	}

	private JPanel genViewImmunizationPage() {
		// 2.1 Teacher Registration Tab
		JPanel viewImmunizationPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Immunization Details title
		JLabel ImmunizationDetailsTitleLabel = new JLabel("STUDENT IMMUNIZATION DETAILS", JLabel.CENTER);
		ImmunizationDetailsTitleLabel.setFont(Constants.TITLE_FONT);
		gbc.insets = new Insets(8, 8, 30, 8);
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		viewImmunizationPanel.add(ImmunizationDetailsTitleLabel, gbc);

		// table rows
		String[][] data = { { "23", "Hib", "1", "2021-09-03" }, { "23", "DTap", "1", "2021-09-03" },
				{ "23", "Polio", "1", "2021-09-03" }, { "23", "MMR", "1", "2021-09-03" },
				{ "23", "Varicella", "1", "2021-09-03" }, { "23", "Hepatitis B", "1", "2021-09-03" } };

		// table column names
		String[] columnNames = { "Student ID", "Vaccine Type", "Dose No", "Date" };
		JTable vaccineInfoTable = new JTable(data, columnNames);
		vaccineInfoTable.setEnabled(false);

		// Increase table content font size
		vaccineInfoTable.setFont(Constants.TABLE_CONTENT_FONT);

		// Increase table header font size
		JTableHeader tableHeader = vaccineInfoTable.getTableHeader();
		tableHeader.setFont(Constants.TABLE_HEADER_FONT);

		JScrollPane scrollPane = new JScrollPane(vaccineInfoTable);

		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		viewImmunizationPanel.add(scrollPane, gbc);

		return viewImmunizationPanel;
	}

	private JPanel genStudentImmunizationPage() {
		// 2. Immunization Page
		JPanel ImmunizationPanel = new JPanel(new GridLayout(1, 0));
		JPanel tab2Panel = new JPanel();

//		JTabbedPane RegTabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
//		RegistrationPanel.add(RegTabbedPane, BorderLayout.CENTER);

		// 2.1 Add/Modify Immunization
		JPanel addImmunizationPanel = genAddImmunizationPage();
		ImmunizationPanel.add(addImmunizationPanel);

		// 2.1 View Immunization
		JPanel viewImmunizationPanel = genViewImmunizationPage();
		ImmunizationPanel.add(viewImmunizationPanel);

		return ImmunizationPanel;
	}

}
