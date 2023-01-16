package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		try {
			final int HEIGHT = 250; //Resolution of window
			final int WIDTH = 700;
			
			
		

			
			BorderPane rootLogin = new BorderPane(); //creates a root BorderPane to contain all of our UI
			BorderPane rootOrder = new BorderPane();
			BorderPane rootProcessing = new BorderPane();
			BorderPane rootCooking = new BorderPane();
			BorderPane rootNewOrder = new BorderPane();
			rootNewOrder.setPadding(new Insets(10, 20, 10, 20));
			Scene loginScreen = new Scene(rootLogin, WIDTH, HEIGHT);
			Scene orderScreen = new Scene(rootOrder, WIDTH, HEIGHT);
			Scene newOrderScreen = new Scene(rootNewOrder, WIDTH, HEIGHT);
			Scene processingScreen = new Scene(rootProcessing, WIDTH, HEIGHT);
			Scene cookingScreen = new Scene(rootCooking, WIDTH, HEIGHT);
			
			Text title = new Text("Joe's Pizza"); //Label in top left 
			HBox centerBox = new HBox(); //Box to hold 2 lists of pizza type/toppings in center
			centerBox.setSpacing(10);
			//Creating a box to hold all of our toppings in a vertical list
			VBox toppingsBox = new VBox(); 
			toppingsBox.setSpacing(8);
			//Initializing Label and checkboxes for the list of toppings
			Text toppingsText = new Text("Toppings");
			CheckBox extraCheeseCheck = new CheckBox("ExtraCheese");
			CheckBox baconCheck = new CheckBox("Bacon");
			CheckBox mushroomCheck = new CheckBox("Mushroom");
			//Creating a box to hold all of our pizza types in a vertical list
			VBox pizzaTypeBox = new VBox();
			pizzaTypeBox.setSpacing(8);
			//Initializing the group, label, and radiobuttons for the list of pizza types
			Text pizzaTypeText = new Text("Pizza Type");
			ToggleGroup pizzaTypeGroup = new ToggleGroup();
			RadioButton cheeseButton = new RadioButton("Cheese");
			RadioButton pepperoniButton = new RadioButton("Pepperoni");
			RadioButton veggiButton = new RadioButton("Veggi");
			//Grouping the radiobutton bubbles together and storing the prices in their UserData
			cheeseButton.setToggleGroup(pizzaTypeGroup);
			pepperoniButton.setToggleGroup(pizzaTypeGroup);
			veggiButton.setToggleGroup(pizzaTypeGroup);
			//Nesting all of our children to the correct spots on the UI
			pizzaTypeBox.getChildren().addAll(pizzaTypeText, cheeseButton, pepperoniButton, veggiButton);
			
			
			HBox buttons = new HBox();
			
			buttons.setSpacing(10);
			buttons.setPadding(new Insets(10, 20, 10, 20));
			//Create and place our calculate button at the bottom of our window.
			Button calculateButton = new Button("Caclulate Total");
			calculateButton.setMaxWidth(500);
			rootNewOrder.setBottom(calculateButton);
			Button doneButton = new Button("Done");
			calculateButton.setMaxWidth(500);
			rootNewOrder.setBottom(doneButton);
			//Create and place our output text field to the right of our window.
			TextArea outputArea = new TextArea();
			outputArea.setMaxWidth(150);
			outputArea.setMaxHeight(HEIGHT - 50);
			rootNewOrder.setRight(outputArea);
			
			buttons.getChildren().addAll(calculateButton, doneButton);
			rootNewOrder.setBottom(buttons);
		
			//Adding functionality to the calculate button
			EventHandler<ActionEvent> buttonPressed = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					try { //When the button is pressed, we try to run the following code
						 //Finally, we add the base price of the pizza to the price of toppings and output
						double total = 0.0;
					
						if(cheeseButton.isSelected()){
						
							total = total + 10.0;
							if(extraCheeseCheck.isSelected()) {
								
								total = total + 1.50;
				
							}
							if(baconCheck.isSelected()) {
								
								total = total + 1.50;
				
							}
							if(mushroomCheck.isSelected()) {
								
								total = total + 1.50;
						
							}	
							outputArea.setText("Total price is : " + String.valueOf(total));
					
						}
						
						if(pepperoniButton.isSelected()) {
						
							total = total + 12.0;
							if(extraCheeseCheck.isSelected()) {
								
								total = total + 1.50;
					
							}
							if(baconCheck.isSelected()) {
								
								total = total + 1.50;
	
							}
							if(mushroomCheck.isSelected()) {
								total = total + 1.50;
					
							}	
							outputArea.setText("Total price is : " + String.valueOf(total));
				
						}
						if(veggiButton.isSelected()) {
						
							total = total + 15.0;
							if(extraCheeseCheck.isSelected()) {
								
								total = total + 1.50;
			
							}
							if(baconCheck.isSelected()) {
								
								total = total + 1.50;
						
							}
							if(mushroomCheck.isSelected()) {
								total = total + 1.50;
				
							}	
							outputArea.setText("Total price is : " + String.valueOf(total));
				
						}
				//		primaryStage.setScene(orderScreen);
					} catch(Exception x) { //An error will occur if no pizza type is selected, so we catch it and prompt the user
						outputArea.setText("Please select\na pizza\ntype");
					}
				}
			};
			
			calculateButton.setOnAction(buttonPressed); //Assign that functionality to our calculate button
			
			EventHandler<ActionEvent> done = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					primaryStage.setScene(orderScreen);
				}
			};
			doneButton.setOnAction(done);
			
			//Nesting all of our boxes and such into our UI
			toppingsBox.getChildren().addAll(toppingsText, extraCheeseCheck, baconCheck, mushroomCheck);
			centerBox.getChildren().addAll(pizzaTypeBox, toppingsBox);
			centerBox.setAlignment(Pos.CENTER); //Center the centerbox for visual design
			rootNewOrder.setCenter(centerBox);
			rootNewOrder.setTop(title);
			
			
			VBox loginBox = new VBox();
			loginBox.setSpacing(10);
			loginBox.setPadding(new Insets(10, 20, 10, 20));
			Label usernameLabel= new Label("Username: ");
			Label passwordLabel = new Label("Password: ");
			TextField usernameField = new TextField();
			TextField passwordField = new TextField();
			Label invalidPasswordLabel = new Label("");
			Button loginButton = new Button("Login");

			
			loginBox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, invalidPasswordLabel, loginButton);
			rootLogin.setCenter(loginBox);
			
			
			
			
			EventHandler<ActionEvent> loginButtonPressed = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					try { //When the button is pressed, we try to run the following code
						 //Finally, we add the base price of the pizza to the price of toppings and output
						String username = usernameField.getText();
						System.out.println(username);
						String password = passwordField.getText();
						if (isValidPassword(username, password) == true) {
							invalidPasswordLabel.setText("");
							String userType = getUserType(username);
							if (userType.equals("Customer")) {
								primaryStage.setScene(orderScreen);
							}
							else if (userType.equals("Processor")) {
								primaryStage.setScene(processingScreen);
							}
							else {
								primaryStage.setScene(cookingScreen);
							}
						}
						else {
							invalidPasswordLabel.setText("Invalid Username or Password");
						}
					} catch(Exception x) { //An error will occur if no pizza type is selected, so we catch it and prompt the user
						outputArea.setText("Please select\na pizza\ntype");
					}
				}
			};

			loginButton.setOnAction(loginButtonPressed);
			
			
			//Order Screen
			VBox userOrderListBox = new VBox();
			userOrderListBox.setSpacing(30);							//new line 
			userOrderListBox.setPadding(new Insets(10, 20, 30, 20));  //new line 
			
			ListView<String> userOrderList = new ListView<String>();
			ObservableList <String> userOrders = FXCollections.observableArrayList (
					"Order1", "Order2", "Order3");
			userOrderList.setItems(userOrders);
			Label userOrderLabel = new Label("Your Orders");
			userOrderListBox.getChildren().addAll(userOrderLabel, userOrderList);
			rootOrder.setRight(userOrderListBox);
		
