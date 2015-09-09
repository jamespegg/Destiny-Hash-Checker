import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Destiny Hash Checker
 * @author James Pegg
 *
 */
public class DestinyHashChecker {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Thread count : ");
		
		int threadCount = keyboard.nextInt();
			
			System.out.println("Running with " + threadCount + " threads");
			System.out.println("Press enter to exit");

			List<HashThread> threads = new ArrayList<>();
			
			for (int i = 0; i < threadCount; i++) {
				threads.add(new HashThread());
			}
			
			for (HashThread thread : threads) {
				thread.start();
			}
			
			
			boolean interupted = false;
			
			while (!interupted) {
				String in = keyboard.nextLine();
				in = keyboard.nextLine();
				
				if (in != null) {
					interupted = true;
				}
			}
			
			System.out.println("Stopping...");
			System.out.println("Hash iterations : " + HashThread.count);
			
			keyboard.close();
			System.exit(1);

		
	}
	
	
	

}
