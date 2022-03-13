import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
	static BackgroundFill c1 = new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY);
	static Background background = new Background(c1);
	static boolean player1X =true;
	static boolean player2O = false;
	static ArrayList<Button> buttons = new ArrayList<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(60,70,60,70));
		pane.setHgap(10.5);
		pane.setVgap(10.5); 
		pane.setBackground(background);
		
		Button p2 = bigButton("2p.png");
		pane.add(p2, 2, 0);
		p2.setOnAction(e->{
			game();
		});
		
		Scene scene  = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Tic Tac Toe");
		stage.getIcons().add(new Image("logo.png"));
		stage.show();
	}

	public static Button bigButton(String url) {
    	Image img = new Image(url);
    	ImageView v=new ImageView(img);
    	v.setFitWidth(250);
    	v.setFitHeight(250);
    	
		Button l = new Button();
		l.setTextFill(Color.BROWN); 
		l.setPrefSize(255, 255); 
		l.setGraphic(v);
		l.setStyle("-fx-background-color:MEDIUMPURPLE;");
		return l;
	}
	
	public static void game() {
		Stage stage = new Stage();
		GridPane pane0 = new GridPane();
		pane0.setAlignment(Pos.CENTER); 
        pane0.setPrefHeight(500);
        pane0.setPrefWidth(500);
        pane0.setHgap(10);
        pane0.setVgap(20);
		pane0.setBackground(background);

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER); 
		pane.setBackground(background);
		pane0.add(pane, 1,0);
		
        Button b0 = button("0");
        pane.add(b0, 0, 1);
        b0.setOnAction(e->{
        	setAction(b0);
        });
    	buttons.add(0,b0);

        Button b1 = button("1");
        pane.add(b1, 1,1);
        b1.setOnAction(e->{
        	setAction(b1);
        });
    	buttons.add(1,b1);

        Button b2 = button("2");
        pane.add(b2, 2,1);
        b2.setOnAction(e->{
        	setAction(b2);
        });
    	buttons.add(2,b2);

        Button b3 = button("3");
        pane.add(b3, 0, 2);
        b3.setOnAction(e->{
        	setAction(b3);
        });
    	buttons.add(3,b3);

        Button b4 = button("4");
        pane.add(b4, 1,2);
        b4.setOnAction(e->{
        	setAction(b4);
        });  
    	buttons.add(4,b4);

        Button b5 = button("5");
        pane.add(b5, 2,2);
        b5.setOnAction(e->{
        	setAction(b5);
        });
    	buttons.add(5,b5);

        Button b6 = button("6");
        pane.add(b6, 0, 3);
        b6.setOnAction(e->{
        	setAction(b6);
        });
    	buttons.add(6,b6);

        Button b7 = button("7");
        pane.add(b7, 1,3);
        b7.setOnAction(e->{
        	setAction(b7);
        });
    	buttons.add(7,b7);

        Button b8 = button("8");
        pane.add(b8, 2,3);
    	buttons.add(8,b8);

        b8.setOnAction(e->{
        	setAction(b8);
        });

        Button reset = new Button("Reset");
        reset.setStyle("-fx-background-radius: 18, 7;-fx-background-color:lightblue;");
        reset.setTextFill(Color.WHITE);
        reset.setPrefHeight(40);
        reset.setPrefWidth(90);
        reset.setFont(new Font(14));
        GridPane.setHalignment(reset, HPos.CENTER);
        reset.setOnAction(l->{
        	stage.close();
        	player1X=true;
        	player2O=false;
        	game();
        });
        pane0.add(reset, 1,1);
        
		Scene scene = new Scene(pane0);
		stage.setScene(scene);
		stage.setTitle("Game");
		stage.getIcons().add(new Image("logo.png"));
		stage.show();
	}
	
	public static void setAction(Button i){
		if(player1X == true) {
			i.setText("X");
			i.setStyle("-fx-background-color:lightblue;");
			player1X= false;
			player2O= true;
		} else {
			i.setText("O");
			i.setStyle("-fx-background-color:lightblue;");
			player2O= false;
			player1X= true;
		}
		check();
	}
	
	public static void check() {
		//check X win conditions
		if((buttons.get(0).getText()=="X") && (buttons.get(1).getText()=="X") && (buttons.get(2).getText()=="X")) {
			wins('x',0,1,2);
		}

		if((buttons.get(3).getText()=="X") && (buttons.get(4).getText()=="X") && (buttons.get(5).getText()=="X")) {
			wins('o',3,4,5);
		}

		if((buttons.get(6).getText()=="X") && (buttons.get(7).getText()=="X") && (buttons.get(8).getText()=="X")) {
			wins('x',6,7,8);
		}

		if((buttons.get(0).getText()=="X") && (buttons.get(3).getText()=="X") && (buttons.get(6).getText()=="X")) {
			wins('x',0,3,6);
		}

		if((buttons.get(1).getText()=="X") && (buttons.get(4).getText()=="X") &&(buttons.get(7).getText()=="X")) {
			wins('x',1,4,7);
		}

		if((buttons.get(2).getText()=="X") && (buttons.get(5).getText()=="X") && (buttons.get(8).getText()=="X")) {
			wins('x',2,5,8);
		}

		if((buttons.get(0).getText()=="X") && (buttons.get(4).getText()=="X") && (buttons.get(8).getText()=="X")) {
			wins('x',0,4,8);
		}

		if((buttons.get(2).getText()=="X") && (buttons.get(4).getText()=="X") && (buttons.get(6).getText()=="X")) {
			wins('x',2,4,6);
		}

		//check O win conditions
		if((buttons.get(0).getText()=="O") &&  (buttons.get(1).getText()=="O") && (buttons.get(2).getText()=="O")) {
			wins('o',0,1,2);
		}

		if((buttons.get(3).getText()=="O") && (buttons.get(4).getText()=="O") && (buttons.get(5).getText()=="O")) {
			wins('o',3,4,5);
		}

		if((buttons.get(6).getText()=="O") && (buttons.get(7).getText()=="O") && (buttons.get(8).getText()=="O")) {
			wins('o',6,7,8);
		}

		if((buttons.get(0).getText()=="O") && (buttons.get(3).getText()=="O") && (buttons.get(6).getText()=="O") ) {
			wins('o',0,3,6);
		}

		if((buttons.get(1).getText()=="O") && (buttons.get(4).getText()=="O") && (buttons.get(7).getText()=="O") ) {
			wins('o',1,4,7);
		}

		if((buttons.get(2).getText()=="O") && (buttons.get(5).getText()=="O") && (buttons.get(8).getText()=="O")) {
			wins('o',2,5,8);
		}

		if((buttons.get(0).getText()=="O") && (buttons.get(4).getText()=="O") && (buttons.get(8).getText()=="O")) {
			wins('o',0,4,8);
		}

		if((buttons.get(2).getText()=="O") && (buttons.get(4).getText()=="O") && (buttons.get(6).getText()=="O")) {
			wins('o',2,4,6);
		}
	}

	public static void wins(char win,int a,int b,int c) {
		Stage stage = new Stage();
		GridPane pane0 = new GridPane();
		pane0.setAlignment(Pos.CENTER); 
        pane0.setPrefHeight(250);
        pane0.setPrefWidth(250);
        pane0.setHgap(10);
        pane0.setVgap(20);
		pane0.setBackground(background);
		
		//Label Greeting User
		Label hello = new Label("Hello user, select your cities file...");
		hello.setFont(Font.font(16));  
		hello.setTextFill(Color.RED);
		hello.setFont(new Font(26));
        GridPane.setHalignment(hello, HPos.CENTER);
		pane0.add(hello, 0,0);
		
		buttons.get(a).setStyle("-fx-background-color:lightgreen;");
		buttons.get(b).setStyle("-fx-background-color:lightgreen;");
		buttons.get(c).setStyle("-fx-background-color:lightgreen;");
		if(win=='o') 
			hello.setText( "o wins");
		hello.setText("x wins");
		
        Button reset = new Button("Okay");
        reset.setStyle("-fx-background-radius: 18, 7;-fx-background-color:lightblue;");
        reset.setTextFill(Color.WHITE);
        reset.setPrefHeight(40);
        reset.setPrefWidth(90);
        reset.setFont(new Font(14));
        GridPane.setHalignment(reset, HPos.CENTER);
        reset.setOnAction(l->{
        	stage.close();
        });
        pane0.add(reset, 0,1);
        
		Scene scene  = new Scene(pane0);
		stage.setScene(scene);
		stage.setTitle("Tic Tac Toe");
		stage.getIcons().add(new Image("logo.png"));
		stage.show();
	}

	public static Button button(String id) {
		Button b8 = new Button();
		b8.setFont(new Font(40));
		b8.setPrefSize(100, 100); 
		b8.setStyle("-fx-border-color:MEDIUMPURPLE;-fx-background-color:transparent;-fx-border-width:5;");
		b8.setId(id);
		return b8;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
