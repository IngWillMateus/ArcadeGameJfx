package application;


import java.util.*;

/**
 * Clase utilizada para generacion numerica al azar, se usa Math.random()  
 */
public class Randomizer {
	
	/**
	 * Retorna un entero al azar entre el mas pequeño al mas alto
     * 
     */
    public int generateInt(int low, int high) {
        return ( (int) ( (Math.random() * 1000000000 )  % (high - low) )  + low );
    }
    public int generateInt(double low, double high) {
        return generateInt((int) low, (int) high);
    }
	
    /*
     * Retorna un numero decimal al azar 
     */
    public double generateDecimal() {
        return Math.random() * 1000000000; 
    }
    
    public int generateInt() {
        return ( (int) generateDecimal() );
    }
	

	public Randomizer() {
		init(); 
	}
	
	private void init() {
		//--
	}

	/**
	 * parametros  args
	 */
	public static void main(String[] args) {
		
		// nueva instancia de la clase 
		Randomizer randomizer = new Randomizer(); 
		
		//Pruebas
		System.out.println(randomizer.generateDecimal());
		System.out.println(randomizer.generateInt());
		
		
		int from = 11;
		int to = 20; 
		Integer number = randomizer.generateInt(from, to); 
		System.out.printf("Number between %d and %d:  %d\n", from, to, number); 
		
		int intCount = 10; 

		int [] integers = new int[intCount]; 
		
		for(int i = 0 ; i < intCount ; ++i) {
			integers[i] = randomizer.generateInt(1, 1000);
		}
		
		Arrays.sort(integers);
		
		for(int i = 0 ; i < intCount ; ++i) {
			System.out.printf("[%d] = %d\n",  i,  integers[i] );
		}

	}

}

