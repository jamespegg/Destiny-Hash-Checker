import java.security.MessageDigest;
import java.util.Random;

/**
 * Destiny Hash Checker
 * @author Family
 *
 */
public class Hasher {
	byte[] input;
	String hash = "1ceab1f5b327682c7835e21b96711429";
	Random random = new Random();
	MessageDigest md;
	char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
	
	/**
	 * Sets up the MessageDigest
	 */
	public Hasher(){
		try {
			md = MessageDigest.getInstance("md5");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
	/**
	 * Keeps looping to generate a new input until a match is found
	 * @return
	 */
	public boolean check() {
		
		int count = 0;
		do {
			input = generateInput(1);
			
			// Print out a . for every 100,000 iterations
			if (count > 100000) {
				System.out.print(".");
				count = 0;
			} else {
				++count;
			}
			
		} while (!isHash(input));
		
		
		// Obviously print out the match!
		System.out.println();
		System.out.println("We found a match! " + new String(input));
		return true;
	}
	
	/**
	 * Checks if the input matches our Destiny hash
	 * @param input
	 * @return
	 */
	public boolean isHash(byte[] input) {
		md.update(input);
		String output = toHex(md.digest(input));

		if (output.equals(hash)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Generates a new byte array hash
	 * @param counter
	 * @return
	 */
	public byte[] generateInput(int counter) {
		input = new byte[24];

		for (int i = 0; i < input.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			input[i] = (byte) c;
		}
		
		// Need to make a few sanity checks here
		String string = new String(input);
		int count = string.length() - string.replace(" ", "").length();
		
		// We have three words, so we need two spaces
		// Also, an input can't start or end with a space
		if (count == 2 && !string.substring(0, 1).equals(" ") && !string.substring(string.length() - 1).equals(" ")) {
			return input;
		} else {
			
			// This is to stop stackoverflows... Probably not that efficient
			if (counter < 20) {
				return generateInput(counter + 1);
			} else {
				return input;
			}
		}
	}
	
	/**
	 * Converts a byte array into a hex string
	 * @param input
	 * @return
	 */
	public String toHex(byte[] input) {
        StringBuffer hexString = new StringBuffer();
        
    	for (int i=0;i<input.length;i++) {
    		String hex=Integer.toHexString(0xff & input[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
    	return hexString.toString();
	}	
}
