package semaphore;

import java.util.concurrent.Semaphore;

public class Smoker extends Thread{
	
	private String myIngredient;
	private Agent agent;
	private String name;
	private Semaphore mutexS;
	
	public Smoker(Agent agent, String ingredient, String name, Semaphore mutexS) {
		
		this.agent = agent;
		this.myIngredient = ingredient;
		this.name = name;
		this.mutexS = mutexS;
	}
	
	@Override
	public void run() {
		while(true) {
			//receive ingredient
			//make cigarette
			//smoke
			
			try {
				this.agent.full.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.mutexS.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (this.agent.haveThisIngredient(this.myIngredient)) {
				this.mutexS.release();
				this.agent.full.release();
				continue;
			}
			
			Delay.delay();
			System.out.println("Eu sou o " + this.name + " e eu tenho " + this.myIngredient + 
					". Então eu vou fazer um cigarro com o seu " + this.agent.getIngredient1() + 
					" e " + this.agent.getIngredient2());
			Delay.delay();
			System.out.println("Fazendo");
			Delay.delay();
			System.out.println("Fumando");
			Delay.delay();
			
			this.mutexS.release();
			this.agent.empty.release();	
		}
	}

}
