import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Destiny Hash Checker
 * @author James Pegg
 *
 */
public class DestinyHashChecker {
	
	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Thread count : ");
			int threadCount = Integer.parseInt(in.readLine());
			
			System.out.println("Running with " + threadCount + " threads");
			System.out.println("Press enter to exit");
			
			List<Thread> threads = new ArrayList<>();

			for (int i = 0; i < threadCount; i++) {
				threads.add(new Thread(new Hasher()));
			}
			
			for (Thread thread : threads) {
				thread.start();
			}	
			
			while (in.readLine() != null) {
				System.out.println("Stopping...");
				
				for (Thread thread : threads) {
					thread.interrupt();
				}			
				
				System.out.println("Hash iterations : " + Hasher.count);
				
				System.exit(1);
			}
		} catch (IOException e) {
			System.out.println("Something broke..");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Something broke..");
		}

		
	}
	
	
	

}
