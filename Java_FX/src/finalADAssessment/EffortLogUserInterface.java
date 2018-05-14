package finalADAssessment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*******
 * <p> Title: EffortLogger User Interface Class. </p>
 * 
 * <p> Description: Effort Log Entry Screen </p>
 * 
 * <p> Copyright: Rajeev Gupta © 2018 </p>
 * 
 * @author Rajeev Gupta & Garvit Kumar
 * 
 * @version 1.00	28-04-2018 The mainline of a JavaFX-based GUI implementation of an Effort Logger Analysis
 * 
 */




public class EffortLogUserInterface {
	
	
	
	/* Constants used to parameterize the graphical user interface.  We do not use a layout manager for
	   this application. Rather we manually control the location of each graphical element for exact
	   control of the look and feel. */
	
	public final static double WINDOW_WIDTH = 500;
	public final static double WINDOW_HEIGHT = 600;
	
	/*********************************************************************
	             Attributes
	*********************************************************************/
	
	/***********************************************************************************
	 These are the application Label UI controls for Header Message, Name of faculty,
	 Staff Id, Course,Day, Week No, Hours spend, Activity, Graded What, Deliverable Type, 
	 No. of files graded and size, required by the user interface	
	***********************************************************************************/
	Label lblHead = new Label();                 
	Label lblFaculty = new Label();              
	Label lblStaffId = new Label();              
	Label lblCourse = new Label();               
	Label lblDay = new Label();
	Label lblWeekNo = new Label();
	Label lblHours = new Label();
	Label lblActivity = new Label();
	Label lblGradedWhat = new Label();
	Label lblDeliverableType = new Label();
	Label lblNoOfFile = new Label();
	Label lblSize = new Label();
	TextField txtFaculty = new TextField();
	TextField StaffID = new TextField ();
	TextField WeekNo = new TextField();
	TextField NoFiles = new TextField();
	TextField Size = new TextField();
	ComboBox<String> myComboBox = new ComboBox<String>(); 
	ComboBox<String> myComboBox1 = new ComboBox<String>();  
	ComboBox<String> myComboBox2 = new ComboBox<String>();    // defining various Combo Boxes.
	ComboBox<String> myComboBox3 = new ComboBox<String>(); 
	ComboBox<String> myComboBox4 = new ComboBox<String>(); 
	/***********************************************************************************
	* These are the application ComboBox UI controls for Course Name, Hours spend, Activity 
	* done, Graded What and Deliverable Type, required by the user interface	
	***********************************************************************************/
	
	    DatePicker datePicker = new DatePicker();
	    
	    FileInputStream input = new FileInputStream("mmu.jpg");// Image Insertion
	    Image img = new Image(input);
	    
	        
	DropShadow ds = new DropShadow();      // DropShadow object ds to set the background shadow of various control
	Button Backbutton = new Button("Back");
	Button SubmitButton = new Button("Save Record");
	/*********
	 * This constructor initializes all of the elements of the graphical user interface. These assignments
	 * determine the location, size, font, color, and change and event handlers for each GUI object.
	 */
	
