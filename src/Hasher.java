import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

/**
 * Destiny Hash Checker
 * @author Family
 *
 */
public class Hasher {
	byte[] input;
	String hash = "1ceab1f5b327682c7835e21b96711429";
	int hashLength = 24;
	Random random = new Random();
	MessageDigest md;
	char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,.!?".toCharArray();
	
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

		boolean found = false;
		
		while (!found) {
			try {
				input = generateInput(1);
			} catch (HasherException e) {
				continue;
			}
			
			// Only increment if the hash was eligible
			HashThread.count.getAndIncrement();
			
			found = isHash(input);
		}
		
		
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
		byte[] output = md.digest(input);
		
		if (Arrays.equals(output, hexStringToByteArray(hash))) {
			return true;
		} else {
			return false;
		}	
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}	
	
	/**
	 * Generates a new byte array hash
	 * @param counter
	 * @return
	 */
	public byte[] generateInput(int counter) throws HasherException {
		input = new byte[hashLength];

		for (int i = 0; i < input.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			input[i] = (byte) c;
		}
		
		// We have three words, so we need two spaces
		// Also, an input can't start or end with a space
		if (countByte(input, (byte) ' ') == 2 && input[0] != (byte) ' ' && input[input.length - 1] != (byte) ' ') {
			return input;
		} else {
			throw new HasherException("Spaces in the wrong place");
		}
	}
	
	public int countByte(byte[] input, byte search) {
		int count = 0;
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == search) {
				++count;
			}
		}
		
		return count;
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
