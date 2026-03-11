package DatabaseProject;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.sql.*;

public class Window{// extends Application{

	public static void main(String[] args) {
		//launch(args);
		
		int num = 124;
		String numS = num + "";
		System.out.println(numS.length());
	}

//	final int WIDTH = 9;
//	final int HEIGHT = 16;
//	BorderPane pane;
//	GridPane grid;
//	
//	@Override
//	public void start(Stage stage) {
//		pane = new BorderPane();
//		grid = new GridPane();
//		
//		DataBase();
//		
//		grid.setMaxSize(550, 20);
//		grid.setGridLinesVisible(true);
//		
//				
//		pane.setCenter(grid);
//		
//		Scene scene = new Scene(pane);
//		pane.setPrefSize(HEIGHT*50, WIDTH*50);
//		stage.setScene(scene);
//		stage.show();
//		
//	}
//	
//	public void DataBase() {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbtest", "root", "DerNachtZug*87");
//			
//			System.out.println("Connected");
//			String cmd = "select * from employees";
//			
//			String join = "select fullname, major_title, employees.ID from employees join majors on employees.ID = majors.ID;";
//			
//			Statement stmnt = connect.createStatement();
//			ResultSet result = stmnt.executeQuery(join);
//			ResultSetMetaData metadata = result.getMetaData();
//								
//			for(int i = 0; i < metadata.getColumnCount(); i++) {
//				System.out.print(metadata.getColumnName(i+1) + "\t\t");
//								
//				TextArea textAttr = new TextArea();
//				textAttr.setStyle("-fx-font: 20px \"Times New Roman\"");
//				textAttr.setEditable(false);
//				
//				textAttr.setText(metadata.getColumnName(i+1));
//				grid.addColumn(i, textAttr);
//			}
//			System.out.println();
//			
//			
//			int n = 1;
//			while(result.next() == true) {
//				System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3));		
//				
//				for(int i = 0; i < metadata.getColumnCount(); i++) {
//					TextArea textTuple = new TextArea(result.getString(i+1));
//					textTuple.setStyle("-fx-font: 20px \"Times New Roman\"");
//					textTuple.setEditable(false);
//					grid.add(textTuple, i, n);
//				}				
//				n++;
//			}
//			
//			
//		}catch(Exception ex) {
//			System.out.println("Not Connected");
//		}
//	}

}