	public EffortLogUserInterface(Pane theRoot) throws Exception  {
	
         		
		ImageView imView = new ImageView(img);
		
		imView.setLayoutX(0);       imView.setLayoutY(0);
		imView.setFitHeight(100);    imView.setFitWidth(90);// replace this comment with the code to set an image (mmu.jpg) as logo on specific position
			
		
		/*********************************************************************
		* This code is used to define the Offset value and Color for Shadow
		**********************************************************************/
		
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		
		setupLabelUI(lblHead,"Effort Log Form", "Arial", 22, WINDOW_WIDTH/2-50, 20);
		lblHead.setEffect(ds);
		setupLabelUI(lblDay,"Day", "Arial", 16, 50, 180);
		datePicker.setValue(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		lblDay.setEffect(ds);
		
		txtFaculty.setText("Dr. Rajeev Gupta");
		txtFaculty.setMouseTransparent(true);
		StaffID.setText("150012");
		StaffID.setMouseTransparent(true);
		
		setupLabelUI(lblWeekNo,"Week No.", "Arial", 16, 50, 230); // label layout for week number
		lblWeekNo.setEffect(ds);
		
		setupLabelUI(lblCourse,"Course", "Arial", 16, 50, 140); // label layout for course
		lblCourse.setEffect(ds); 
		
		setupLabelUI(lblHours,"Hours", "Arial", 16, 50, 280); // label layout for hours spend
		lblHours.setEffect(ds);
		
		setupLabelUI(lblActivity,"Activity", "Arial", 16, 50, 340); // label layout for Activity
		lblActivity.setEffect(ds);
		
		setupLabelUI(lblGradedWhat,"Graded What?", "Arial", 16, 50, 390); // label layout for Graded what 
		lblGradedWhat.setEffect(ds);
		
		setupLabelUI(lblDeliverableType,"Deliverable type", "Arial", 16, 50, 440); // label layout for deliverable type
		lblDeliverableType.setEffect(ds);
		
		setupLabelUI(lblFaculty,"Name of faculty", "Arial", 16, 50, 100); // label layout for faculty
		lblFaculty.setEffect(ds);
		
		setupTextUI(txtFaculty, "Arial", 16, 180, 200,100, true); // text UI for faculty
		
		setupLabelUI(lblStaffId,"Staff ID", "Arial", 16, 390, 100); // label layout for Staff ID
		lblStaffId.setEffect(ds);
		
		setupTextUI(StaffID, "Arial", 16, 180, 450,100, true); // text UI for staff ID
		
		setupTextUI(WeekNo, "Arial", 16, 180, 250,230, true); // text UI for week number
		
		setupLabelUI(lblNoOfFile,"How many Deliv Files?", "Arial", 16, 50, 480); // label layout for No. of files
		lblNoOfFile.setEffect(ds);
		
		setupLabelUI(lblSize,"Size", "Arial", 16, 50, 520); // label layout for Size
		lblSize.setEffect(ds);
		
		setupTextUI(NoFiles, "Arial", 16, 180, 250, 480, true); // text UI for No. of files
		
		setupTextUI(Size, "Arial", 16, 180, 250, 520, true); // text UI for week number
		
		datePicker.setLayoutX(250); // layout for date picker
		datePicker.setLayoutY(180);	
		
		setupButtonUI(Backbutton, "Arial", 18,470,575);          // back button layout
		Backbutton.setEffect(ds);
		Backbutton.setOnAction((event) -> { backAction(); });
		
		setupButtonUI(SubmitButton, "Arial", 18,160,570);          // Submit button layout
		SubmitButton.setEffect(ds);
		SubmitButton.setOnAction((event) -> {String nameOfFaculty = txtFaculty.getText().toString();
		String staffId = StaffID.getText().toString();
		String weekNo = WeekNo.getText().toString();
		String noOfFiles = NoFiles.getText().toString();
		String size = Size.getText().toString();
		String courseName = myComboBox.getValue().toString();
		String hoursSpend = myComboBox1.getValue().toString();
		String deliverableType = myComboBox2.getValue().toString();
		String gradedWhat = myComboBox3.getValue().toString();
		String activityDone = myComboBox4.getValue().toString();
		String date = datePicker.getValue().toString();



		XSSFWorkbook wb = new XSSFWorkbook();

		// Create a Blank Sheet
		XSSFSheet spreadsheet = wb.createSheet("Employee Info");

		// Create row object
		XSSFRow row;

		// This data needs to be written (Object[])
		TreeMap<String,Object[]>empinfo = new TreeMap <String, Object[] > ();

		empinfo.put("1",  new Object[] {nameOfFaculty });
		empinfo.put("2", new Object[] {staffId});
		empinfo.put("3", new Object[] {weekNo});
	    empinfo.put("4",  new Object[] {size });
	    empinfo.put("5",  new Object[] {noOfFiles });
	    empinfo.put("6",  new Object[] {courseName });
	    empinfo.put("7",  new Object[] {hoursSpend});
	    empinfo.put("8",  new Object[] {deliverableType });
	    empinfo.put("9",  new Object[] {gradedWhat });
	    empinfo.put("10",  new Object[] {activityDone });
	    empinfo.put("11",  new Object[] {date });
	    // Iterating over data and sheet creation
	    Set <String> keyid = empinfo.keySet();
	    int rowid= 0;

	    for (String key: keyid)
	    {
	    	row = spreadsheet.createRow(rowid++);
	    	Object [] obj = empinfo.get(key);
	    	int cellid= 0;

	    	for(Object ob : obj)
	    	{
	    		XSSFCell cell = row.createCell(cellid++);   // row cell ID
	    		cell.setCellValue((String)ob);
	    	}
	    }

	    // Write the workbook in the file system
	    FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File("facultyeffort.xlsx"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			wb.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	    try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Faculty Effort Log created successfully"); });
		
	
		
		                   // combo box for course
	    myComboBox.getItems().addAll( "Comm-II","Calculus II", "App Dev","Physics II","SWT&T");
	    myComboBox.setEditable(true);        
	    myComboBox.setLayoutX(250); myComboBox.setLayoutY(140);        // layout for combo box
		
	                       // combo box for hours 
	    myComboBox1.getItems().addAll("0.5","1","1.5","2","2.5","3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9");
	    myComboBox1.setEditable(true);        
	    myComboBox1.setLayoutX(250); myComboBox1.setLayoutY(280);        // layout for combo box
		
	                          // combo box for activity done
	    myComboBox2.getItems().addAll( "Classroom Instruction", "Student Advising", "Supervised Study Hall", "Assessments & Grading", "Labs","Professional Development", "QA Reviews","General", "Contributions to the Discipline", "Sick", "Vacation", "Community Service", "Program Updates", "Marketing", "General", "Holiday");
	    myComboBox2.setEditable(true);        
	    myComboBox2.setLayoutX(250); myComboBox2.setLayoutY(340);        
		
	                          // combo box for graded what
	    myComboBox3.getItems().addAll( "No Grading", "ENB","ANB","PNB","Tests","Student effort log", "Project 1", "Project 2", "Project 3" , "Project 4", "Project 5", "Project 6", "Project 7", "Project 8", "Project 9", "Project 10");
	    myComboBox3.setEditable(true);        
	    myComboBox3.setLayoutX(250); myComboBox3.setLayoutY(390);
	    
	                          // combo box for deliverable type
	    myComboBox4.getItems().addAll("Document/presentation","Screencast","Spreadsheet","Code", "No grading");
	    myComboBox4.setEditable(true);        
	    myComboBox4.setLayoutX(250); myComboBox4.setLayoutY(440);
		
		/************************************************************************
		
		setupLabelUI(lblDay,"Day", "Arial", 16, 50, 180);
		datePicker.setLayoutX(250); datePicker.setLayoutY(180);
		datePicker.setValue(LocalDate.parse(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		
		*************************************************************************/
		
			
		// Place all of the just-initialized GUI elements into the pane
		theRoot.getChildren().addAll(lblHead, datePicker,lblDay, imView, myComboBox, myComboBox1, myComboBox2,Size, SubmitButton, lblSize, lblNoOfFile, NoFiles, WeekNo, lblWeekNo, myComboBox3, myComboBox4, lblStaffId, StaffID, txtFaculty, lblFaculty, lblCourse, lblHours, lblActivity, Backbutton, lblGradedWhat, lblDeliverableType);
}
	
	
	 /**********
      * Private local method to initialize the standard fields for a label
	  */
		private void setupLabelUI(Label l,String n, String ff, double f, double x, double y){
			l.setText(n);
			l.setFont(Font.font(ff, f));
			l.setLayoutX(x);
			l.setLayoutY(y);		
		}
		
		/**********
		 * Private local method to initialize the standard fields for a text field / password field
		 */
		private void setupTextUI(TextField t, String ff, double f, double w, double x, double y, boolean e){
			t.setFont(Font.font(ff, f));
			t.setMinWidth(w);
			t.setMaxWidth(w);
			t.setLayoutX(x);
			t.setLayoutY(y);		
			t.setEditable(e);
		}
	
		
		/**********
		 * Private local method to initialize the standard fields for a button field
		 */
		private void setupButtonUI(Button t, String ff, double f, double x, double y){
			t.setFont(Font.font(ff, f));
			t.setLayoutX(x);
			t.setLayoutY(y);		
		}
	
		/**********
		 * The following method is method stubs that need to be implemented.
		 * 
		 * @return
		 */
		
		public void backAction() {
			// replace this comment with the code to switch pointer back to Login Screen
		}
		
				
		/**********
		 * The following method is method stubs that need to be implemented.
		 * 
		 * @return
		 */
		public void saveRecordAction() {
		
			// done in the save record/ submit action
		
	    }
		
		
			
}        