package finalADAssessment;

import java.io.FileInputStream;


import finalADAssessment.EffortLogUserInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/*******
 * <p> Title: EffortLogger LoginForm Class. </p>
 * 
 * <p> Description: Login Form for authentication </p>
 * 
 * <p> Copyright: Rajeev Gupta © 2018 </p>
 * 
 * @author Rajeev Gupta & Garvit Kumar
 * 
 * @version 1.00	27-04-2018 The mainline of a JavaFX-based GUI implementation of an Effort Logger Analysis
 * 
 */
public class LoginForm extends Application{
	
	public EffortLogUserInterface theGUI;
	/* Constants used to parameterize the graphical user interface.  We do not use a layout manager for
	   this application. Rather we manually control the location of each graphical element for exact
	   control of the look and feel. */
	
	public final static double WINDOW_WIDTH = 400;
	public final static double WINDOW_HEIGHT = 300;
	
	/*********************************************************************
	             Attributes
	*********************************************************************/
		
	TextField txtUserId = new TextField();
	PasswordField txtPass = new PasswordField();
	Label lblMessage = new Label();
	DropShadow ds = new DropShadow();
		
	/**********
	 * This method initializes all of the elements of the graphical user interface. These assignments
	 * determine the location, size, font, color, and change and event handlers for each GUI object.
	 */
	public void UInterface(Pane theRoot) throws Exception
	{	
         	
		Label lblHead = new Label();
		Label lblUserId = new Label();
		Label lblPass = new Label();
		
		Image img = new Image(new FileInputStream("mmu.jpg"));
		ImageView imView = new ImageView(img);
		
		imView.setLayoutX(0);       imView.setLayoutY(0);
		imView.setFitHeight(100);    imView.setFitWidth(90);
		
			
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		
		Button btnSubmit = new Button("Submit");
		Button btnExit = new Button("Cancel");
		
		setupLabelUI(lblHead,"Login Form", "Arial", 24, WINDOW_WIDTH/2-50, 20);
		setupLabelUI(lblUserId,"User Id", "Arial", 18, 50, 100);
		setupLabelUI(lblPass,"Password", "Arial", 18, 50, 150);
		lblHead.setEffect(ds);
		
		setupTextUI(txtUserId, "Arial", 18, 100,200,100,true);
		setupTextUI(txtPass, "Arial", 18, 100,200,150,true);
		
		// Establish the "Submit" button, position it, and link it to methods to accomplish its work
		setupButtonUI(btnSubmit, "Arial", 18,100,200);
		btnSubmit.setEffect(ds);
		btnSubmit.setOnAction((event) -> { submitAction(); });
		
		// Establish the "Exit" button, position it, and link it to methods to accomplish its work
		setupButtonUI(btnExit, "Arial", 18,200,200);
		btnExit.setEffect(ds);
		btnExit.setOnAction((event) -> { exitAction(); });
		
		setupLabelUI(lblMessage,"", "Arial", 22, 70, 250);
		lblMessage.setEffect(ds);
		
		// Place all of the just-initialized GUI elements into the pane
		theRoot.getChildren().addAll(imView,lblHead, lblUserId,lblPass,txtUserId,txtPass,
                btnSubmit,btnExit,lblMessage);
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
		 * Public local method to set the action of exit from the system
		 */
		public void exitAction() {
			System.exit(1);
		}
		
				
		/**********
		 * The following method is method stubs that need to be implemented.
		 * 
		 * @return
		 */
		public void submitAction() {
		
		String checkUser = txtUserId.getText().toString();
		String  checkPw = txtPass.getText().toString();
		
		if(checkUser.equals("rajeev") && checkPw.equals("123")){
		      lblMessage.setText("Congratulations!");
		      lblMessage.setTextFill(Color.GREEN);
		      
		      Stage theStage = new Stage();
		      theStage.setTitle("Effort Log Form");				// Label the stage (a window)
				
			  Pane theRoot = new Pane();							// Create a pane within the window
				
	
			try {
				theGUI = new EffortLogUserInterface(theRoot);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// Create the Graphical User Interface
				
			  Scene theScene = new Scene(theRoot, 600, 600);	// Create the scene
				
			  theStage.setScene(theScene);							// Set the scene on the stage
			
			  theStage.show();		
		        
		}
		else{
		    lblMessage.setText("Invalid User Id  or Password.");
		    lblMessage.setTextFill(Color.RED);
		    }
		
	    }
		
		
		/**********
		 * This is the start method that is called once the application has been loaded into memory and is 
		 * ready to get to work.
		 * 
		 * In designing this application I have elected to IGNORE all opportunities for automatic layout
		 * support and instead have elected to manually position each GUI element and its properties in
		 * order to exercise complete control over the user interface look and feel.
		 * 
		 */
		
				@Override 
		   public void start(Stage stage) {
			
			stage.setTitle("Login Form");	// Label the stage (a window)
			
			Pane theRoot = new Pane();      // Create a pane within the window
			try {
	            UInterface(theRoot);        // Create the Graphical User Interface
			}
			catch(Exception e) {}
			Scene scene = new Scene(theRoot,WINDOW_WIDTH,WINDOW_HEIGHT); //Creating a scene object
		    
			stage.setScene(scene);    //Adding scene to the stage 
		      
		     stage.show();            //Displaying the contents of the stage
		}
		
		/*******************************************************************************************************
		* This is the method that launches the JavaFX application
		* 
		*/
		
		 public static void main(String args[]){ 
		      launch(args); 
		   } 
		
}        
	



