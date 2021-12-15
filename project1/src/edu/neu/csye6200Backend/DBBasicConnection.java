package edu.neu.csye6200Backend;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBasicConnection {
	private static CreateConnection cnct = new CreateConnection();
	private static Connection a = cnct.makeConnection();
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public int selectTeacherId(int age) {
		int catergory = 0;
		int [] teacherResult = new int[14];
		int [] studentCount = new int[14];
		int teachid = 0;
		try {
			if (age >= 6 && age <=12 ) {
				catergory = 1;
			}
			else if (age >= 13 && age <= 24 ) {
				catergory = 2;
			}
			else if (age >= 25 && age <= 35 ) {
				catergory = 3;
			}
			else if (age >= 36 && age <= 47 ) {
				catergory = 4;
			}
			else if (age >= 48 && age <= 59 ) {
				catergory = 5;
			}
			else if (age >= 60 ) {
				catergory = 6;
			}
			
			Statement statementGetTeachId = a.createStatement();
			ResultSet resultGetTeachId = statementGetTeachId.executeQuery("SELECT * FROM teacher WHERE catergory="+catergory);
			int flag=0; 
			while(resultGetTeachId.next()) {
				int teacherId = resultGetTeachId.getInt("teacherid");
				teacherResult[flag] = teacherId;
				flag = flag + 1;
			}
			for(int i =0; i<teacherResult.length; i++) {
				if(teacherResult[i] != 0) {
					try {
						Statement statementCountStudent = a.createStatement();
						ResultSet resultGetStudentCount = statementCountStudent.executeQuery("SELECT COUNT(studentid) FROM student WHERE teacherid="+teacherResult[0]);
						while(resultGetStudentCount.next()) {
							int count = resultGetStudentCount.getInt("count");
							studentCount[i]=count;
						}
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(teacherResult[i] == 0) {
					studentCount[i]=0;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		for (int k = 0; k < studentCount.length; k++) {
			if(catergory == 1) {
				if(studentCount[k]<4) {
					teachid = teacherResult[k];
					break;
				}
				else {
					continue;
				}
			}
			if(catergory == 2) {
				if(studentCount[k]<5) {
					teachid = teacherResult[k];
					break;
				}
				else {
					continue;
				}
			}if(catergory == 3) {
				if(studentCount[k]<6) {
					teachid = teacherResult[k];
					break;
				}
				else {
					continue;
				}
			}if(catergory == 4) {
				if(studentCount[k]<8) {
					teachid = teacherResult[k];
					break;
				}
				else {
					continue;
				}
			}if(catergory == 5) {
				if(studentCount[k]<12) {
					teachid = teacherResult[k];
					break;
				}
				else {
					continue;
				}
			}if(catergory == 6) {
				if(studentCount[k]<15) {
					teachid = teacherResult[k];
					break;
				}
				else {
					continue;
				}
			}
		}
		return teachid;
	}
	
	public boolean addStudent(String studentName, int age, String fatherName, String motherName, String address, String phone) {
		try {
			Statement statmentAddStudents = a.createStatement();
			statmentAddStudents.executeUpdate("INSERT INTO student(studentname,age,fathername,mothername,address,phone,teacherid) VALUES ('"+studentName+"',"+age+",'"+fatherName+"','"+motherName+"','"+address+"','"+phone+"',"+selectTeacherId(age)+");");
			LOGGER.log(Level.INFO, "New Student Added");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int findSectionId(int catergory) {
		int[] vacantSection = new int[3];
		try {
			Statement findSection = a.createStatement();
			ResultSet isfilled = findSection.executeQuery("select clsid from classroom where catergory="+catergory+"and isfilled=false");
			int vacancyFlag = 0;
			while(isfilled.next()) {
				int stFilled = isfilled.getInt("clsid");
				vacantSection[vacancyFlag] = stFilled;
				vacancyFlag = vacancyFlag + 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return vacantSection[0];
	}
	
	public boolean addTeacher(String teacherName, int credit, int catergory) {
		try {
			Statement statmentAddStudents = a.createStatement();
			statmentAddStudents.executeUpdate("INSERT INTO teacher(name,credit,sectionid,catergory) values ('"+teacherName+"',"+credit+","+findSectionId(catergory)+","+catergory+")");
			LOGGER.log(Level.INFO, "New Teacher Added");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<List<String>> showStudentsList() {
		List<List<String>> StudentRoster = new ArrayList<>();
		try {
			Statement statmentShowStudentList = a.createStatement();
			ResultSet resultStdAll = statmentShowStudentList.executeQuery("SELECT s.studentname,s.age,s.fathername,s.mothername,s.address,s.phone,t.teachername,s.doj FROM teacher t INNER JOIN student s ON t.teacherid = s.teacherid");
			while (resultStdAll.next()) {
			    String stdName = resultStdAll.getString("studentname");
			    String age = String.valueOf(resultStdAll.getInt("age"));
			    String fatherName = resultStdAll.getString("fathername");
			    String motherName = resultStdAll.getString("mothername");
			    String address = resultStdAll.getString("address");
			    String phone = resultStdAll.getString("phone");
			    String teacherName = resultStdAll.getString("teachername");
			    List<String> temps = new ArrayList<>();
			    temps.add(stdName);
			    temps.add(age);
			    temps.add(fatherName);
			    temps.add(motherName);
			    temps.add(address);
			    temps.add(phone);
			    temps.add(teacherName);
			    StudentRoster.add(temps);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return StudentRoster;
	}
	
	public List<List<String>> showTeachersList() {
		List<List<String>> teacherList = new ArrayList<>();
		try {
			Statement statmentShowTeacherList = a.createStatement();
			ResultSet resultTeachAll = statmentShowTeacherList.executeQuery("SELECT t.teachername, t.credit, c.classname, t.catergory FROM teacher t INNER JOIN classroom c on t.sectionid = c.clsid");
			while (resultTeachAll.next()) {
			    String teachName = resultTeachAll.getString("teachername");
			    String credit = String.valueOf(resultTeachAll.getInt("credit"));
			    String sectionId = resultTeachAll.getString("classname");
			    String catergory = String.valueOf(resultTeachAll.getInt("catergory"));
			    List temps = new ArrayList<String>();
			    temps.add(teachName);
			    temps.add(credit);
			    temps.add(sectionId);
			    temps.add(catergory);
			    teacherList.add(temps); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return teacherList;
	}
//	Function returns Student Vaccination details based on Student Id
	public List<List<String>> getVaccinationDetails(int studentId) {
		List<List<String>> vaccinationDetails = new ArrayList<>();
		String[] tempStorage = new String[4];
		try {
			Statement statementVD = a.createStatement();
			ResultSet resultvdStudent = statementVD.executeQuery("SELECT v.vaccinationname, v.doseno, v.datetaken, t.studentname from immunizations v inner join student t on v.studentid = t.studentid where v.studentid="+studentId+";");
			while(resultvdStudent.next()) {
				String vaccinationname = resultvdStudent.getString("vaccinationname");
				String doseno = String.valueOf(resultvdStudent.getInt("doseno"));
				String dateTaken = String.valueOf(resultvdStudent.getDate("datetaken"));
				String studentName = resultvdStudent.getString("studentname");
				List temps = new ArrayList<String>();
				temps.add(vaccinationname);
				temps.add(doseno);
				temps.add(dateTaken);
				temps.add(studentName);
				vaccinationDetails.add(temps);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return vaccinationDetails;
	}
	
	public List<String> showTeacherAlertsAnnualReview() {
		List<String> teacherListAnnualRev = new ArrayList<>();
		try {
		Statement showTeacherAR = a.createStatement();
		ResultSet resultAnRev =showTeacherAR.executeQuery("select teachername from teacher where doj>=current_date-357");
		int flag = 0;
		while(resultAnRev.next()) {
			String teacherARname = resultAnRev.getString("teachername");
			teacherListAnnualRev.add(flag, teacherARname);
			flag = flag + 1;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return teacherListAnnualRev;
	}
	
	public List<String> showStudentAlertsRegistration() {
		List<String> studentsRenewalList = new ArrayList<>();
		try {
		Statement showStudentRegistrationRenewal = a.createStatement();
		ResultSet resultStudentRenewal =showStudentRegistrationRenewal.executeQuery("select studentname from student where doj=current_date-355");
		int flag = 0;
		while(resultStudentRenewal.next()) {
			String studentRenewal = resultStudentRenewal.getString("studentname");
			studentsRenewalList.add(flag, studentRenewal);
			flag = flag + 1;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return studentsRenewalList;
	}
	public void showStudentAlertsVaccination() {
		List<List<String>> studentsVaccAlerts = new ArrayList<>();
		try {
		Statement vaccAlerts = a.createStatement();
		ResultSet resultSetVaccAlerts = vaccAlerts.executeQuery("select s.studentname, i.vaccinationname, i.doseno+1 from immunizations i inner join student s on i.studentid = s.studentid where i.datetaken>=current_date-3 or i.datetaken<=current_date+3");
		int flag = 0;
		while(resultSetVaccAlerts.next()) {
			String studentName = resultSetVaccAlerts.getString("studentname");
//			String vacciNa
		}
		}
		catch(Exception e) {
			
		}
	}
	
	public static void Demo() throws SQLException {
		System.out.println("----- Database connection class ------");
			DBBasicConnection dbc = new DBBasicConnection();
//			dbc.getVaccinationDetails(3);
			// returns ArrayList of students
//			List<String[]> abcd = dbc.showStudentsList();
//			// returns ArrayList of teachers 
//			List<String[]> defg = dbc.showTeachersList();
			// returns list of vaccine based on studentid
//			List<String[]> kiju = dbc.getvaccDetailsOfStudent(3);
//			dbc.addStudent("Ashwin", 3, "Bazz", "ash", "190 highland street", "1434567890", 1);
//			dbc.addTeacher("Ashwin", 8, 1, 2);
//			dbc.showStudentsList();
//			dbc.showTeachersList();
//			System.out.println(abcd.get(0).toString());
			
//			for (String[] a : abcd) {
//				System.out.println(Arrays.toString(a));
//			}
//			for (String[] b : defg) {
//				System.out.println(Arrays.toString(b));
//			}
//			System.out.println(Arrays.toString(defg.get(0)));
//			List<String[]> lkm = dbc.getVaccinationDetails(3);
//			System.out.println(Arrays.toString(lkm.get(0)));
//			System.out.println(Arrays.toString(lkm.get(1)));
//			for (String[] k : lkm) {
//				System.out.println(Arrays.toString(k));
//			}
//			int v = kiju.size();
//			for(int i = 0; i < v; i++) {
//				System.out.println(Arrays.toString(kiju.get(i)));
//			}
//			List<String[]> pop = dbc.getvaccDetailsOfStudent(3);
//			System.out.println(Arrays.toString(pop.get(0)));
//			System.out.println(Arrays.toString(pop.get(1)));
//			dbc.getVaccinationDetails(3);
//			dbc.selectTeacherId(15);
//			dbc.addStudent("AshwinN", 8, "Ashwin", "Balaji", "192 Highland street", "1234567890");
//			for (String[] a : kiju) {
//				System.out.println(Arrays.toString(a));
//			}
//			List<List<String>> mm = dbc.getvaccDetailsOfStudent(3);
//			for (List<String> list : mm) {
//				System.out.println(list.toString());
//			}
//			List<String> j = dbc.showTeacherAlertsAnnualReview();
//			for (String pop : j) {
//				System.out.println(j);
//			}
			a.close();
	}
}
