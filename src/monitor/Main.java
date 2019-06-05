package monitor;

public class Main {

	public static void main(String[] args) {
		
		AgentSmokerMonitor monitor = new AgentSmokerMonitor();
		Agent agent = new Agent(monitor);
       
        agent.start();
        new Smoker("Smoker 1", "Tabaco", monitor).start();
        new Smoker("Smoker 2", "Papel", monitor).start();
        new Smoker("Smoker 3", "Fósforos", monitor).start();
        
	}
}
