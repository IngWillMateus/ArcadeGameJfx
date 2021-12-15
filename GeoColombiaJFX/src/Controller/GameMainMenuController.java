// Esta clase hace el cambio al escenario de preguntas cuando el jugadro escoge la opcion departamentos!


package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.Player;


import java.io.IOException;
import application.DepContent;


public class GameMainMenuController {

	
    @FXML
    private Button Ciudades, Comidas, Departamentos;

    @FXML
    private TextField Playername;
    
    @FXML
	private Label empty, labelnombre;
	
   
    


	@FXML
	public void playDeptos(ActionEvent event) throws IOException{
	
		 
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/DepartmentsQz.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) Departamentos.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
		catch (IOException ioe){
	        System.out.println (ioe.toString());
	        System.out.println("Could not find file /application/DepartmentsQz.fxml");
		}
	}

	

}
