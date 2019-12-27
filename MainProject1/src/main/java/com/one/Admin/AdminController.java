package com.one.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.one.AccountService;
import com.one.Admin.vo.Pharmacy;
import com.one.vo.Login;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AccountService accountService;
	@RequestMapping(value="/login",method = RequestMethod.POST, headers = "Accept=application/json")
	public void login(@RequestBody Login login) {
		System.out.println("INSIDE THE Login");
		accountService.login(login);
		System.out.println("out");
		
	}
	
	@RequestMapping(value="/insertpharmacy",method = RequestMethod.POST, headers = "Accept=application/json")
	public void insertPharmacy(@RequestBody Pharmacy pharmacy ) {
		System.out.println("INSIDE THE INSERT PHARMACY");
		accountService.insertPharmacy(pharmacy);
		System.out.println("out");
	}
	
	@RequestMapping(value="/deletepharmacy",method = RequestMethod.POST, headers = "Accept=application/json")
	public void deletePharmacy(@RequestBody Pharmacy pharmacy ) {
		System.out.println("INSIDE THE DELETE PHARMACY");
		accountService.deletePharmacy(pharmacy);
		System.out.println("out");
	}
	
}
