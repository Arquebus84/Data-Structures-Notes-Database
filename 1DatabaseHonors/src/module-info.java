module JavaFX{
	requires javafx.base;		//Keep these aligned here, to stop the compiler from bitching
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires java.sql;
	
	exports DatabaseProject;
}