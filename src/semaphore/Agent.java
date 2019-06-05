package semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Agent extends Thread{
	
	private int randomIngredient;
	private Random random = new Random();
	private String ingredient1 = new String();
	private String ingredient2 = new String();
	public Semaphore full, empty;
	
	public Agent(Semaphore full, Semaphore empty) {
		this.full = full;
		this.empty = empty;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				this.empty.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.randomIngredient = this.random.nextInt(3);
			if (this.randomIngredient == 0) {
				this.ingredient1 = "Tabaco";
				this.ingredient2 = "Papel";
			} 
			else if (this.randomIngredient == 1) {
				this.ingredient1 = "Tabaco";
				this.ingredient2 = "Fósforos";
			} 
			else if (this.randomIngredient == 2) {
				this.ingredient1 = "Fósforos";
				this.ingredient2 = "Papel";
			}
			
			System.out.println("Eu sou o agente e ofereço " + this.ingredient1 + " e " + this.ingredient2);
			
			this.full.release();
			
		}
	}
	
	public boolean haveThisIngredient(String ing) {
		if(this.ingredient1.equals(ing) || this.ingredient2.equals(ing)) {
			return true;
		}
		return false;
	}
	
	public String getIngredient1() {
		return ingredient1;
	}

	public String getIngredient2() {
		return ingredient2;
	}
}
