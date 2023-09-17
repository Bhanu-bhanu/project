package com.cpt.payments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.pojo.ADDRequest;
import com.cpt.payments.pojo.ADDResponse;

@RestController
@RequestMapping("/controller")


public class TestController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello,world!";
		
	}
	@PostMapping("/addPost")
	public int addPost(@RequestParam(value="num1")int val1,@RequestParam(value="num2")int val2) {
		System.out.println("val1:"+val1+"val2"+val2);
		int res=val1+val2;
		System.out.println("res:"+res);
		return res;
	}
	@GetMapping("/addGet")
	public int addGet(@RequestParam(value="num1")int val1,@RequestParam(value="num2")int val2) {
		System.out.println("val1:"+val1+"val2:"+val2);
		int res=val1+val2;
		System.out.println("res:"+res);
		return res;
	}
	
	@PostMapping("/processJSON")
	@ResponseBody
	public ADDResponse processJSON(@RequestBody ADDRequest request) {
		System.out.println("Calling processJSON::request:"+request);
		int res=request.getNum1() +request.getNum2();
		ADDResponse response=new ADDResponse();
		response.setResValue(res);
		System.out.println("Add responce:"+response);
		
		return response;
		
	}
		public String initPayment(String paymentMethod,int amount,String curr) {
		return "Payment successfull";
	}

}
