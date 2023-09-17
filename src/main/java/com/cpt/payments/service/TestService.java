package com.cpt.payments.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.cpt.payments.pojo.ADDRequest;
import com.cpt.payments.util.HmacSha256Utils;
import com.google.gson.Gson;



public class TestService {
	private String secretKey="THIS_IS_MY_SECRET";
	
	public int validateProcess(ADDRequest req,String clientsignature) throws InvalidKeyException, NoSuchAlgorithmException {
		
		Gson gson=new Gson();
		String jsonRequest=gson.toJson(req);
		System.out.println("jsonRequest:"+ jsonRequest);
		
		
		String generatesig=HmacSha256Utils.generateHmacSHA256Signature(secretKey, jsonRequest);
		System.out.println("generatesig:"+ generatesig);
		if(generatesig.equals(clientsignature)) {
			return req.getNum1()+req.getNum2();
			
		}
		
		return -1;
	}

}