/// HERE
			Button newOrderButton = new Button("Start a New Order");
			newOrderButton.setAlignment(Pos.CENTER);
			Button userLogoutButton = new Button ("Logout");
			userLogoutButton.setMaxWidth(WIDTH);
			
			
			VBox allButtons = new VBox();
			allButtons.getChildren().addAll(newOrderButton, userLogoutButton);
			rootOrder.setBottom(allButtons);
			
			

			EventHandler<ActionEvent> newOrderButtonPressed = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					primaryStage.setScene(newOrderScreen);
				}
			};
			EventHandler<ActionEvent> logoutButtonPressed = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					primaryStage.setScene(loginScreen);
				}
			};
				
			newOrderButton.setOnAction(newOrderButtonPressed);
			userLogoutButton.setOnAction(logoutButtonPressed);
			rootOrder.setBottom(userLogoutButton);
			rootOrder.setLeft(newOrderButton);
			
			//Processor Screen:
			VBox processorOrderListBox = new VBox();
			processorOrderListBox.setSpacing(30);							//new line 
			processorOrderListBox.setPadding(new Insets(10, 20, 30, 20));
			ListView<String> processorOrderList = new ListView<String>();
			ObservableList <String> processorOrders = FXCollections.observableArrayList (
					"Order1", "Order2", "Order3");
			processorOrderList.setItems(processorOrders);
			Label processorOrderLabel = new Label("Orders");
			TextArea processorOrderDetails = new TextArea("Order 1 Detals: \nPepperoni\nCheese\nSausage");
			processorOrderDetails.setEditable(false);
			processorOrderListBox.getChildren().setAll(processorOrderLabel, processorOrderList);
			rootProcessing.setLeft(processorOrderList);
			rootProcessing.setCenter(processorOrderDetails);
			Button processingUpdateOrder = new Button("Set Status to ReadyToCook");
			String selectedOrder = "Temp";
			EventHandler<ActionEvent> readyToCook = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					updateOrder(processorOrderList.getSelectionModel().getSelectedItem(), "readyToCook");
				}
			};
			processingUpdateOrder.setOnAction(readyToCook);
			Button processorLogoutButton = new Button("Logout");
			processorLogoutButton.setMaxWidth(WIDTH);
			processorLogoutButton.setOnAction(logoutButtonPressed);
			rootProcessing.setRight(processingUpdateOrder);
			rootProcessing.setBottom(processorLogoutButton);
			
			//Cook View
			VBox cookOrderListBox = new VBox();
			cookOrderListBox.setSpacing(30);							//new line 
			cookOrderListBox.setPadding(new Insets(10, 20, 30, 20));
			ListView<String> cookOrderList = new ListView<String>();
			ObservableList <String> cookOrders = FXCollections.observableArrayList (
					"Order1", "Order2", "Order3");
			cookOrderList.setItems(cookOrders);
			Label cookOrderLabel = new Label("Orders");
			TextArea cookOrderDetails = new TextArea("Order 1 Detals: \\nPepperoni\\nCheese\\nSausage");
			cookOrderDetails.setEditable(false);
			cookOrderListBox.getChildren().setAll(cookOrderLabel, cookOrderList);
			rootCooking.setLeft(cookOrderList);
			rootCooking.setCenter(cookOrderDetails);
			Button cookUpdateOrder = new Button("Set Status to Cooking");
			Button cookFinishOrder = new Button("Set Status to Ready");
			cookUpdateOrder.setMaxWidth(400);
			cookFinishOrder.setMaxWidth(400);
			//String selectedOrder = "Temp";
			EventHandler<ActionEvent> cooking = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					updateOrder(cookOrderList.getSelectionModel().getSelectedItem(), "cooking");
				}
			};
			EventHandler<ActionEvent> finished = new EventHandler<ActionEvent>() { //Defining a eventhandler for the button
				public void handle(ActionEvent e) {
					updateOrder(cookOrderList.getSelectionModel().getSelectedItem(), "finished");
				}
			};
			VBox cookButtonBox = new VBox();
			cookButtonBox.getChildren().addAll(cookUpdateOrder, cookFinishOrder);
			cookUpdateOrder.setOnAction(cooking);
			cookFinishOrder.setOnAction(finished);
			Button cookLogoutButton = new Button("Logout");
			cookLogoutButton.setMaxWidth(WIDTH);
			cookLogoutButton.setOnAction(logoutButtonPressed);
			rootCooking.setBottom(cookLogoutButton);
			rootCooking.setRight(cookButtonBox);
			
			//////////////////////////////////////////////////////////
		
			
			
			primaryStage.setScene(loginScreen);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isValidPassword(String username, String password) {
		//Prototype Implementation for testing purposes
		if (username.equals("Customer") || username.equals("Cook") || username.equals("Processor")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getUserType(String username) {
		//Prototype Implementation for testing purposes
		if (username.equals("Customer")) {
			return "Customer";
		}
		else if (username.equals("Processor")){
			return "Processor";
		}
		else if (username.equals("Cook")) {
			return "Cook";
		}
		else {
			return "invalid";
		}
	}
	
	public void updateOrder(String selectedOrder, String updateType) {
		System.out.println("Order " + selectedOrder + " updated to " + updateType);
	}
	public static void main(String[] args) {
		launch(args);
	}
}