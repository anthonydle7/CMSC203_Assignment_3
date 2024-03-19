/*
 * Class: CMSC 203 30339
 * Instructor: Dr. Grinberg
 * Description: 
 * Due: 03/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Anthony Le
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */

public class CryptoManager 
{
	
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	//boolean/ranges 
	public static boolean isStringInBounds (String plainText) 
	{
		final char LOWER_RANGE = ' ';
		final char UPPER_RANGE = '_';
		for (char character : plainText.toCharArray()) 
		{
			if (character < LOWER_RANGE || character > UPPER_RANGE) 
			{
			return false;
		}
			
		}
		
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	
	// encryption using caesar method
	public static String caesarEncryption(String plainText, int key) 
	{ 
		if (!isStringInBounds(plainText)) 
		{
			
			return "Text is not in bounds.";
		}
		
		final int BASE = 32;
		final int RANGE = 64;
		
		StringBuilder encrypted = new StringBuilder();
		
		for (char character : plainText.toCharArray()) 
			
		{
			int ogPos = character - BASE;
			int newPos = (ogPos + key) % RANGE;
			// turns ascii value to a char
			char newChar = (char)(BASE + newPos); 
			// adds the new character into encrypted
			encrypted.append(newChar); 
		}
		
		return encrypted.toString();
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	// encryption using bellaso cipher
	public static String bellasoEncryption (String plainText, String bellasoStr) 
	{
		final int BASE = 32;
		final int RANGE = 64;
		
		StringBuilder encrypted = new StringBuilder();
		
		for (int i = 0 ; i < plainText.length() ; i++) 
		{
			char character = plainText.charAt(i);
			int key = bellasoStr.charAt(i % bellasoStr.length()) - BASE;
			int ogPos = character - BASE;
			int newPos = (ogPos + key) % RANGE;
			char newChar = (char)(BASE + newPos);
			encrypted.append(newChar);
		}
		
		return encrypted.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	// returns the decrypted string 
	public static String caesarDecryption (String encryptedText, int key) 
	{
		final int BASE = 32;
		final int RANGE = 64;
		
		StringBuilder decrypted = new StringBuilder();
		
		for (char character : encryptedText.toCharArray()) 
		{
			int originalPos = character - BASE;
			int newPos = (originalPos - key) % RANGE;
			//makes sure it is within the range and not negative
			if (newPos < 0)
				newPos += RANGE;
			// newPos into ASCII
			char newChar = (char)(BASE + newPos); 
		decrypted.append(newChar);
		
		}
		
		return decrypted.toString(); 
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	//return text 
	public static String bellasoDecryption(String encryptedText, String bellasoStr) 
	{
		    final int BASE = 32;
		    final int RANGE = 64;
		    StringBuilder decryptedText = new StringBuilder();
		    for (int i = 0; i < encryptedText.length(); i++) 
		    {
		 	
		     char ch = encryptedText.charAt(i);
		     int key = bellasoStr.charAt(i % bellasoStr.length()) - BASE;
		     int originalPosition = ch - BASE;
		        
		      int newPosition = (originalPosition - key) % RANGE;
		    if (newPosition < 0) newPosition += RANGE;
		    char newChar = (char) (BASE + newPosition);
		        
		     decryptedText.append(newChar);
		    }
		    
		    return decryptedText.toString();
		}
	}
