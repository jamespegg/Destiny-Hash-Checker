
/**
 * Destiny Hash Checker Thread
 * @author James Pegg
 *
 */
public class HashThread implements Runnable {

	private Thread t;
	
	public void run() {
		Hasher hasher = new Hasher();

		while (!hasher.check()) {
			// Don't do anything because it's checking
		}
		
		System.out.println("Thread done, answer found");
		
		// Stop all threads
		System.exit(0);
	}
	
   public void start ()
   {
      if (t == null)
      {
         t = new Thread (this);
         t.start();
      }
   }	
}
