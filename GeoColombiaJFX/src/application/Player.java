/*
 *Esta clase determina el nombre del jugador el puntaje y las respuestas malas y buenas
 *
 */

package application;

import java.text.DecimalFormat;

public class Player {
	
	private String name;
	private int score = 0;
	private boolean turn = true;
	private int wrong = 0;
	
	public Player(){
		name = null;
	}
	
	public void setName(String n){
		name = n;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public void addScore(){
		score++;
	}
	public int getScore(){
		return score;
	}
	
	public void addWrong(){
		wrong++;
	}
	public int getWrong(){
		return wrong;
	}
	
	public String getName(){
		return name;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn() {
		turn = false;
	}
	
	public int getTotal(){
		return (score + wrong);
	}
	
	public String getPercent(){
		double d = ((double)score/getTotal())*100; 
		DecimalFormat df = new DecimalFormat("#.##");
		return (df.format(d));
	}
	
}