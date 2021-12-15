
//Esta clase es creada para alamacenar el nombre del jugador y mostrarlo en la siguiente venta de juego, la accion 
//enter name abre la ventana donde el jugador lee las reglas y elige lo que desea jugar. 
package Controller;

import java.io.IOException;

import Controller.StartGameController;
import application.Player;
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


public class GamePlayerController {
	private static Player player1;
	
    @FXML
    private Button ContinueButton, Exitbutton, InfoButton;


    @FXML
    private Label Labelname, empty;

    @FXML
    private TextField Playername;

    
    public void setname() {

    	if (Playername.getText() != null && ! Playername.getText().trim().isEmpty()){
    		StartGameController.player1.setName(Playername.getText());
    		empty.setVisible(false);
    		Playername.setText(null);
    		}
		else {
			empty.setVisible(true);
			}
		}
		
    
    	

	@FXML
	public void enterName(ActionEvent event) throws IOException{
		    setname();
			Parent root = FXMLLoader.load(getClass().getResource("/application/GameMainMenu.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ContinueButton.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			}
			


}
