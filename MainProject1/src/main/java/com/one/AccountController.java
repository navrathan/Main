package com.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.one.constants.BaseResponse;
import com.one.vo.Login;
import com.one.vo.Registration;

@RestController
//@RequestMapping("/account")

public class AccountController {
	@Autowired
	AccountService accountService;
	@RequestMapping(value="/register",method = RequestMethod.POST, headers = "Accept=application/json")
	public BaseResponse registrtion(@RequestBody Registration registration) throws MyException {
		BaseResponse baseresponse=new BaseResponse();
		System.out.println("regiostration");
		baseresponse=accountService.registration(registration);
		System.out.println("done done skn");
		return baseresponse;
	}
	
	 @RequestMapping(value="/login",method=RequestMethod.POST,headers = "Accept=application/json")
	 public BaseResponse login(@RequestBody Login login){
	 BaseResponse resp=new BaseResponse();
	 resp= accountService.login(login);
	 return resp;
	 }
	
	
	
	
}
