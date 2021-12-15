/* Desarrollador por WIlliam Mateus - Elizabeth Patiño
 * Politecnico Grancolombiano 
 * 
 * Este Controlador actua sobre el escenario Departamentos
 * Los segundos inician a penas inicia el juego y las preguntas apareceran en pantalla
 * se han creado un proceso selectivo de preguntas basadas en un archivo txt el cual selecciona automaticamente las preguntas. 
 * este es el 1er controlador de 3 opciones disponibles en el juego.
 * 
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import Controller.StartGameController;


public class DepartmentsQzController implements Initializable {

    @FXML
    private RadioButton Respuesta1,Respuesta2,Respuesta3,Respuesta4;
    
    @FXML
    private Button Exit, Info, enter;

    @FXML
    private Label Segundos, Pregunta, Nombre, Score;
    
    private String[] holder = new String[5];


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (StartGameController.player1.isTurn()){
		time();
		Nombre.setText(StartGameController.player1.getName());
		holder = StartGameController.content.getQA();
		changeLabels();
		}
	
	}
    
	//Este metodo cambia el orden de las respuestas y valida la seleccionada. 
	//controla que no se pueda seleccionar mas de una respuesta
	
	
	@FXML
	public void selectAnswer1(ActionEvent event) {
		Respuesta1.setSelected(true);
		Respuesta2.setSelected(false);
		Respuesta3.setSelected(false);
		Respuesta4.setSelected(false);
	}
	@FXML
	public void selectAnswer2(ActionEvent event) {
		Respuesta2.setSelected(true);
		Respuesta1.setSelected(false);
		Respuesta3.setSelected(false);
		Respuesta4.setSelected(false);
	}
	@FXML
	public void selectAnswer3(ActionEvent event) {
		Respuesta3.setSelected(true);
		Respuesta1.setSelected(false);
		Respuesta2.setSelected(false);
		Respuesta4.setSelected(false);
	}
	@FXML
	public void selectAnswer4(ActionEvent event) {
		Respuesta4.setSelected(true);
		Respuesta3.setSelected(false);
		Respuesta2.setSelected(false);
		Respuesta1.setSelected(false);
	
	}
	
	
	//con el siguiente metodo se verifica las respuestas una vez que le jugador presiona el boron compruebalo!
	
	@FXML
	public void checkAnswer(ActionEvent event) {
		if (Respuesta1.isSelected()){
			if (StartGameController.content.checkAns(1)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(1);
				
			}
		}
		
		else if (Respuesta2.isSelected()){
			if (StartGameController.content.checkAns(2)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(2);
			}
		}
		
		else if (Respuesta3.isSelected()){
			if (StartGameController.content.checkAns(3)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(3);
			}
		}
		
		else if (Respuesta4.isSelected()){
			if (StartGameController.content.checkAns(4)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(4);
			}
		}
		
		else{
		}
	}
	
	
	/*
	 * Este metodo recibe la respuesta seleccionada.
	 * Se configura en rojo el texto de la respuesta incorrecta. 
	 * Se configura en verde el texto de la respuesta correcta
	 */
	private void correctAns(int selectedAns){
		if (selectedAns == 1){
			Respuesta1.setTextFill(Paint.valueOf("Red"));
		}
		else if (selectedAns == 2){
			Respuesta2.setTextFill(Paint.valueOf("Red"));
		}
		else if (selectedAns == 3){
			Respuesta3.setTextFill(Paint.valueOf("Red"));
		}
		else {
			Respuesta4.setTextFill(Paint.valueOf("Red"));
		}
		
		
		int correctAns = StartGameController.content.getAns();
		if (correctAns == 1){
			Respuesta1.setTextFill(Paint.valueOf("Green"));
		}
		else if (correctAns == 2){
			Respuesta2.setTextFill(Paint.valueOf("Green"));
		}
		else if (correctAns == 3){
			Respuesta3.setTextFill(Paint.valueOf("Green"));
		}
		else{
			Respuesta4.setTextFill(Paint.valueOf("Green"));
		}
		
		updateWrong();
		//sleep();
		changeLabels();
	}

	/*
	 * Actualiza el puntaje agrega 1 punto al jugador.
	 * Se configura la etiqueta puntaje para que sea actualizada. 
	 */
	public void updateScore(){
	
			StartGameController.player1.addScore();
			Score.setText(Integer.toString(StartGameController.player1.getScore()));
	
	}
	
	/*
	 * este metodo se utliza para agregar le puntaje malo al jugador
	 * players wrong answers.
	*/
	public void updateWrong(){
		
			StartGameController.player1.addWrong();

		
	}
	
	
	//Este metodo se usara para cambiar las etiquetas de los botones y las respuestas!
	
	private void changeLabels(){
		StartGameController.content.getQA();
		
		Pregunta.setText(holder[0]);
		Respuesta1.setText(holder[1]);
		Respuesta2.setText(holder[2]);
		Respuesta3.setText(holder[3]);
		Respuesta4.setText(holder[4]);
		
		Respuesta1.setSelected(false);
		Respuesta2.setSelected(false);
		Respuesta3.setSelected(false);
		Respuesta4.setSelected(false);
		
		Respuesta1.setTextFill(Paint.valueOf("Black"));
		Respuesta2.setTextFill(Paint.valueOf("Black"));
		Respuesta3.setTextFill(Paint.valueOf("Black"));
		Respuesta4.setTextFill(Paint.valueOf("Black"));
	}
	
	/*
	 * La finalidad del siguiente metodo es verificar si el juagador 
	 * finalizo el juego, de aqui se hara un cambio a la ventana de finalizacion del juego donde se muestra el puntaje obetenido
	*/
	/*private void endRound(){
		
			StartGameController.player1.setTurn();
			try{
				Parent root = FXMLLoader.load(getClass().getResource("/application/StartGame.fxml"));
				Scene scene = new Scene(root);									   
				Stage stage = (Stage) enter.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}
			catch (IOException ioe){
		        System.out.println (ioe.toString());
		        System.out.println("Could not find file /application/StartGame.fxml");
			}
		

	}*/
	
	/*
	 * El metodo time es usuado para controlar el tiempo de 30 segundos para cada pregunta. 
	 */
    
	public void time(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
				int i = 30;
				@Override
				public void run(){
					Platform.runLater(new Runnable() {
					@Override
					public void run(){
						if (i >= 1){
							Segundos.setText(Integer.toString(i));
							i--;
						}
						else{
							Segundos.setText("0");
							timer.purge();
							timer.cancel();
							//endRound();
						}
						}
					});
				 }
			}, 1000, 1000);
				
	}
	

  

}
