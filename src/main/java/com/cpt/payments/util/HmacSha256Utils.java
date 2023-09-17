package com.cpt.payments.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256Utils {
	public void generateSignature(String secretKey, String jsonInput) {
		try {
	        	         // Generate the HMAC signature
	         String hmacSignature = generateHmacSHA256Signature(jsonInput, secretKey);

	         // Print the HMAC signature
	         System.out.println("HMAC Signature: " + hmacSignature);
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
		
	}
	 

	 public static String generateHmacSHA256Signature(String data, String secretKey)
	         throws NoSuchAlgorithmException, InvalidKeyException {
	     // Create an HMAC-SHA-256 key from the secret key
	     SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

	     // Initialize the HMAC-SHA-256 Mac instance
	     Mac mac = Mac.getInstance("HmacSHA256");
	     mac.init(keySpec);

	     // Compute the HMAC signature
	     byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

	     // Encode the signature as a Base64 string
	     return Base64.getEncoder().encodeToString(hmacBytes);
	 }
		
		
	}


