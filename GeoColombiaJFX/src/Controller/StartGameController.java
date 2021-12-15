package Controller;

import java.io.IOException;


import application.DepContent;
import application.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartGameController {
	
	public static Player player1;
	public static DepContent content;
	
    @FXML
    private Button PlayButtonMainScene;

	/*El Metodo play cambia la escena desde el inicio del juego a la vista del menu 
	 * 
	 * se crea la excepcion por si no se enecuentra el archivo a donde se dirige este boton.
	 */
 	@FXML
	public void play(ActionEvent event){
		content = new DepContent();
		player1 = new Player();
 		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/GamePlayer.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) PlayButtonMainScene.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			} 
		catch (IOException ioe) {
	        System.out.println (ioe.toString());
	        System.out.println("No se puede encontrar el archivo /application/GamePlayer.fxml");
			}
	}
}

