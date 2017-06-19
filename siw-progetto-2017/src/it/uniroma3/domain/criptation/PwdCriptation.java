package it.uniroma3.domain.criptation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdCriptation {
	public static String getEncodedPassword(String clearTextPassword)
			throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(clearTextPassword.getBytes());

		return StringCriptation.bufferToHex(md.digest()); //md.digest() effettua il padding finale
	}

	public boolean testPassword(String clearTextTestPassword, String encodedActualPassword) throws NoSuchAlgorithmException {

		String encodedTestPassword =
				getEncodedPassword(clearTextTestPassword);

		return (encodedTestPassword.equals(encodedActualPassword));
	}
}
