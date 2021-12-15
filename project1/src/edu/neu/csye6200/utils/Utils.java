package edu.neu.csye6200.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import edu.neu.csye6200Backend.DBBasicConnection;

public final class Utils {
	public static DBBasicConnection dbc;

	public static JDatePickerImpl genJDatePicker() {
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.day", "Day");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new AbstractFormatter() {

			@Override
			public Object stringToValue(String text) throws ParseException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
					String strDate = format.format(cal.getTime());
					return strDate;
				}
				return "";
			}

		});

		return datePicker;
	}

	// get the age in months
	public static int getAgeInMonths(Date date) {
		LocalDate today = LocalDate.now();
		LocalDate bday = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period = Period.between(bday, today);
		return period.getMonths();
	}

	public static DBBasicConnection getDbConnector() {
		if (dbc == null)
			dbc = new DBBasicConnection();

		return dbc;
	}
}
