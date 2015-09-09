import java.util.ArrayList;
import java.util.List;

/**
 * Destiny Hash Checker
 * @author James Pegg
 *
 */
public class DestinyHashChecker {
	
	public static void main(String[] args) {
		
		if (args[0] == null) {
			System.out.println("Please provide the number of threads to run");
			System.exit(1);
		} else {
			int threadCount = Integer.parseInt(args[0]);
			
			System.out.println("Running with " + threadCount + " threads");

			List<HashThread> threads = new ArrayList<>();
			
			for (int i = 0; i < threadCount; i++) {
				threads.add(new HashThread());
			}
			
			for (HashThread thread : threads) {
				thread.start();
			}
		}
		
	}
	
	
	

}
