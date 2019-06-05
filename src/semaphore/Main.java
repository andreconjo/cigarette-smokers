package semaphore;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		Semaphore mutexS = new Semaphore(1);
		Semaphore full = new Semaphore(0);
		Semaphore empty = new Semaphore(1);
		
		Agent agent = new Agent(full, empty);
       
        agent.start();
        new Smoker(agent, "Tabaco", "Smoker 1", mutexS).start();
        new Smoker(agent, "Papel", "Smoker 2", mutexS).start();
        new Smoker(agent, "Fósforos", "Smoker 3", mutexS).start();
        
	}
}
