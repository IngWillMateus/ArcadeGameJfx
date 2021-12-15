package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DepContent {
	private static String[] questions;
	private static String[] answers;
	
	//Determina pregunta usada
	private boolean[] used;
	
	//Configurar respuesta usada.
	private boolean[] usedAns;
	
	private int correct;
	private String[] set;
	public static int qSize = 5;
	public int aSize = qSize*4;
	Randomizer rand;
	private int num;
	
	/*
	 * Metodos que inicia las preguntas y las respuestas 
	 * 	las colocas en preguntas, respuestas, usadas y establece las que se van a usar ademas de leer el archivo.  
	 
	 */
	public DepContent(){
		questions = new String[qSize];
		answers = new String[aSize];
		used = new boolean[qSize];
		set = new String[5];
		usedAns = new boolean[4];
		for (int i = 0; i < 4; i++){
			usedAns[i] = false;
		}
		for (int i = 0; i < qSize; i++){
			used[i] = false;
		}
		rand = new Randomizer();
		readFile();
	}
	
	
	/*
	 * Obtiene las preguntas al azar 
	 * almacena las preguntas y las repuestas en las correspondintes campos
	 * con lasrespuestas correcta y la incorrecta.
	 */
	public String[] getQA(){
		num = rand.generateInt(0, qSize);
		if (used[num] == false){
			used[num] = true;
			set[0] = questions[num];
			

			int g;
			for (int c = 1; c < 5; c++){
				g = generateAns();
				if (g == 0){
					set[c] = answers[num];
					correct = c;
				}
				else if (g == 1){
					set[c] = answers[num + qSize];
				}
				else if (g == 2){
					set[c] = answers[num + qSize*2];
				}
				else {
					set[c] = answers[num + qSize*3];
				}
			}
			for (int i = 0; i < 4; i++){
				usedAns[i] = false;
			}
			return set;
		}
		else {
			getQA();
		}
		return null;
	}
	
	
	/*
	 * Genera un numero al azar 
	 * verifica si una respuestas esta alamacenada
	 * en la posicion del arreglo
	 */
	private int generateAns(){
		int i;
		i = rand.generateInt(0, 4);
		if (usedAns[i] == false){
			usedAns[i] = true;
			return i;
		}
		return generateAns();
	}
	
	
	public boolean checkAns(int k){
		return (k == correct);
	}
	
	public int getAns(){
		return correct;
	}
	
	/*
	 * Este metodo toma las preguntas y respuestas y las alamacena en un arreglo.
	 */
	public void readFile(){
		int i = 0;
		String fileName = "FileDeptos.csv";
		File file = new File(fileName);
		try{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()){
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				//System.out.println(values[0]);
				questions[i] = values[0];
				answers[i] = values[1];
				answers[i+ qSize] = values[2];
				answers[i+ qSize*2] = values[3];
				answers[i+ qSize*3] = values[4];
				i++;
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		DepContent c = new DepContent();
		System.out.println(c.getQA());
	}
	
}