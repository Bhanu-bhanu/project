package com.cpt.payments;

import com.cpt.payments.pojo.ADDRequest;
import com.google.gson.Gson;

public class TestMain {
	public static void main(String[] args) {
		Gson gson=new Gson();
		ADDRequest req=new ADDRequest();
		req.setNum1(3);
		req.setNum2(4);
		System.out.println(gson.toJson(req));

	}

}
