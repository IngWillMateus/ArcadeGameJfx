module GeoColombiaJFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	
	exports Controller to javafx.fxml ;
	opens application to javafx.graphics, javafx.fxml;
	opens Controller to javafx.fxml;
}
